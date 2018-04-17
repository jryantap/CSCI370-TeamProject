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

    public List<Item> getitemList(int i) {
        List<Item> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT product_id,quantity FROM item_table" +
                                            "  WHERE list_id ="+ i, null);
        cursor.moveToFirst();
        String s=""+i;
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

        public boolean insertList(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("list_name",name);
        long result=database.insert("list_table",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean deleteList (int id) {
        return database.delete("list_table","list_id "+ " = " + id,null)>0;
    }
}
