package se.kth.pos2.model;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A test class for the PaymentCalculator class.
 */
public class PaymentCalculatorsTest {
    private PaymentCalculator instance;

    /**
     * This test makes sure that the change will show a negative value if
     * the amount of cash is less than the running total.
     */
    @Test
    public void changeCalculatorNotEnoughCash() throws NotIdentifiedItemException, OperationFailedException {
        Sale sale = new Sale();
        sale.scanItem("fre");
        sale.setCash(36.24);
        sale.getItemInfoDuringScan();
        instance = new PaymentCalculator(sale);
        instance.changeCalculator();
        double result = instance.getChange();
        assertTrue("Cash is not enough and change has to be negative",result < 0);
    }

    /**
     * This test checks that the change is calculated correctly.
     */
    @Test
    public void testChangeCalculator()throws NotIdentifiedItemException, OperationFailedException {
        Sale sale = new Sale();
        sale.scanItem("fre");
        sale.setCash(200);
        sale.getItemInfoDuringScan();
        instance = new PaymentCalculator(sale);
        instance.changeCalculator();
        double result = instance.getChange();
        double expResult = 200 - 36.25;
        assertEquals("Change doesn't have the correct amount", expResult, result, 0);
    }

    /**
     * This test makes sure the getter method returns the correct amount of change.
     */
    @Test
    public void getChange() throws NotIdentifiedItemException, OperationFailedException{
        Sale sale = new Sale();
        sale.scanItem("fre");
        sale.setCash(200);
        sale.getItemInfoDuringScan();
        instance = new PaymentCalculator(sale);
        instance.changeCalculator();
        double result = instance.getChange();
        double expResult = sale.getCash() - sale.getRunningTotal();
        assertEquals("getChange does not return the correct change value", expResult, result, 0);
    }
}