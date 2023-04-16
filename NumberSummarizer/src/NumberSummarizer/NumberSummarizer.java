package NumberSummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** NumberSummarizer
 * 
 * @version JDK 17.0.6
 * @author Samuel Dudley
 * 
 * Class that retrieves numbers from an input string and outputs a neat summary of them
 * 
 * Date
 *  2023/04/17
 * 
 * Copyright
 *  This software was developed by Samuel Dudley, the sole author, and any redistribution of this software
 *  without appropriate referencing is strictly forbidden
 *
 */
public class NumberSummarizer implements NumberRangeSummarizer{
    StringBuilder outStrBuilder;

    /**
     * Constructor for NumberSummarizer
     */
    public NumberSummarizer() {
        this.outStrBuilder = new StringBuilder();
    }
           
    /**
     * Splits an input String to retrieve a series of integers
     * 
     * @param input String value that represents a series of numbers
     * @return the series of numbers stored in a Collection
     */
    @Override
    public Collection<Integer> collect(String input) {
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        try {                                    

            //retrieving the numbers from the input String by splitting them with a delimeter
            String[] numStrings = input.split(",");

            //iterating over the list of number Strings and adding each one to the Collection of integers to return
            for(int x = 0; x<numStrings.length; x++){
                nums.add(Integer.parseInt(numStrings[x]));
            }
            
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the input number string:\n"+e.getMessage());
            e.printStackTrace();
        }
        finally{
            return nums;
        }
    }

    /**
     * 
     * @param input Collection containing numbers to summarize
     * @return String value representing a summarized list of numbers
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        
        ArrayList<Integer> numsInput = new ArrayList<>(input);
        
        try {

            //returning a 0 if the collection is empty and the unchanged collection if it contains only one value
            if (numsInput.size() < 1)
                return "0";
            else if (numsInput.size() == 1)
                return numsInput.get(0).toString();
            
            Collections.sort(numsInput);                //sorting the numbers in ascending order

            int rangeStart, originalIndex; 

            for (int x = 0; x < numsInput.size(); x++){  
                rangeStart = numsInput.get(x);          //retrieve the number that will begin the next range of numbers
                originalIndex = x;                      //saving the original value of x

                //while x+1 corresponds to a valid cell in the ArrayList and the number adjacent to x is sequential to it...           
                while ((x<numsInput.size()-1) &&((numsInput.get(x+1)) == (numsInput.get(x)+1))){

                    //increment x to indicate that we need to shif the current range of numbers to include one more adjacent cell                             
                    x++;        
                }                              

                //if the current index of x is 2 or more than the original index it indicates there are numbers to summarize with a hyphen
                if (x-originalIndex >= 2){
                    outStrBuilder.append(rangeStart+"-"+numsInput.get(x)+","); 
                }

                /*if the original index of x differs from the current index of x it indicates that sequential numbers were found
                * and that a hyphen must be added to indicate a summarized range of numbers
                */
                else if (x != originalIndex){                
                    outStrBuilder.append(rangeStart+","+(rangeStart+1)+",");
                }

                //if no sequential numbers are found add the original value of cell x to the output string
                else {
                    outStrBuilder.append(rangeStart+",");
                }                          
            }             
        } catch (Exception e){
                System.out.println("An error occurred while generating the summarized number list:\n"+e.getMessage());
                e.printStackTrace();
        } finally {            
                //truncating the trailing comma from the output string before returning it
                String outStr = outStrBuilder.toString();
                outStr = outStr.substring(0, outStr.length()-1);

                return outStr;
        }
        
    }
    
}
