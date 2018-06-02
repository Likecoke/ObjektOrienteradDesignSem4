package se.kth.processSale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeCalculatorTest {
    final double payedAmount = 200;
    final double runningTotalWithoutTax = 100;
    final double runningTotalWithTax = 100 + 100*0.25;
    TaxTotalDTO taxAndTotal;
    ChangeCalculator changeCalculator;



    @Before
    public void setUp() throws Exception {
        taxAndTotal = new TaxTotalDTO(runningTotalWithoutTax, runningTotalWithTax);
        changeCalculator = new ChangeCalculator(payedAmount, taxAndTotal);
    }

    @After
    public void tearDown() throws Exception {
        taxAndTotal = null;

    }

    @Test
    public void changeCalculatedCorrectly() throws Exception {
       boolean result =  changeCalculator.getChange().getChange() == payedAmount - runningTotalWithTax;
       boolean expectedResult = true;
       assertEquals("Change wasn't correctly calculated", result, expectedResult);
    }

}