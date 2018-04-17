package edu.qc.seclass.grocerylist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 4/17/2018.
 */

public class DataAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DataAccess(Context context) {
        this.openHelper = new dbms(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DataAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }


    /**
     * Read all quotes from the database.
     *
     * @return a List of  id and name
     */
    public List<LList> getMainList() {
        List<LList> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM list_table", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String listName = cursor.getString(1);

            LList p = new LList(listName,id);
            list.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * get data depend which i :index of list
     * @param i
     * @return
     */
    public List<Item> getitemList(int i) {
        List<Item> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT product_id,quantity FROM item_table" +
                                            "  WHERE list_id ="+ i, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String a=""+id;
            String product_name = getProductName(id);
            int quantity = cursor.getInt(1);

            Item p = new Item(product_name,id,quantity);
            list.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * list in search page
     * @param i
     * @return
     */
    public List<type> getTypeList(int i) {
        List<type> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM type_table", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String typeName = cursor.getString(1);

            type p = new type(typeName,id);
            list.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * list in result page where search by type
     * @param i
     * @return
     */
    public List<Item> getitemTypeList(int i) {
        List<Item> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT product_id,product_name FROM product_table " +
                                                "where type_id =" + i, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String productName = cursor.getString(1);

            Item p = new Item(productName,id,0);
            list.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    /**
     * get type id fo rsearch page using search button
     */
    public int getTypeID(String name){
        int id=0;
        String low = name.toLowerCase();
        Cursor cursor = database.rawQuery("SELECT * FROM type_table" +
                " WHERE type_name =" + low, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            id = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        return id;
    }

    /**
     * get product name to show in item list
     * @param i
     * @return
     */
    public String getProductName(int i){
        Cursor cursor = database.rawQuery("SELECT product_name FROM product_table" +
                                            "  WHERE product_id =" + i, null);
        String name ="";
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return name;
    }
        public boolean checkName(String name,String page){
        if(page.equals("main")){
            Cursor cursor = database.rawQuery("SELECT * FROM list_table" +
                    "  WHERE list_name ="+ name, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                return false;
            }
            cursor.close();
            return true;
        }

        return false;
        }



        public boolean insertList(String name){
        boolean exist = checkName(name,"main");
        if(!exist) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("list_name", name);
            long result = database.insert("list_table", null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }
        return false;
    }

    public boolean deleteList (int id) {
        return database.delete("list_table","list_id "+ " = " + id,null)>0;
    }

    public boolean deleteItem (int id,int position) {
        return database.delete("item_table","list_id  = " + position +" AND product_id = "+id,null)>0;
    }
}
