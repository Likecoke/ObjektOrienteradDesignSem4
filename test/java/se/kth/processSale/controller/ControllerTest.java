package se.kth.processSale.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.processSale.integration.AccountingSystem;
import se.kth.processSale.integration.InventorySystem;
import se.kth.processSale.integration.Printer;
import se.kth.processSale.integration.ProductCatalogue;
import se.kth.processSale.model.*;

import static org.junit.Assert.*;

public class ControllerTest {
    Controller controller;
    ProductCatalogue productCatalogue;

    @Before
    public void setUp() throws Exception {
        AccountingSystem accountingSystem = new AccountingSystem();
        InventorySystem invSystem = new InventorySystem();
        productCatalogue = new ProductCatalogue();
        Printer printer = new Printer();
        controller = new Controller(accountingSystem, invSystem, productCatalogue, printer);

    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        productCatalogue = null;
    }

    @Test
    public void beginSale() throws Exception {

    }

    @Test
    public void searchingForExistingItem() throws Exception {
        String itemIdentifier = "abc1000";
        controller.beginSale();
        SaleDTO sale = controller.searchItem(itemIdentifier);
        boolean result = sale.getLatestItemAdded().getIdentifier().equals(itemIdentifier);
        assertTrue("Searching for an existing item didn't add it to the returned SaleDTO", result);

    }

    //@Test
//    public void searchingForNonExistingItem() throws Exception {
//        String itemIdentifier = "abc2000";
//        SaleDTO sale = controller.searchItem(itemIdentifier);
//        boolean result = sale.getLatestItemAdded().getIdentifier().equals(itemIdentifier);
//        assertTrue("Searching for an existing item didn't add it to the returned SaleDTO", result);
//
//    }


    @Test
    public void correctTotalWithTaxReturnedWhenAllItemsRegistered() throws Exception {
        controller.beginSale();
        Sale comparisonSale = new Sale();
        controller.searchItem("abc1001");
        controller.searchItem("abc1002");
        TaxTotalDTO controllerTotalWithTax = controller.allItemsRegistered();
        comparisonSale.addItem(productCatalogue.searchItem("abc1001"));
        comparisonSale.addItem(productCatalogue.searchItem("abc1002"));
        TaxTotalDTO comparisonSaleTotalWithTax = new CalculateTotalWithTax(comparisonSale.saleStatus()).getTotalWithTax();
        boolean resultTotalWithTaxApplied = controllerTotalWithTax.getTotalWithTaxApplied() ==
                comparisonSaleTotalWithTax.getTotalWithTaxApplied();
        boolean resultTotalWithoutTax = controllerTotalWithTax.getTotalWithoutTaxes() ==
                comparisonSaleTotalWithTax.getTotalWithoutTaxes();
        assertTrue("Wrong totalWithTax", resultTotalWithTaxApplied);
        assertTrue("Wrong total", resultTotalWithoutTax);

    }

    @Test
    public void correctChangeReturned() throws Exception {
        controller.beginSale();
        controller.searchItem("abc1001");
        controller.searchItem("abc1002");
        TaxTotalDTO taxAndTotal = controller.allItemsRegistered();
        double paymentAmount = 200;
        ChangeCalculator comparsionChangeCalculator = new ChangeCalculator(paymentAmount, taxAndTotal);
        ChangeDTO comparisonChange = comparsionChangeCalculator.getChange();
        ChangeDTO changeReturnedFromController = controller.enterPayment(paymentAmount);
        boolean result = comparisonChange.getChange() == changeReturnedFromController.getChange();
        boolean expectedResult = true;
        assertEquals("Change amount returned from controller is incorrect", result, expectedResult);
        result = comparisonChange.getAmountPayed() == changeReturnedFromController.getAmountPayed();
        expectedResult = true;
        assertEquals("Amount payed returned from controller is incorrect", result, expectedResult);



    }

}