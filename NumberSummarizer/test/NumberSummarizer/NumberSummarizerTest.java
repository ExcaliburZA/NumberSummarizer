package NumberSummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/** NumberSummarizerTest
 * 
 * @version JDK 17.0.6
 * @author Samuel Dudley
 * 
 * Test class for the NumberSummarizer class methods
 * 
 * Date
 *  2023/04/17
 * 
 * Copyright
 *  This software was developed by Samuel Dudley, the sole author, and any redistribution of this software
 *  without appropriate referencing is strictly forbidden
 * 
 */
public class NumberSummarizerTest {
    NumberSummarizer numberSummarizer;
    
    public NumberSummarizerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        numberSummarizer = new NumberSummarizer();
    }
    
    @After
    public void tearDown() {
        numberSummarizer = null;
    }

    /**
     * Test of collect method, of class NumberSummarizer.
     */
    @Test
    public void testCollect() {
        final String STR_NUMS = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        ArrayList<Integer> result = (ArrayList<Integer>) this.numberSummarizer.collect(STR_NUMS);
        final ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        
        assertEquals(expected, result);
        
        final String STR_NUMS_2 = "1,2,3,4,6,7,9,10,11,13,14,16,17,18,19";
        ArrayList<Integer> result2 = (ArrayList<Integer>) this.numberSummarizer.collect(STR_NUMS_2);
        final ArrayList<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,9,10,11,13,14,16,17,18,19));
        
        assertEquals(expected2, result2);
    }

    /**
     * Test of summarizeCollection method, of class NumberSummarizer.
     */
    @Test
    public void testSummarizeCollection() {
        ArrayList<Integer> NUMS = new ArrayList<Integer>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        String result = numberSummarizer.summarizeCollection(NUMS);
        String expected = "1,3,6-8,12-15,21-24,31";       
        
        assertEquals(expected, result);               
        
        ArrayList<Integer> NUMS_2 = new ArrayList<Integer>(Arrays.asList(5));
        String result2 = numberSummarizer.summarizeCollection(NUMS_2);
        String expected2 = "5"; 
        
        assertEquals(expected2, result2);  
        
        ArrayList<Integer> NUMS_3 = new ArrayList<Integer>();
        String result3 = numberSummarizer.summarizeCollection(NUMS_3);
        String expected3 = "0"; 
        
        assertEquals(expected3, result3);               
    }
    
}
