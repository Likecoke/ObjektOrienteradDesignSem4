package se.kth.processSale.model;

import se.kth.processSale.integration.ItemDTO;
import se.kth.processSale.util.Node;
/** Represents information about a sale  */
public class SaleDTO {
    private double runningTotal;
    private Node<ItemDTO> itemList;

    /** Create an instance to represent the runningTotal and items of a sale */
    public SaleDTO(double runningTotal, Node<ItemDTO> itemList){
        this.runningTotal = runningTotal;
        this.itemList = itemList;

    }

    /**
     * returns a list of all the items in the sale
     * @return the list of items
     */
    public Node<ItemDTO> getItemList() {
        return itemList;
    }

    /**
     * Returns the running total of the sale
     * @return sale running total
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * Returns the last item added to the sale
     * @return the last item added
     */
    public ItemDTO getLatestItemAdded(){

        return itemList.item;
    }


}
