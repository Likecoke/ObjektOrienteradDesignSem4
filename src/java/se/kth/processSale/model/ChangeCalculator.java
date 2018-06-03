package se.kth.processSale.model;

import java.util.ArrayList;
import java.util.List;

/** This class is responsible for calculating the change and storing it */
public class ChangeCalculator {

    private List<IncomeObserver> incomeObservers =
            new ArrayList<>();
    /** This constructor creates an instance of ChangeCalculator
     */
    public ChangeCalculator(){

    }
    /** Notifies missing observers
     * @param payedAmount the amount paid by the customer
     * @param change the change given to the customer
     */
    private void notifyIncomeObservers(double payedAmount, double change){
        double payment = payedAmount-change;
        for (IncomeObserver obs: this.incomeObservers){
            obs.paymentDone(payment);

        }

    }
    /** Adds a list of observers that should be notified by the ChangeCalculator
     *@param observers The observers that should be added
     */
    public void addObservers(List<IncomeObserver> observers){
        for (IncomeObserver obs: observers){
            incomeObservers.add(obs);
        }
    }


    /** This method calculates and returns the change
     * @param  payedAmount How much the customer payed
     * @param  totalWithTaxApplied The total after taxes have been applied
     * @return The calculated change stored in a {@link ChangeDTO} object
     * */
    public ChangeDTO calculateChange(double payedAmount, TaxTotalDTO totalWithTaxApplied){
        double change = payedAmount - totalWithTaxApplied.getTotalWithTaxApplied();
        notifyIncomeObservers(payedAmount, change);
        return new ChangeDTO(change, payedAmount);

    }


}
