package se.kth.processSale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.processSale.integration.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReceiptTest {
    Sale sale;
    ChangeCalculator changeCalc;
    CalculateTotalWithTax taxTotalCalc;
    SaleInformationDTO saleInformation;
    Double payedAmount;
    ItemDTO firstItem;
    ItemDTO secondItem;
    Receipt receipt;
    Printer printer;

    @Before
    public void setUp() throws Exception {
        sale = new Sale();
        firstItem = new ItemDTO("aba",20.0, "ketchup");
        secondItem = new ItemDTO("abc",25.0, "senap");
        sale.addItem(secondItem);
        sale.addItem(firstItem);
        taxTotalCalc = new CalculateTotalWithTax(sale.saleStatus());
        payedAmount = new Double(200);
        changeCalc = new ChangeCalculator(payedAmount, taxTotalCalc.getTotalWithTax());
        saleInformation = new SaleInformationDTO(sale.saleStatus(), taxTotalCalc.getTotalWithTax(), changeCalc.getChange());
        printer = new Printer();
        receipt = new Receipt(saleInformation, printer);
    }

    @After
    public void tearDown() throws Exception {
        receipt = null;
        changeCalc = null;
        taxTotalCalc = null;
        saleInformation = null;
        payedAmount = null;
        firstItem = null;
        secondItem = null;
        printer = null;

    }
    @Test
    public void receiptContains(){
        ByteArrayOutputStream capturedPrintedReceipt = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(capturedPrintedReceipt);
        PrintStream oldOut = System.out;
        System.setOut(newOut);
        receipt.sendReceipt();
        System.setOut(oldOut);
        receipt.sendReceipt();
        String printedReceipt = capturedPrintedReceipt.toString();
        TaxTotalDTO taxTotal = taxTotalCalc.getTotalWithTax();
        ChangeDTO change = changeCalc.getChange();
        double totalWithTaxes = taxTotal.getTotalWithTaxApplied();
        double totalWithoutTaxes = taxTotal.getTotalWithoutTaxes();
        String expectedResult = "Receipt\n"+"Items: \n"+
                firstItem.toString() +"\n"+secondItem.toString() +"\n"+
                "Total: "+totalWithoutTaxes+"\n"+
                "Tax: "+(totalWithTaxes-totalWithoutTaxes)+"\n"+
       "Total with Tax: "+totalWithTaxes+"\n"
        +"Amount payed: "+change.getAmountPayed()+"\n"
        +"Change returned: "+change.getChange()+" kr\n";
        assertTrue("Recipe not printed correctly ", printedReceipt.matches(expectedResult));
        assertTrue("Wrong firstItem ", printedReceipt.contains(firstItem.toString()));
        assertTrue("Wrong secondItem ", printedReceipt.contains(secondItem.toString()));
        assertTrue("Wrong Total ", printedReceipt.contains(
                Double.toString(totalWithoutTaxes)));
        assertTrue("Wrong Tax ", printedReceipt.contains(
                Double.toString(totalWithTaxes -totalWithoutTaxes)));
        assertTrue("Wrong Total with Tax ", printedReceipt.contains(
                Double.toString(totalWithTaxes)));
        assertTrue("Wrong amount payed", printedReceipt.contains(
                Double.toString(change.getAmountPayed())));
        assertTrue("Wrong change returned ", printedReceipt.contains(
                Double.toString(change.getChange())));



    }

}