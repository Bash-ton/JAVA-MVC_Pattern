package se.kth.pos2.integration;


import se.kth.pos2.model.Sale;

/**
 * This class is a printer and prints a receipt.
 */
public class Printer {
    private final ReceiptDto receipt;
    private ItemDto item;

    /**
     * This is a constructor that receives an object of type ReceiptDto.
     * @param receipt is an object of type ReceiptDto.
     */
    public Printer(ReceiptDto receipt){
        this.receipt = receipt;
    }

    /**
     * This method prints all relevant info about a sale. All relevant info is retrieved from the ReceiptDto object
     * and the Sale object.
     * @param sale an object of type Sale.
     */
    public void printReceipt(Sale sale){
        System.out.println("Receipt");
        System.out.println("===============================================");
        System.out.println("Store Name: " + receipt.getSTORENAME());
        System.out.println("Store Address: " + receipt.getADDRESS());
        System.out.println("Time and Date of Purchase: " + receipt.getDateAndTime());
        System.out.printf("%-28s%-15s%-20s%-5s\n", "Item","Quantity","Price(excl VAT)","VAT");

        int i = 0;
        while (i < receipt.getItemsPurchasedList().size()){
            item = (ItemDto) receipt.getItemsPurchasedList().get(i);
            System.out.printf("%-28s%-15s%-20s%-5s\n", item.getDescription(),item.getNumberOfSameItems(),item.getPrice()*item.getNumberOfSameItems()+"kr",item.getNumberOfSameItems()*item.getPrice()*item.getVat()/100 + "kr");
            i++;
        }
        System.out.println("-------------------------------------------");
        System.out.printf("Running Total: " );
        System.out.printf("%1.2f",receipt.getRunningTotal());
        System.out.println("kr.");
        System.out.println("Cash payed: " + sale.getCash()+"kr");
        System.out.println("Change back: " + sale.getChange()+"kr");
        System.out.println("===============================================");
    }
}
