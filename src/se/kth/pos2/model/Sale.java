package se.kth.pos2.model;

import se.kth.pos2.integration.*;

import java.util.ArrayList;

/**
 * This class handles a specific purchase.
 */
public class Sale {
    private ArrayList<String> purchasedItemEanCodesList = new ArrayList<>();
    private RunningTotal runningTotal = new RunningTotal();
    private PaymentCalculator paymentCalc = new PaymentCalculator(this);
    private ItemDtoPurchaseList itemDtoPurchaseList = new ItemDtoPurchaseList();
    private double cash;
    private ReceiptDto receipt = new ReceiptDto(this);
    private LogPurchaseDbHandler logThisPurchase = new LogPurchaseDbHandler(this);
    private UpdateInventoryDbHandler updateInventoryDbHandler = new UpdateInventoryDbHandler(receipt);
    private CurrentTimeAndDate timeAndDateOfSale = new CurrentTimeAndDate();
    private ArrayList<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * A method that adds an item to the purchase list during a scan, one item per scan.
     * This list contains one ean-code per item in this purchase.
     * @param eanCode an EAN-barcode for an item, as a string.
     */
    public void scanItem(String eanCode){
        purchasedItemEanCodesList.add(eanCode);
    }

    /**
     * calls a method that calculates the change
     */
    public void payForPurchase(){
        paymentCalc.changeCalculator();
    }

    /**
     * stores the cash value in the sale object
     * @param cash amount of cash customer payed for the purchase.
     */
    public void setCash(double cash){
        this.cash = cash;
    }

    /**
     * calls a method that creates a receipt DTO for this sale
     */
    public void createReceipt(){
            receipt.createReceiptDto();
    }

    /**
     * Calls a method that prints a receipt for this sale
     */
    public void printReceipt(){
        new Printer(receipt).printReceipt();
    }

    /**
     * Calls a method to log's this sale
     * also notify observers that purchase is done.
     */
    public void logPurchase(){
        logThisPurchase.logSale();
        notifyObservers();
    }
    private void notifyObservers(){
        for (SaleObserver obs : saleObservers){
            obs.newPurchase(runningTotal.getRunningTotal());
        }
    }

    /**
     * adds a sale observer to an array of sale observers
     * @param obs an object ot type saleObserver
     */
    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }

    /**
     * Calls a method that to update the external inventory system.
     */
    public void updateExternalInventory(){
        updateInventoryDbHandler.setInventoryDbHandler();
    }

    /**
     * A method that receives all info about the most recent scanned item from an ean-code
     * @return an ItemDTO that stores all relevant info about the most recent scanned item.
     */
    public ItemDto getItemInfoDuringScan()throws NotIdentifiedItemException, OperationFailedException{
            int numberOfItems = 1;
            String eanCode = purchasedItemEanCodesList.get(purchasedItemEanCodesList.size() - 1);
        try{
            runningTotal.calculateItemPriceWithVatAndRunningTotal(ItemRegistry.findItem(eanCode, numberOfItems));
            return ItemRegistry.findItem(eanCode, 1);
        }catch (ItemRegistryDataBaseException e){
            throw new OperationFailedException("Can not show item description due to database failure", e);
        }catch (NullPointerException e){
            throw new NotIdentifiedItemException(eanCode);
        }
    }
    /**
     * getter method for an items description
     * @param item an itemDTO of an item
     * @return an item's description.
     */
    public String getItemDescription(ItemDto item){
        return item.getDescription();
    }
    /**
     * getter method for an items price with vat.
     * @return an item's price with vat as a double.
     */
    public double getItemPriceWithVat(){
        return runningTotal.getItemPriceWithVat();
    }
    /**
     * getter method for the time and date for this sale.
     * @return the date and time as a string.
     */
    public String getTimeAndDateOfSale(){
       return timeAndDateOfSale.getTimeAndDate();
    }
    /**
     * getter method for the whole purchase list, where every item is stored as an ItemDTO.
     * @return a list of every item in this sale as ItemDTO's. This list doesn't include any duplicates,
     * instead quantity is stored in the ItemDTO.
     */
    public ArrayList getItemDtoPurchaseList(){
        return itemDtoPurchaseList.createItemDtoPurchaseList(purchasedItemEanCodesList);
    }
    /**
     * getter method for the amount of cash customer payed for this sale.
     * @return cash of type double, the amount payed for this sale.
     */
    public double getCash(){
        return cash;
    }
    /**
     * getter method for the running total of this sale.
     * @return the running total of type double.
     */
    public double getRunningTotal(){
        return runningTotal.getRunningTotal();
    }
    /**
     * getter method for the change the customer will receive for this purchase.
     * @return
     */
    public double getChange(){
        return paymentCalc.getChange();
    }

    /**
     * calls methods to reset running total, purchaseList of String, and purchase list of itemDTO:s
     */
    public void clearSaleObjects(){
        runningTotal.resetRunningTotal();
        purchasedItemEanCodesList.clear();
        itemDtoPurchaseList.resetList();
    }
}
