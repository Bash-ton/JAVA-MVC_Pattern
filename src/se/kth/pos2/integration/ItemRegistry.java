package se.kth.pos2.integration;

/**
 * Since this project doesn't include a data base, this class acts as a register for a couple of items.
 */
public class ItemRegistry {
    /**
     * Creates item DTO:s by receiving an EAN bar code String, and finds the right information for each item scanned.
     * @param eanCode a String containing EAN barcode. Constructed by the item scanner when scanning an item.
     * @param number is an int variable containing number of items bought of the same kind
     * @return an item of type ItemDto.
     */
    public static ItemDto findItem(String eanCode, int number){
        if ("ads".equals(eanCode)){
            ItemDto item = new ItemDto(45, "Apple VAT-rate 12%", 12, number);
            return item;
        }
        if ("dsa".equals(eanCode)){
            ItemDto item = new ItemDto(29, "Banana VAT-rate 6%",6, number);
            return item;
        }
        if ("fre".equals(eanCode)){
            ItemDto item = new ItemDto(29, "Strawberry VAT-rate 25%",25, number);
            return item;
        }
        return null;
    }
}

