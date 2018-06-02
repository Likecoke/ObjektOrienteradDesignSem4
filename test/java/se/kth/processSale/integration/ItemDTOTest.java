package se.kth.processSale.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDTOTest {
    ItemDTO item;
    @Before
    public void setUp() throws Exception {
        item= new ItemDTO("abc", 200, "A piece of cake");
    }

    @After
    public void tearDown() throws Exception {
        item = null;
    }

//    @Test
//    public void getIdentifier() throws Exception {
//    }
//
//    @Test
//    public void getPrice() throws Exception {
//    }
//
//    @Test
//    public void getItemDescription() throws Exception {
//    }

    @Test
    public void toStringTest() throws Exception {
        String itemAsString = item.toString();
        boolean result = itemAsString.equals("Item identifier: " + item.getIdentifier() + ", "
                +"Description: " + item.getItemDescription() + ", "+
                "Price: " + item.getPrice()+ " ");
        boolean expectedResult = true;
        assertEquals("toString method doesn't produce expected string", expectedResult, result);
    }

}