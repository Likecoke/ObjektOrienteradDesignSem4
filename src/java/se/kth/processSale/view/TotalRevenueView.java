package se.kth.processSale.view;

import se.kth.processSale.model.IncomeObserver;

/** Implements the interface <Code>IncomeObserver</Code>. The class observes the class <Code>ChangeCalculator</Code>
 *  keeping track of whenever a payment has been done by the customer in a sale.
 */
public class TotalRevenueView implements IncomeObserver{
    private double currentRevenue;

    /**Initialize the class setting the current revenue to 0 */
    public TotalRevenueView(){
        this.currentRevenue = 0;

    }

    /** A notification is given to the class that a payment has been done in a sale so that it can update its revenue
     * the current revenue of the sale is written to standard out.
     * @param paidAmount the amount paid by the customer
     */
    @Override
    public void paymentDone(double paidAmount){
        this.currentRevenue+=paidAmount;
        String message = "Total revenue since start of program: " + this.currentRevenue + " kr";
        System.out.println(message);
    }


}
