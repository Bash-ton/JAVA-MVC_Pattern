package se.kth.pos2.integration;


import se.kth.pos2.model.Sale;

import java.util.ArrayList;

/**
 * This class is a DTO for a sale's receipt.
 */
public class ReceiptDto {
    private Sale sale;
    private final String STORENAME = "Helt okej affär";
    private final String ADDRESS = "plats där affär är";
    private String dateAndTime;
    private double change;
    private double cash;
    private double runningTotal;
    private ArrayList itemsPurchasedList;

    /**
     * This is a constructor to store an object of type Sale.
     * @param sale of type Sale from the model package
     */
    public ReceiptDto(Sale sale){
        this.sale = sale;

    }

    /**
     * sets the variables in this ReceiptDTO.
     */
    public void createReceiptDto(){
            this.itemsPurchasedList = sale.getItemDtoPurchaseList();
            this.cash = sale.getCash();
            this.change = sale.getChange();
            this.runningTotal = sale.getRunningTotal();
            this.dateAndTime = sale.getTimeAndDateOfSale();
    }
    public String getSTORENAME(){
        return STORENAME;
    }
    public String getADDRESS(){
        return ADDRESS;
    }
    public String getDateAndTime(){
        return dateAndTime;
    }
    public double getRunningTotal(){
        return runningTotal;
    }
    public double getChange(){
        return change;
    }
    public double getCash(){
        return cash;
    }
    public ArrayList getItemsPurchasedList(){
        return itemsPurchasedList;
    }
}
