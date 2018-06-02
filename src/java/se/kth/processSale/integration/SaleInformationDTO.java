package se.kth.processSale.integration;

import se.kth.processSale.model.ChangeDTO;
import se.kth.processSale.model.SaleDTO;
import se.kth.processSale.model.TaxTotalDTO;
/**
 *  DTO that stores information about the finished sale
 */
public class SaleInformationDTO {
    private SaleDTO finishedSale;
    private TaxTotalDTO taxAndTotal;
    private ChangeDTO returnedChange;

    /**
     * Create an instance of <Code>SaleInformationDTO</Code> storing information from the sale
     * @param finishedSale Contains information about items and running total of a sale
     * @param taxAndTotal Contains information about total with and without tax
     * @param returnedChange Contains information about the change returned to customer
     */
    public SaleInformationDTO(SaleDTO finishedSale, TaxTotalDTO taxAndTotal, ChangeDTO returnedChange){
        this.finishedSale = finishedSale;
        this.taxAndTotal = taxAndTotal;
        this.returnedChange = returnedChange;

    }

    /**
     *
     * @return Information about items and running total of the sale
     */
    public SaleDTO getFinishedSale() {
        return finishedSale;
    }

    /**
     * @return Information about total with and without tax of the sale
     */
    public TaxTotalDTO getTaxAndTotal() {
        return taxAndTotal;
    }

    /**
     *
     * @return Information about the change returned to customer
     */
    public ChangeDTO getReturnedChange() {
        return returnedChange;
    }
}
