package se.kth.processSale.model;
/** Represents the amount of change given to the customer, immutable   */
public class ChangeDTO {
    private final double amountPayed;
    private final double change;

    /** initialize the object with the given change amount
     * @param change The amount of change that this object represents  */
    public ChangeDTO(double change, double amountPayed){
        this.change = change;
        this.amountPayed = amountPayed;
    }

    /** @return The amount of change represented by the object  */
    public double getChange() {
        return change;
    }
    public double getAmountPayed(){
        return amountPayed;
    }
}
