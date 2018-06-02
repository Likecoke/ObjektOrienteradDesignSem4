package se.kth.processSale.integration;

import se.kth.processSale.model.SaleDTO;
import se.kth.processSale.util.Node;

/**
 * Represents an external inventory system
 */
public class InventorySystem {

    /**
     * Create an instance of the inventory system
     */
    public InventorySystem(){

    }

    /**
     * Sends information about a sale to the external inventory system
     * @param saleInformationDTO Contains information about a completed sale
     */
    public void sendSaleInformation(SaleInformationDTO saleInformationDTO){
        SaleDTO finishedSale = saleInformationDTO.getFinishedSale();
        Node<ItemDTO> itemsSold = finishedSale.getItemList();
        sendListOfItemsSold(itemsSold);

    }

    /**
     * send a list of the sold item to the external system
     * @param itemsSold List of sold items
     */
    private void sendListOfItemsSold(Node<ItemDTO> itemsSold){
        //Send Items sold to external System
    }
}
