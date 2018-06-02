package se.kth.processSale.model;
/** This class is responsible for calculating the new total after taxes have been applied and storing both in a
 * {@link TaxTotalDTO} object.
  */
public class CalculateTotalWithTax {
    private final double TAX_RATE = 0.25;
    private final double total;
    private final double totalWithTaxApplied;


    /** Create an instance of CalculateTotalWithTax applying taxes to the total stored in the {@link SaleDTO} object
     * @param  currentSale object representing a sale contains information about the total */
    public CalculateTotalWithTax(SaleDTO currentSale){
        this.total = currentSale.getRunningTotal();
        this.totalWithTaxApplied = total + total*TAX_RATE;

    }

    /** @return {@link TaxTotalDTO} representing the total and total after taxes have been applied */
    public  TaxTotalDTO getTotalWithTax(){
        return new TaxTotalDTO(total, totalWithTaxApplied);
    }
}
