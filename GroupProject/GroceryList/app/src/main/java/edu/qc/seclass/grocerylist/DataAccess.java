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
    public List<Item> getproductList(String name) {
        List<Item> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT product_id,product_name FROM product_table where product_name like '%"+ name+ "%'" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String productName = cursor.getString(1);

            Item p = new Item(productName,id);
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
     * action bar title in item list
     * @param i
     * @return
     */
    public String getListName(int i){
        String name="";
        Cursor cursor = database.rawQuery("SELECT list_name FROM list_table" +
                "  WHERE list_id =" + i, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        return name;

    }

    /**
     * get type id fo rsearch page using search button
     */
    public int getTypeID(String name){
        int id=0;
        String low = name.toLowerCase();
        Cursor cursor = database.rawQuery("SELECT type_id FROM type_table" +
                "  WHERE type_name ='" + low+ "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            id = cursor.getInt(0);
            return id;
        }
        cursor.close();
        return id;
    }

    public int getProductID(String name){
        int id=0;
        String low = name.toLowerCase();
        Cursor cursor = database.rawQuery("SELECT product_id FROM product_table" +
                "  WHERE product_name ='" + low+ "'", null);
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
                                            "  WHERE product_id = " + i, null);
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
                    "  WHERE list_name ='"+ name +"'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                return true;
            }
            cursor.close();
        }else if(page.equals("product")){
            Cursor cursor = database.rawQuery("SELECT * FROM product_table" +
                    "  WHERE product_name ='"+ name +"'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                return true;
            }
            cursor.close();
        }else if(page.equals("type")){
            Cursor cursor = database.rawQuery("SELECT * FROM type_table" +
                    "  WHERE type_name ='"+ name +"'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                return true;
            }
            cursor.close();
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

    public boolean insertNewItem(String name, String type, String quantity,int position){
            long Tresult=-1;
            boolean nExist =checkName(name,"product");
            boolean tExist =checkName(name,"type");
            if(nExist ) return false;
            else{
                if(!tExist) {
                    ContentValues typeValues = new ContentValues();
                    typeValues.put("type_name", name.toLowerCase());
                     Tresult = database.insert("type_table", null, typeValues);

                    if (Tresult == -1) return false;
                }



                ContentValues productValues = new ContentValues();
                productValues.put("product_name", name.toLowerCase());
                productValues.put("type_id",Tresult);
                long result = database.insert("product_table", null, productValues);
                if (result == -1) return false;
                int product =getProductID(name);

                ContentValues itemValues = new ContentValues();
                itemValues.put("list_id", position);
                itemValues.put("product_id",product);
                itemValues.put("quantity",Integer.parseInt(quantity));
                long Iresult = database.insert("item_table", null, itemValues);
                if (Iresult == -1) return false;
            }

            return true;
    }



    public boolean deleteList (int id) {
        return database.delete("list_table","list_id "+ " = " + id,null)>0;
    }

    public boolean deleteItem (int id,int position) {
        return database.delete("item_table","list_id  = " + position +" AND product_id = "+id,null)>0;
    }
}
