package se.kth.pos2.model;

import se.kth.pos2.integration.ItemDto;

/**
 * A class that calculates the price including vat, for an item and the running total for the whole sale.
 */
class RunningTotal {
    private  double itemPriceWithVat;
    private double runningTotal;
    RunningTotal(){
        runningTotal = 0;
    }

    /**
     * A method that calculates the price including the vat for an item.
     * The method also updates the running total.
     * @param item an item of type itemDto.
     */
     void calculateItemPriceWithVatAndRunningTotal(ItemDto item){
         double vat;
         double price;
         price = item.getPrice();
         vat = item.getVat();
         vat = (vat/100) + 1;
         itemPriceWithVat = price * vat;
         setRunningTotal(itemPriceWithVat);
    }

    private void setRunningTotal(double itemPriceWithVat){
         runningTotal = runningTotal + itemPriceWithVat;
    }

    /**
     * getter method for an item's price with vat
     * @return the price of an item including vat stored as a double.
     */
    double getItemPriceWithVat(){
        return itemPriceWithVat;
    }

    /**
     * getter method for the running total
     * @return the running total of type double.
     */
    double getRunningTotal() {
        return runningTotal;
    }

    /**
     * a method that resets the runningTotal
     */
    void resetRunningTotal(){
        runningTotal = 0;
    }
}
