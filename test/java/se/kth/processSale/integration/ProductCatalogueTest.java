package se.kth.processSale.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductCatalogueTest {
    ProductCatalogue productCatalogue;
    @Before
    public void setUp() throws Exception {
        productCatalogue = new ProductCatalogue();
    }

    @After
    public void tearDown() throws Exception {
        productCatalogue = null;


    }
    @Test
    public void searchItemThatExistsInCatalogue() throws Exception {
        String searchString = "abc1000";
        ItemDTO foundItem = productCatalogue.searchItem(searchString);
        if(foundItem == null){
            fail("Item that exists in catalogue wasn't found by search");
        }
        else{
            boolean result = foundItem.getIdentifier().equals(searchString);
            boolean expectedResult = true;
            assertEquals("Search returned incorrect Item", result, expectedResult);
        }



    }

    //@Test
//    public void searchItemNotInCatalogue()  {
//        String searchString = null;
//        ItemDTO foundItem = productCatalogue.searchItem(searchString);
//        boolean result = foundItem == null;
//        boolean expectedResult = true;
//        assertEquals("Incorrect identifier returned item in catalogue", result, expectedResult);
//
//    }


}