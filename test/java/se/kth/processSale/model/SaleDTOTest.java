package se.kth.processSale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.processSale.integration.ItemDTO;
import static org.junit.Assert.assertEquals;
/** Represents information about a sale  */
public class SaleDTOTest {
    Sale newSale;
    //SaleDTO newSaleDTO;

    @Before
    public void  setUp(){
        newSale = new Sale();
        //newSaleDTO =  newSale.saleStatus();

    }

    @After
    public void tearDown(){
        newSale = null;
        //newSaleDTO = null;

    }


    @Test
    public void  getLatestItemAddedReturnsLatestItemAdded(){
        ItemDTO firstItem = new ItemDTO("abc",200, "mjölk");
        ItemDTO secondItem = new ItemDTO("abcd",200, "kakor");
        newSale.addItem(firstItem);
        newSale.addItem(secondItem);
        boolean result = newSale.saleStatus().getLatestItemAdded().getIdentifier() == secondItem.getIdentifier();
        boolean expectedResult = true;
        assertEquals("Item returned wasn't the latest item added", result, expectedResult);





    }


}
