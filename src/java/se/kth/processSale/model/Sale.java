package se.kth.processSale.model;

import se.kth.processSale.integration.ItemDTO;
import se.kth.processSale.util.Node;
/** An object representing a sale   */
public class Sale {
    private double runningTotal;
    private Node<ItemDTO> itemList;

    /** Begin the sale with no items yet added and runningTotal set to 0   */
    public Sale(){
        this.runningTotal = 0;
        this.itemList = null;

    }
    /** Adds an item to the sale and calculates the new runningTotal
     * @param item the item to be added to the sale, represented as an {@link ItemDTO} object  */
    public void addItem(ItemDTO item){
        Node<ItemDTO> newItem = new Node<ItemDTO>();
        runningTotal += item.getPrice();
        newItem.item = item;
        newItem.next = itemList;
        itemList = newItem;


    }
    /** Return information about the runningTotal of the sale and items in the sale
     * @return  Information about the sale stored in a {@link SaleDTO} object.   */
    public SaleDTO saleStatus(){
        return new SaleDTO(this.runningTotal,Node.copyList(itemList));
    }



}
