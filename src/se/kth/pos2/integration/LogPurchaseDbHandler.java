package se.kth.pos2.integration;

import se.kth.pos2.model.Sale;

/**
 * This class communicates with a data base to update a purchase history.
 * Since this project doesn't include a data base, this class ends here.
 */
public class LogPurchaseDbHandler {
    private final Sale sale;
    public LogPurchaseDbHandler(Sale sale){
        this.sale = sale;
    }
    /**
     * Method that contacts the data base to log a sale.
     * This method ends here due to tha data base not included in this project.
     */
    public void logSale(){
    }
}
