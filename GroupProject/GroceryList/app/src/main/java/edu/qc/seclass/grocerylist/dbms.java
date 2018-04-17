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
//    //DATABASE
//    public static final String DATABASE_NAME = "grocery.db";
//
//    //LIST TABLE
//    public static final String TABLE_LIST= "list_table";
//    public static final String COL_LIST_ID = "list_id";
//    public static final String COL_LIST_NAME = "list_NAME";
//
//    //PRODUCT TABLE
//    public static final String TABLE_PRODUCT = "product_table";
//    public static final String COL_PRODUCT_ID = "product_id";
//    public static final String COL_PRODUCT_NAME = "product_NAME";
//    public static final String COL_PRODUCT_QUANTITY = "product_quantity";
//    public static final String COL_PRODUCT_COST = "product_cost";
//
//    //TYPE TABLE
//    public static final String TABLE_TYPE = "type_table";
//    public static final String COL_TYPE_ID = "type_id";
//    public static final String COL_TYPE_NAME = "type_NAME";
//
//    //ITEM TABLE
//    public static final String TABLE_ITEM= "item_table";
//    public static final String COL_ITEM_ID = "item_id";
//    public static final String COL_ITEMLIST_ID = COL_LIST_ID;
//    public static final String COL_ITEMTYPE_ID = COL_TYPE_ID;
//    public static final String COL_ITEMPRODUCT_ID = COL_PRODUCT_ID;

    public static final String DATABASE_NAME = "grocery.db";
    public dbms(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_LIST +"(" +COL_LIST_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_LIST_NAME+" TEXT NOT NULL);");
//        db.execSQL("create table " + TABLE_PRODUCT +"(" +COL_PRODUCT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_PRODUCT_NAME+" TEXT NOT NULL);");
//        db.execSQL("create table " + TABLE_TYPE +"(" +COL_TYPE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_TYPE_NAME+" TEXT NOT NULL);");
//        db.execSQL("create table " + TABLE_ITEM+"(" +COL_ITEM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_ITEMLIST_ID+" INTEGER NOT NULL,"+COL_ITEMTYPE_ID+" INTEGER NOT NULL,"+COL_ITEMPRODUCT_ID+" INTEGER NOT NULL,"+COL_PRODUCT_QUANTITY+" INTEGER NOT NULL);");
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LIST);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCT);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TYPE);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEM);
//        onCreate(db);
//    }
//
//    public boolean insertList(String name){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_LIST_NAME,name);
//        long result=db.insert(TABLE_LIST,null,contentValues);
//        if(result==-1)
//            return false;
//        else
//            return true;
//    }
//    public boolean insertProduct(String name,int quantity, float cost){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_PRODUCT_NAME,name);
//        contentValues.put(COL_PRODUCT_QUANTITY,quantity);
//        contentValues.put(COL_PRODUCT_COST,cost);
//        long result=db.insert(TABLE_PRODUCT,null,contentValues);
//        if(result==-1)
//            return false;
//        else
//            return true;
//    }
//    public boolean insertType(String name){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_TYPE_NAME,name);
//        long result=db.insert(TABLE_TYPE,null,contentValues);
//        if(result==-1)
//            return false;
//        else
//            return true;
//    }
//
//    public boolean insertItem(long listID,long typeID,long productID){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_ITEMLIST_ID,listID);
//        contentValues.put(COL_ITEMTYPE_ID,typeID);
//        contentValues.put(COL_ITEMPRODUCT_ID,productID);
//        long result=db.insert(TABLE_ITEM,null,contentValues);
//        if(result==-1)
//            return false;
//        else
//            return true;
//    }

     /*
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
    */
}