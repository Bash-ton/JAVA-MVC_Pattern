package se.kth.pos2.model;

/**
 * An observer interface for the Sale class.
 */
public interface SaleObserver {
    void newPurchase(double runningTotal);
}
