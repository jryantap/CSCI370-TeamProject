package edu.qc.seclass.grocerylist;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.security.PublicKey;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class dbms extends SQLiteAssetHelper {


    public static final String DATABASE_NAME = "grocery.db";
    public dbms(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


}