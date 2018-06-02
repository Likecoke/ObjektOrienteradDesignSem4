package se.kth.processSale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTotalWithTaxTest {
    SaleDTO sale;
    CalculateTotalWithTax calculateTotalWithTax;
    Double givenRunningTotal;

    @Before
    public void setUp() throws Exception {
        givenRunningTotal = new Double(200);
        sale = new SaleDTO(givenRunningTotal, null);
        calculateTotalWithTax = new CalculateTotalWithTax(sale);
    }

    @After
    public void tearDown() throws Exception {
        sale = null;
        calculateTotalWithTax = null;
        givenRunningTotal = null;

    }

    @Test
    public void runningTotalReturnedCorrectly() throws Exception {
        double returnedRunningTotal = calculateTotalWithTax.getTotalWithTax().getTotalWithoutTaxes();
        boolean expectedResult = true;
        boolean result = returnedRunningTotal == givenRunningTotal;
        assertEquals("RunningTotal was unexpectedly modified", result, expectedResult);

    }
    @Test
    public void taxNotApplied() throws Exception{
        double returnedTotalWithTaxApplied = calculateTotalWithTax.getTotalWithTax().getTotalWithTaxApplied();
        boolean result = givenRunningTotal == returnedTotalWithTaxApplied;
        boolean expectedResult = false;
        assertEquals("Tax wasn't applied to runningTotal", result, expectedResult);

    }

}