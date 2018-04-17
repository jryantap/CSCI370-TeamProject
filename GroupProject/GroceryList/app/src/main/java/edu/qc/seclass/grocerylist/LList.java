package edu.qc.seclass.grocerylist;

import java.util.ArrayList;

/**
 * Created by sam on 4/12/2018.
 */
// class for grocery list
public class LList {

    private  int id;
    private String listName;
     boolean isSelected;
    public ArrayList<Item> itemList;

    LList(String name,int id){
        this.listName = name;
        this.isSelected = false;
        itemList = new ArrayList<Item>();
        this.id = id;
    }
    public int getListID() {
        return id;
    }

    public void setListID(int listID) {
        this.id = listID;
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


}
