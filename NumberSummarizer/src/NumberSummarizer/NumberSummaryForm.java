
package NumberSummarizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/** NumberSummaryForm
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
 */

public class NumberSummaryForm extends javax.swing.JFrame {
    ArrayList<Integer> nums = new ArrayList<>();
    StringBuilder inputStringBuilder = new StringBuilder();
    String numString;
    NumberSummarizer numSummarizer;

    /**
     * Constructor for the form class that initializes and styles the components
     */
    public NumberSummaryForm() {
        numSummarizer = new NumberSummarizer();
        initComponents();
        StyleComps();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        lblAddNum = new javax.swing.JLabel();
        lblOutputHeading = new javax.swing.JLabel();
        txtNumIn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpOut = new javax.swing.JTextPane();
        btnAddToList = new javax.swing.JButton();
        btnViewSummary = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAddNum.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblAddNum.setText("Enter a number to add to the list:");

        lblOutputHeading.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblOutputHeading.setText("Number summary: ");

        jScrollPane1.setViewportView(tpOut);

        btnAddToList.setText("Add to list");
        btnAddToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToListActionPerformed(evt);
            }
        });

        btnViewSummary.setText("View summary");
        btnViewSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSummaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddNum)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddToList)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnViewSummary))
                                    .addComponent(txtNumIn)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblOutputHeading)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddToList, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lblOutputHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * styles the buttons
     */
    private void StyleComps(){
        btnAddToList.setBackground(Color.LIGHT_GRAY);
        btnViewSummary.setBackground(Color.LIGHT_GRAY); 
    }
    
    /** 
     * Listener method that adds a number to the list when the user performs an action this button
     * @param evt ActionEvent that is triggered when the user performs an action on this button
     */
    private void btnAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToListActionPerformed
        
        String input = txtNumIn.getText().trim();
        try {
            int inNum = Integer.parseInt(input);
            inputStringBuilder.append(input+",");
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer value");
        }                     
    }//GEN-LAST:event_btnAddToListActionPerformed

    /** 
     * Listener method that generates an outputs a summarized list of numbers
     * @param evt ActionEvent that is triggered when the user performs an action on this button
     */
    private void btnViewSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSummaryActionPerformed
   
        //truncating the trailing comma from the input string
        numString = inputStringBuilder.toString();
        numString = numString.substring(0, numString.length()-1);
        
        nums = (ArrayList<Integer>) numSummarizer.collect(numString);
        
        //generating a summary of the inputted numbers
        String outStr = numSummarizer.summarizeCollection(nums);
               
        tpOut.setText(outStr);      //outputting the summarized number list       
    }//GEN-LAST:event_btnViewSummaryActionPerformed

    /** 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form that will be used to generate the number summary */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberSummaryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToList;
    private javax.swing.JButton btnViewSummary;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddNum;
    private javax.swing.JLabel lblOutputHeading;
    private javax.swing.JTextPane tpOut;
    private javax.swing.JTextField txtNumIn;
    // End of variables declaration//GEN-END:variables
}
