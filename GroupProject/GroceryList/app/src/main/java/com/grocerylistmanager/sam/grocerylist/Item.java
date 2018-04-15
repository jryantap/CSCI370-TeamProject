package com.grocerylistmanager.sam.grocerylist;

/**
 * Created by sam on 4/13/2018.
 */

public class Item {
    public boolean isSelected;
    private String itemName;
    private String type;
    private String amount;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    Item(String itemName, boolean isSelected, String type) {
        this.itemName = itemName;
        this.isSelected = isSelected;
        this.type = type;
        this.amount ="0.0";


    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
