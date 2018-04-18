package edu.qc.seclass.grocerylist;

/**
 * Created by sam on 4/13/2018.
 */

public class Item {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public boolean isSelected;
    private String itemName;
    private String amount;




    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    Item(String itemName,int id,int quantity) {
        this.itemName = itemName;
        this.isSelected = false;
        String q = ""+quantity;
        this.amount =q;
        this.id = id;


    }

    Item(String itemName,int id){
        this.itemName = itemName;
        this.isSelected =false;
        this.amount="0";
        this.id=id;
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
