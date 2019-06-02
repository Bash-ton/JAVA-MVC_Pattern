package se.kth.pos2.model;

/**
 * Checked exception for when an item scanned can not be identified.
 */
public class NotIdentifiedItemException extends Exception{
    private String notIdentifiedEanCode;

    /**
     * method that stores the eanCode of the item that could not be identified.
     * @param notIdentifiedEanCode
     */
    public NotIdentifiedItemException(String notIdentifiedEanCode){
        super("Unable to find scanned item with EAN barcode: " + "'" + notIdentifiedEanCode + "'.");
        this.notIdentifiedEanCode = notIdentifiedEanCode;
    }

    /**
     * returns the eanCode of the item that could not get identified.
     * @return an eanCode of type String.
     */
    public String getNotIdentifiedEanCode(){
        return notIdentifiedEanCode;
    }
}