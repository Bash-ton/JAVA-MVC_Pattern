package se.kth.pos2.integration;

/**
 * An unchecked exception for when a data base failure occurs in the ItemRegistry class.
 */
public class ItemRegistryDataBaseException extends RuntimeException {
    /**
     * method for storing the eanCode, as a string, that led to the data base failure.
     * @param ean a String that contains the eanCode of an item.
     */
    public ItemRegistryDataBaseException(String ean){
        super("EAN code: " + "'" + ean + "'");
    }
}
