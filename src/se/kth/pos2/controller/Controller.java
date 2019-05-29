package se.kth.pos2.controller;

import se.kth.pos2.model.*;

/**
 * Class that function as a controller for this project. It handles all communication between user interface and the model
 */
public class Controller {
    private Sale sale = new Sale();

    /**
     * Calls method scanitem in the class Sale in the model package.
     * @param eanCode an EAN-barcode of an item stored as a string.
     */
    public void scanItem(String eanCode){
        sale.scanItem(eanCode);
    }

    /**
     * Calls the model to return an item's description during a scan.
     * @return an item's description.
     */
    public String itemDescription(){
        return sale.getItemDescription(sale.getItemInfoDuringScan());
    }

    /**
     * Calls the model to return an item's price, vat inclusive.
     * @return total price for an item including its vat price.
     */
    public double itemPriceWithVat(){
        return sale.getItemPriceWithVat();
    }

    /**
     * Calls the model to return the running total during the scanning process of a sale.
     * @return the running total.
     */
    public double runningTotalDuringScan(){
        return sale.getRunningTotal();
    }

    /**
     * Calls methods to store the amount cash the customer payed and to handle payment for purchase.
     * @param cash the amount customer payed in cash for the purchase.
     */
    public void payPurchase(double cash){
        sale.setCash(cash);
        sale.payForPurchase();
    }

    /**
     * Calls the model to create and print the receipt, log the purchase and to update the external inventory system.
     */
    public void afterPurchaseHandler(){
        sale.createReceipt();
        sale.printReceipt();
        sale.logPurchase();
        sale.updateExternalInventory();
    }

    /**
     * Calls the model to get the amount of change the customer will receive.
     * @return amount of change
     */
    public double showAmountOfChange(){
        return sale.getChange();
    }
}
