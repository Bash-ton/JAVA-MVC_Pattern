package se.kth.pos2.model;

import se.kth.pos2.integration.ItemDto;
import se.kth.pos2.integration.ItemRegistry;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class creates a purchase list where every item is stored as an itemDTO.
 */
public class ItemDtoPurchaseList {
    private final ArrayList<ItemDto> purchasedItemDtoList = new ArrayList<>();

    /**
     * This method creates a purchase list containing every item as ItemDTO's.
     * This list has no duplicates, quantity is instead stored in every ItemDTO.
     * @param eanList a purchase list where every item is stored as an EAN-barcode string.
     *                This list may contain duplicates if several items of same sort has been scanned.
     * @return an purchase list of every item as itemDTO's.
     */
    public ArrayList createItemDtoPurchaseList(ArrayList eanList){
        int i = 0;
        int numberOfDuplicates;

        Collections.sort(eanList);
        while(i < eanList.size()){
            String eanCode = (String) eanList.get(i);
            numberOfDuplicates = checkForDuplicates(eanList, i);
            ItemDto item = ItemRegistry.findItem(eanCode, numberOfDuplicates);
            purchasedItemDtoList.add(item);
            if(numberOfDuplicates == 1){
                i++;
            }
            else {
                i = i + numberOfDuplicates;
            }
        }
        return purchasedItemDtoList;

    }
    private int checkForDuplicates(ArrayList itemList, int number){
        int occurrences = Collections.frequency(itemList, itemList.get(number));
        return occurrences;
    }
}
