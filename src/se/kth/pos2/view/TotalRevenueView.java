package se.kth.pos2.view;

import se.kth.pos2.model.SaleObserver;

/**
 * This class works as a display. This class gets updated using the observer pattern.
 * This class prints the total revenue since the program started.
 */
class TotalRevenueView implements SaleObserver {
    private double totalRevenue;

    /**
     * Constructor that sets the initial value on revenue.
     */
    TotalRevenueView(){
        totalRevenue = 0;
    }

    /**
     * This method overrides the method in the observer interface.
     * @param revenue the running total from a purchase of type double.
     */
    @Override
    public void newPurchase(double revenue){
        addRevenue(revenue);
        printCurrentState();
    }
    private void addRevenue(double revenue){
        totalRevenue += revenue;
    }
    private void printCurrentState(){
        System.out.println();
        System.out.println("###############DISPLAY###################");
        System.out.printf("Total Revenue: ");
        System.out.printf("%1.2f", totalRevenue);
        System.out.printf("kr.\n");
        System.out.println("#########################################\n");
    }
}
