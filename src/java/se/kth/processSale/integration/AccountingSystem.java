package se.kth.processSale.integration;

import se.kth.processSale.model.ChangeDTO;
import se.kth.processSale.model.SaleDTO;
import se.kth.processSale.model.TaxTotalDTO;
import se.kth.processSale.util.Node;

/**
 * Represents an external accounting system
 */
public class AccountingSystem {

    /**
     *  Create an instance of the class representing an external accounting system
     */
    public AccountingSystem(){


    }

    /**
     * Send information about a sale to the external accounting system
     * @param saleInformationDTO Contains Information about a completed sale
     */
    public void sendSaleInformation(SaleInformationDTO saleInformationDTO){
        SaleDTO finishedSale = saleInformationDTO.getFinishedSale();
        sendListOfItemsSold(finishedSale.getItemList());
        sendReturnedChange(saleInformationDTO.getReturnedChange());
        sendTaxAndTotal(saleInformationDTO.getTaxAndTotal());

    }

    /**
     * Send information about the items sold in a sale to the external accounting system
     * @param itemsSold A list representing the items sold
     */
    public void sendListOfItemsSold (Node<ItemDTO> itemsSold){
        //Send Items sold to external System
    }

    /**
     * Send information about the change given in the sale to the external accounting system
     * @param change Contains information about the change given to the customer in a sale
     */
    public void sendReturnedChange(ChangeDTO change){
        //code

    }

    /**
     * Send information about the total with and without tax of a sale to the
     * external accounting system
     * @param taxAndTotal Contains information about the total with and without tax of a sale
     */
    public void sendTaxAndTotal(TaxTotalDTO taxAndTotal){
        //code

    }
}
