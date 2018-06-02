package se.kth.processSale.integration;

/**
 * Stores information about items available for purchase
 */
public class ProductCatalogue {
    private ItemDTO[] items;

    /**
     * Create an instance of productCatalogue creating the items stored there
     */
    public ProductCatalogue(){
        items = new ItemDTO[5];
        items[0] = new ItemDTO("abc1000", 25.99, "Butter");
        items[1] = new ItemDTO("abc1001", 12, "Milk");
        items[2] = new ItemDTO("abc1002", 20, "Bread");
        items[3] = new ItemDTO("abc1003", 7.5, "Banana");
        items[4] = new ItemDTO("abc1004", 120, "Ham");


    }

    /**
     * Search for an item with the given identifier
     * @param identifier String that identifies the item
     * @return The searched for item or null if it wasn't found
     */
    public ItemDTO searchItem(String identifier){

        for(int i = 0; i<items.length; i++){
            if(items[i].getIdentifier().equals(identifier)){
                return items[i];
            }
        }

        return null;

    }



}
