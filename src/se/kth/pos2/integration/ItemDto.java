package se.kth.pos2.integration;

/**
 * DTO class containing info about items bought during a purchase
 */
public final class ItemDto {
    private final double price;
    private final String description;
    private final double vat;
    private final int numberOfSameItems;

    /**
     * setter method for an Item DTO
     * @param price the cost of an item not including VAT.
     * @param description name of item and a short description of the VAT-rate of the item
     * @param vat the VAT-rate of the item
     * @param numberOfSameItems a number containg how many items of this type was purchased.
     */
    public ItemDto(double price, String description, double vat, int numberOfSameItems ){
        this.price = price;
        this.description = description;
        this.vat = vat;
        this.numberOfSameItems = numberOfSameItems;
    }
    /**
     * getter method for the description
     * @return a string containing the description
     */
    public String getDescription(){
        return description;
    }
    /**
     * getter method for the price
     * @return the price as a double variable
     */
    public double getPrice(){
        return price;
    }
    /**
     * getter method for the vat-rate
     * @return vat-rate as a double variable
     */
    public double getVat(){
        return vat;
    }
    /**
     * getter method for the number of items of the same type, bought
     * @return the number of items bought as an int variable.
     */
    public int getNumberOfSameItems(){
        return numberOfSameItems;
    }
}
