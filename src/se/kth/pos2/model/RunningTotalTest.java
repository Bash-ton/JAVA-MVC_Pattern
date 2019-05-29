package se.kth.pos2.model;

import org.junit.Test;
import se.kth.pos2.integration.ItemDto;

import static org.junit.Assert.*;

/**
 * A test class for the RunningTotal class.
 */
public class RunningTotalTest {

    /**
     * This test checks if the initial running total value is set to 0 before any item has been scanned.
     * This test also checks if the price and vat for an item is correctly calculated.
     * This test also checks if the running total updates correctly after first and second scanned item.
     */
    @Test
    public void testCalculateItemPriceWithVatAndRunningTotal() {
        RunningTotal runTot = new RunningTotal();
        ItemDto item = new ItemDto(45.59,"Soda VAT-Rate 6%",6,1);
        assertTrue("RunningTotal is not equal to 0 before any item has been scanned", runTot.getRunningTotal()==0);
        runTot.calculateItemPriceWithVatAndRunningTotal(item);
        double result = runTot.getItemPriceWithVat();
        double expResult = 45.59 * 1.06;
        assertEquals("Item price with VAT is not correct",expResult,result,0);
        assertEquals("Running Total is not correct after the first scanned item ",runTot.getItemPriceWithVat(),runTot.getRunningTotal(),0);
        runTot.calculateItemPriceWithVatAndRunningTotal(item);
        assertEquals("Running Total is not correct after a second item has been scanned",runTot.getItemPriceWithVat()*2,runTot.getRunningTotal(),0);
    }

    /**
     * A test method for the getItemPriceWithVat method. This test checks that the method returns the correct value
     * for an item's price including vat.
     */
    @Test
    public void testGetItemPriceWithVat() {
        RunningTotal runTot = new RunningTotal();
        ItemDto item = new ItemDto(45.59,"Soda VAT-Rate 6%",6,1);
        double expResult = 45.59 * 1.06;
        runTot.calculateItemPriceWithVatAndRunningTotal(item);
        assertEquals("getItemPriceWithVat doesn't return the correct amount", expResult, runTot.getItemPriceWithVat(),0);
    }

    /**
     * A test method for the getRunningTotal method. This test checks that the method
     * returns the correct amount of running total.
     */
    @Test
    public void testGetRunningTotal() {
        RunningTotal runTot = new RunningTotal();
        ItemDto item = new ItemDto(45.59,"Soda VAT-Rate 6%",6,1);
        double expResult = 45.59 * 1.06;
        runTot.calculateItemPriceWithVatAndRunningTotal(item);
        assertEquals("getRunningTotal doesn't return the correct amount", expResult, runTot.getRunningTotal(),0);
    }
}