package se.kth.processSale.model;
/** Represents the total from a sale and the same total after taxes have been applied  */
public class TaxTotalDTO {
    private final double totalWithoutTaxes;
    private final double totalWithTaxApplied;

    /** Create an instance to represent the total before and after taxes have been applied
     * @param total The total without taxes applied
     * @param totalWithTaxApplied The total after the taxes have been applied */
    public  TaxTotalDTO(double total, double totalWithTaxApplied){
        this.totalWithoutTaxes = total;
        this.totalWithTaxApplied = totalWithTaxApplied;
    }
    /** @return the total without taxes applied  */
    public double getTotalWithoutTaxes() {
        return totalWithoutTaxes;
    }
    /** @return the total with taxes applied */
    public double getTotalWithTaxApplied() {
        return totalWithTaxApplied;
    }
}
