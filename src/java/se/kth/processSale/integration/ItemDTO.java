package se.kth.processSale.integration;

/**
 * DTO storing information about an item
 */
public class ItemDTO {
    private final String identifier;
    private final double price;
    private final String itemDescription;

    /**
     * Create a DTO representing an item
     * @param identifier The items unique identifier
     * @param price The price of the item
     * @param itemDescription Describes the item
     */
    public ItemDTO(String identifier, double price, String itemDescription){
        this.identifier = identifier;
        this.price = price;
        this.itemDescription = itemDescription;
    }

    /**
     *
     * @return The items identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return The price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return A description of the item
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Overloads the Object class toString method
     * @return A String containing information about the item
     */
    public String toString(){
        return  "Item identifier: " + this.identifier + ", "+
        "Description: " + this.itemDescription + ", "+
                "Price: " + this.price + " ";
    }




}
