package se.kth.processSale.model;
/** This class is responsible for calculating the change and storing it */
public class ChangeCalculator {
    private ChangeDTO change;
    /** This constructor creates an instance of ChangeCalculator, storing the change calculated from
     * the given parameters
     * @param  payedAmount How much the customer payed
     * @param  totalWithTaxApplied The total after taxes have been applied
     */
    public ChangeCalculator(double payedAmount, TaxTotalDTO totalWithTaxApplied){
        double calculatedChange = payedAmount - totalWithTaxApplied.getTotalWithTaxApplied();
        change = new ChangeDTO(calculatedChange, payedAmount);

    }
    /** This method returns the stored change
     * @return The {@link ChangeDTO} object stored in the current instance
     * */
    public ChangeDTO getChange() {
        return this.change;
    }
}
