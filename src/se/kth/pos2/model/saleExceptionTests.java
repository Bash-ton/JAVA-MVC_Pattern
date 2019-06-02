package se.kth.pos2.model;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class that tests all exceptions in this sale.
 */
public class saleExceptionTests {

    /**
     * Tests that the correct exception is thrown when an item's ean code is not found in the register.
     * @throws OperationFailedException a wide and general checked exception for failed operations.
     * @throws NotIdentifiedItemException a checked exception for items not being able to get identified.
     */
    @Test(expected = NotIdentifiedItemException.class)
    public void getItemInfoDuringScanNotInRegister() throws OperationFailedException, NotIdentifiedItemException {
        String eanCode = "re";
        Sale saleTest = new Sale();
        saleTest.scanItem(eanCode);
        saleTest.getItemInfoDuringScan();
    }

    /**
     * Checks that OperationFailedException has the correct eanCode in error message.
     * @throws OperationFailedException a wide and general checked exception for failed operations.
     */
    @Test
    public void getItemInfoDuringScanFail() throws OperationFailedException {
        String eanCode = "fr";
        try {
            Sale saleTest = new Sale();
            saleTest.scanItem(eanCode);
            saleTest.getItemInfoDuringScan();
        }catch (NotIdentifiedItemException exc){
            assertTrue("Does not contain the correct eanCode in exception message:" + "'" + eanCode + "'",exc.getMessage().contains(eanCode));
        }
    }

    /**
     * Tests that the correct exception is thrown when a dataBase failure exception is thrown in the Sale.
     * @throws OperationFailedException a wide and general checked exception for failed operations.
     * @throws NotIdentifiedItemException a checked exception for items not being able to get identified.
     */
    @Test(expected = OperationFailedException.class)
    public void getItemInfoDuringScanDataBaseFailure() throws OperationFailedException, NotIdentifiedItemException {
            String eanCode = "DATABASE";
            Sale saleTest = new Sale();
            saleTest.scanItem(eanCode);
            saleTest.getItemInfoDuringScan();
    }
    /**
     * Checks that NotIdentifiedItemException has the correct eanCode in error message.
     * @throws NotIdentifiedItemException
     */
    @Test
    public void getItemInfoDuringScanFai() throws NotIdentifiedItemException {
        String eanCode = "DATABASE";
        try {
            Sale saleTest = new Sale();
            saleTest.scanItem(eanCode);
            saleTest.getItemInfoDuringScan();
        }catch (OperationFailedException exc){
            assertTrue(exc.getCause().getMessage().contains(eanCode));
        }
    }
    /**
     * Checks that the method does not throw exceptions in a successful run.
     * @throws OperationFailedException a wide and general checked exception for failed operations.
     * @throws NotIdentifiedItemException a checked exception for items not being able to get identified.
     */
    @Test
    public void getItemInfoDuringScanSuccess() throws OperationFailedException, NotIdentifiedItemException {
            String eanCode = "fre";
            Sale saleTest = new Sale();
            saleTest.scanItem(eanCode);
            saleTest.getItemInfoDuringScan();
    }
}
