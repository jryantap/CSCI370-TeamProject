package edu.qc.seclass.grocerylist;

import java.util.ArrayList;

/**
 * Created by sam on 4/12/2018.
 */
// class for grocery list
public class LList {
    private String listName;
     boolean isSelected;
    public ArrayList<Item> itemList;

    LList(String name,boolean isSelected){
        this.listName = name;
        this.isSelected = isSelected;
        itemList = new ArrayList<Item>();
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public void addItem(Item item){
        boolean onList = false;
        for(Item p : itemList){
            if(p.getItemName().equals(item.getItemName()) && p.getType().equals((item.getType()))){
                p.setAmount(item.getAmount());
            }
        }
    }
}
