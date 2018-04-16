package seclass.qc.edu.glm;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Class that setups up the shopping list table.
 * Reference: https://stackoverflow.com/questions/7899720/what-is-the-use-of-basecolumns-in-android
 * Reference: Thanks to the author of https://www.programcreek.com/java-api-examples/android.provider.BaseColumns for this
 * Reference: Android API Documentation
 */


public class ShoppingListSetUp {

    public  static String category_path = "category";
    static String item_path = "item";
    public static String list_item_path = "list_item";
    public static String authority_content = "seclass.qc.edu.glm";
    public static String shopping_list_path = "shopping list";
    public static Uri content_base_uri = Uri.parse("content://" + authority_content);

//    public class ShopList {
//        public static final String TABLE_NAME = "shoppinglist";
//
//        public static final String COLUMN_ID = "id";
//        public static final String COLUMN_NOTE = "note";
//
//
//        private int shoppinglist;
//        private String list;
//
//
//
//        // Create table SQL query
//        public static final String CREATE_TABLE =
//                "CREATE TABLE " + TABLE_NAME + "("
//                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                        + COLUMN_NOTE + " TEXT,"
//                        + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
//                        + ")";
//
//
//
//    public class DatabaseHelper extends SQLiteOpenHelper {
//
//        // Database Version
//        private static final int DATABASE_VERSION = 1;
//
//        // Database Name
//        private static final String DATABASE_NAME = "shoppling_list";
//
//
//        public DatabaseHelper(Context context) {
//            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        }
//
//        // Creating Tables
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//
//            // create notes table
//            db.execSQL(shoppingList.CREATE_TABLE);
//        }
//
//        // Upgrading database
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            // Drop older table if existed
//            db.execSQL("DROP TABLE IF EXISTS " + shoppinglist.TABLE_NAME);
//
//            // Create tables again
//            onCreate(db);
//        }
//    }

    public ShoppingListSetUp(){}

    public static class ShoppingListEntry implements BaseColumns{

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + authority_content + "/" + shopping_list_path;

        /**
         * for a single shopping list.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + authority_content + "/" + shopping_list_path;


        public static final Uri CONTENT_URI = Uri.withAppendedPath(content_base_uri, shopping_list_path);

        public static final String TABLE_NAME = "shopping_list";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_LIST_NAME = "list_name";
        public static final String COLUMN_ITEM_COUNT = "item_count";
        public static final String COLUMN_ITEM_OBTAINED_COUNT = "item_obtained_count";

    }

    public static class CategoryEntry implements BaseColumns
    {
        /**
         * for a list of categories.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + authority_content + "/" + category_path;

        /**
         * for a single category.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + authority_content + "/" + category_path;


        public static final Uri CONTENT_URI = Uri.withAppendedPath(content_base_uri, category_path);

        public static final String TABLE_NAME = "category";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_CATEGORY_NAME = "category_name";


        // category constants
        static public final int CATEGORY_PRODUCE = 1;
        static public final int CATEGORY_DAIRY = 2;
        static public final int CATEGORY_MEAT = 3;
        static public final int CATEGORY_BAKERY = 4;
        static public final int CATEGORY_BEVERAGES = 5;
        static public final int CATEGORY_SNACKS = 6;
        static public final int CATEGORY_FROZEN = 7;
        static public final int CATEGORY_PERSONAL = 8;
        static public final int CATEGORY_CLEANING = 9;
        static public final int CATEGORY_GRAINS = 10;
        static public final int CATEGORY_SAUCES = 11;
        static public final int CATEGORY_COFFEE = 12;
        static public final int CATEGORY_OTHER = 13;
    }

    public static class ItemEntry implements BaseColumns
    {
        /**
         *  for a list of items.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + authority_content + "/" + item_path;

        /**
         * for a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + authority_content + "/" + item_path;


        public static final Uri CONTENT_URI = Uri.withAppendedPath(content_base_uri, item_path);

        public static final String TABLE_NAME = "item";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_ITEM_NAME = "item_name";
        public static final String FK_CATEGORY_ID = "category_id";

    }

    public static class ListItemEntry implements BaseColumns
    {
        /**
         * for a list of items list.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + authority_content + "/" + item_path;

        /**
         * for a single items list.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + authority_content + "/" + item_path;


        public static final Uri CONTENT_URI = Uri.withAppendedPath(content_base_uri, list_item_path);

        public static final String TABLE_NAME = "list_item";
        public static final String FK_ITEM_ID = "item_id";
        public static final String FK_LIST_ID = "list_id";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_IS_OBTAINED = "is_obtained";
        public static final String COLUMN_PRICE = "price";

    }


}
