package se.kth.pos2.model;

/**
 * This is a class that handles the payment of a sale.
 */
 class PaymentCalculator {
    private double change;
    private final Sale sale;

    /**
     * This is a constructor that receives an object of type Sale.
     * @param sale an object of type Sale.
     */
     PaymentCalculator(Sale sale){
        this.sale = sale;

    }

    /**
     * This method calculates the amount of change.
     */
     void changeCalculator(){
        double change = sale.getCash() - sale.getRunningTotal();
        setChange(change);
    }

    private void setChange(double change){
        this.change=change;
    }

    /**
     * getter method for the amount of change the customer will receive.
     * @return the amount of change of type double.
     */
     double getChange(){
        return change;
    }

}
