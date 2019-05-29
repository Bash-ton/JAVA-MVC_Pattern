package se.kth.pos2.integration;

/**
 * This class handles the communication between this program and the data base. This course doesn't handle
 * the data base therefore this class ends here.
 */
public class UpdateInventoryDbHandler {
    private final ReceiptDto receipt;

    /**
     * This is a constructor so store a ReceiptDTO of a sale.
     * @param receipt of type receiptDTO.
     */
    public UpdateInventoryDbHandler(ReceiptDto receipt){
        this.receipt = receipt;

    }

    /**
     * This method use a sale's receipt to update every item sold to a data base.
     * Since this project doesn't include a data base, this method ends here.
     */
    public void setInventoryDbHandler(){


    }

}
