package se.kth.pos2.view;

import se.kth.pos2.controller.Controller;
import se.kth.pos2.model.NotIdentifiedItemException;
import se.kth.pos2.model.OperationFailedException;

/**
 * View class for this project that handles the user interface.
 * This course does not focus on the view and therefore this class is very simple.
 */
public class View {
    private final Controller contrl;
    /**
     * constructor for the class view. Handles object of type controller.
     * @param contrl is an object of type controller.
     */
    public View(Controller contrl){
        this.contrl = contrl;
    }

    /**
     *  This method act as a fake sale scenario where 4 items are scanned and their ean-codes are sent to
     *  controller. All relevant info about the items are printed out on the screen for the user to see.
     *  The customer pays cash, in this case 500kr, for the purchase.
     */
    public void runFakeSale(){
        Logger consoleLogger = new ConsoleLogger(contrl);
        Logger fileLogger = new FileLogger(contrl);
        contrl.addSaleObserver(new TotalRevenueView());
        try {
            final double cash = 500;

            System.out.println("New sale has begun!");
            System.out.println("*******************************************");
            contrl.scanItem("dsa");
            System.out.println(contrl.itemDescription());
            System.out.printf("Item price" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.itemPriceWithVat());
            System.out.printf("kr.\n");
            System.out.printf("Running total" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.runningTotalDuringScan());
            System.out.printf("kr.\n");
            System.out.println("------------------------------------");

            contrl.scanItem("ads");
            System.out.println(contrl.itemDescription());
            System.out.printf("Item price" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.itemPriceWithVat());
            System.out.printf("kr.\n");
            System.out.printf("Running total" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.runningTotalDuringScan());
            System.out.printf("kr.\n");
            System.out.println("------------------------------------");

            contrl.scanItem("dsa");
            System.out.println(contrl.itemDescription());
            System.out.printf("Item price" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.itemPriceWithVat());
            System.out.printf("kr.\n");
            System.out.printf("Running total" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.runningTotalDuringScan());
            System.out.printf("kr.\n");
            System.out.println("------------------------------------");

            contrl.scanItem("fre");
            System.out.println(contrl.itemDescription());
            System.out.printf("Item price" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.itemPriceWithVat());
            System.out.printf("kr.\n");
            System.out.printf("Running total" + "(" + "incl VAT" + ")" + ": ");
            System.out.printf("%1.2f", contrl.runningTotalDuringScan());
            System.out.printf("kr.\n");
            System.out.println("------------------------------------");

            contrl.payPurchase(cash);
            System.out.println("Change back: " + contrl.showAmountOfChange() + "kr.");
            System.out.println("*******************************************");
            System.out.println();

            contrl.afterPurchaseHandler();

        }catch (NotIdentifiedItemException exc){
            consoleLogger.showErrorMsg("Info about the scanned item could not be found.");
            fileLogger.showErrorMsg("Was not able to show item description during scan due to not being able to find " +
                    "item with EAN barcode: " + "'" + exc.getNotIdentifiedEanCode() + "'");
        }catch (OperationFailedException exc){
            fileLogger.showErrorMsg("ERROR: " + "'" + exc.getMessage()+ "'\n" +
                    "CAUSE: " + exc.getCause().getMessage());
            consoleLogger.showErrorMsg("Can not scan item");
        }catch (Exception exc){
            consoleLogger.showErrorMsg("Failed to scan item, please try again");
        }
    }
}