package edu.qc.seclass.grocerylist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
