package seclass.qc.edu.glm;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.List;

import static android.R.attr.id;


public class ShoppingListProvider extends ContentProvider
{

    /** Tag for the log messages */
    public static final String LOG_TAG = ShoppingListProvider.class.getSimpleName();

    private ShoppingListDbHelper shoppingListDbHelper;

    // Constants for all the URIs to be used in this project
    public final int SHOPPING_LIST = 100;
    public final int SHOPPING_LIST_ID  = 101;
    public final int ITEM = 102;
    public final int ITEM_ID = 103;
    public final int ITEM_NAME = 104;
    public final int LIST_ITEM  = 105;
    public final int LIST_ITEM_ID = 106;
    public final int CATEGORY = 107;
    public final int CATEGORY_ID = 108;
    public final int CATEGORY_NAME = 109;
    public final int ITEM_NAME_SEARCH = 110;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // add all URIs to the matcher
    static
    {
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "shopping_list", 100);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "shopping_list/#", 101);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "item", 102);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "item/#", 103);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "item/*", 104);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "shopping_list/#/list_item", 105);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "shopping_list/#/list_item/#", 106);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "category", 107);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "category/#", 108);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "category/*", 109);
        sUriMatcher.addURI(ShoppingListSetUp.CONTENT_AUTHORITY, "item/*/", 110);
    }

    @Override
    public boolean onCreate()
    {
        shoppingListDbHelper = new ShoppingListDbHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder)
    {
        SQLiteDatabase database = shoppingListDbHelper.getReadableDatabase();

        Cursor cursor = null;

        //Log.e(LOG_TAG, "Uri while query = " + uri.toString());

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match)
        {
            case SHOPPING_LIST:
                // For the SHOPPING_LIST code, query the shopping_list table directly with the given
                // projection, selection, selection arguments, and sort order. The cursor
                // could contain multiple rows of the shopping list table.
                cursor = database.query(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            // query the shopping list table for a given id, must return only one row
            case SHOPPING_LIST_ID:
                cursor = database.query(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            // query the item table, could contain multiple rows of the item table
            case ITEM:
                cursor = database.query(ShoppingListSetUp.ItemEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            // query the item table with a given id, must return only one row
            case ITEM_ID:
                selection = ShoppingListSetUp.ItemEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                cursor = database.query(ShoppingListSetUp.ItemEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            // query the item table with a given name
            case ITEM_NAME:
                String item_name = uri.getLastPathSegment();

                cursor = database.rawQuery("SELECT "
                        + ShoppingListSetUp.ItemEntry.TABLE_NAME + "."
                        + ShoppingListSetUp.ItemEntry._ID
                        + " FROM "  + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + " WHERE " + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME
                        + " = " + "\"" + item_name + "\"", null);
                break;

            // advanced query to query the item table with a given name while in search view
            case ITEM_NAME_SEARCH:
                //Log.e(LOG_TAG, "IN HERE 2");
                List<String> pathSegments2 = uri.getPathSegments();
                String item_name_search = (pathSegments2.get(pathSegments2.size() - 1));

                //Log.e(LOG_TAG, "item_mame is " + item_name_search);
                cursor = database.rawQuery("SELECT "
                        + ShoppingListSetUp.ItemEntry.TABLE_NAME + "."
                        + ShoppingListSetUp.ItemEntry._ID
                        + ", " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "."  + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME
                        + ", " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "."  + ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID
                        + " FROM "  + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + " WHERE " + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME
                        + " LIKE " + "\'" + "%" +item_name_search + "%" + "\'"
                        + " ORDER BY " + "(CASE WHEN " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "." + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME
                        + " = " + "\'" + item_name_search + "\'" + " THEN 1 "
                        + " WHEN " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "." + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME
                        + " LIKE " + "\'" + item_name_search + "%" + "\'" + " THEN 2 "
                        + " ELSE 3 END) LIMIT 10", null);
                break;

            // query the list item table
            // will likely contain multiple rows
            case LIST_ITEM:
                List<String> pathSegments = uri.getPathSegments();
                long id = Integer.valueOf(pathSegments.get(pathSegments.size() - 2));

                cursor = database.rawQuery("SELECT * "
                        + " FROM "  + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                        + " JOIN "  + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + " ON "    + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                        + "."       + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                        + " = "     + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "."       + ShoppingListSetUp.ItemEntry._ID
                        + " WHERE " + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                        + "."       + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                        + " = "     + id
                        + " ORDER BY " + ShoppingListSetUp.ListItemEntry.COLUMN_IS_OBTAINED
                        + ", " + ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID
                        + ", " + ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME, null);
                break;

            // query the list_item table with given list_id and item_id
            case LIST_ITEM_ID:
                pathSegments = uri.getPathSegments();
                long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 3));
                long item_id = ContentUris.parseId(uri);

                cursor = database.rawQuery("SELECT * FROM "
                        + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                        + " JOIN " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + " ON " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                        + " = " + ShoppingListSetUp.ItemEntry.TABLE_NAME
                        + "." + ShoppingListSetUp.ItemEntry._ID
                        + " JOIN " + ShoppingListSetUp.CategoryEntry.TABLE_NAME
                        + " ON " + ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID
                        + " = " + ShoppingListSetUp.CategoryEntry.TABLE_NAME
                        + "." + ShoppingListSetUp.CategoryEntry._ID
                        + " WHERE " + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                        + " = " + list_id + " AND " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                        + " = " + item_id + ";", null);
                break;

            // query the category table, will contain multiple rows
            case CATEGORY:
                cursor = database.query(ShoppingListSetUp.CategoryEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            // query the category table with a given id, must return only one row
            case CATEGORY_ID:
                selection = ShoppingListSetUp.CategoryEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                cursor = database.query(ShoppingListSetUp.CategoryEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            // query the category table with a given name
            case CATEGORY_NAME:
                String category_name = uri.getLastPathSegment();

                cursor = database.rawQuery("SELECT "
                        + ShoppingListSetUp.CategoryEntry.TABLE_NAME + "."
                        + ShoppingListSetUp.CategoryEntry._ID
                        + " FROM "  + ShoppingListSetUp.CategoryEntry.TABLE_NAME
                        + " WHERE " + ShoppingListSetUp.CategoryEntry.COLUMN_CATEGORY_NAME
                        + " = " + "\"" + category_name + "\"" + " LIMIT 1", null);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);

        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    /**
     * Insert new data into the provider with the given ContentValues.
     */
    @Override
    public Uri insert(Uri uri, ContentValues contentValues)
    {

        //Log.e(LOG_TAG, "Uri while insert = " + uri.toString());
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case SHOPPING_LIST:
                return insertShoppingList(uri, contentValues);
            case ITEM:
                return insertItem(uri, contentValues);
            case LIST_ITEM:
                return insertNewItemIntoList(uri, contentValues);
            case LIST_ITEM_ID:
                return insertOldItemIntoList(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    /**
     * Insert a shopping list into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    private Uri insertShoppingList(Uri uri, ContentValues values)
    {

        // Get writeable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        // Insert the new pet shopping list the given values
        long id = database.insert(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, null, values);

        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1)
        {
            //Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        // notify all listeners that data has changed for the shopping list content URI
        getContext().getContentResolver().notifyChange(uri, null);

        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, id);
    }

    /**
     * Insert a category into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    private Uri insertCategory(Uri uri, ContentValues values)
    {
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        Uri customUriCategoryName = Uri.withAppendedPath(uri, values.getAsString(ShoppingListSetUp.CategoryEntry.COLUMN_CATEGORY_NAME));

        Cursor cursor = query(customUriCategoryName, null, null, null, null);

        long category_id;

        if(!cursor.moveToFirst())
        {
            category_id = database.insert(ShoppingListSetUp.CategoryEntry.TABLE_NAME, null, values);
        }
        else
        {
            category_id = cursor.getLong(cursor.getColumnIndexOrThrow(ShoppingListSetUp.CategoryEntry._ID));
        }


        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, category_id);
    }


    /**
     * Insert an item into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    private Uri insertItem(Uri uri, ContentValues values)
    {
        // Get writeable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        Uri customUriItemName = Uri.withAppendedPath(uri, values.getAsString(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

        Cursor cursor = query(customUriItemName, null, null, null, null);

        long item_id;

        if(!cursor.moveToFirst())
        {
            item_id = database.insert(ShoppingListSetUp.ItemEntry.TABLE_NAME, null, values);
        }
        else
        {
            item_id = cursor.getLong(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry._ID));
        }


        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, item_id);
    }

    /**
     * Insert a new item into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    private Uri insertNewItemIntoList(Uri uri, ContentValues values)
    {
        // Get writeable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        List<String> pathSegments = uri.getPathSegments();
        long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 2));

        long item_id = database.insert(ShoppingListSetUp.ItemEntry.TABLE_NAME, null, values);

        database.execSQL("INSERT INTO " + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                + "("  + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                + ", " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                + ")"  + " VALUES (" + list_id + ", " + item_id + ");");

        // notify all listeners that data has changed for the item content URI
        getContext().getContentResolver().notifyChange(uri, null);

        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, item_id);
    }

    /**
     * Insert a new item into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    @Deprecated
    private Uri insertNewItemIntoList2(Uri uri, ContentValues values)
    {

        // Get writeable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        List<String> pathSegments = uri.getPathSegments();
        long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 2));


        Uri customUriItemName = Uri.withAppendedPath(ShoppingListSetUp.ItemEntry.CONTENT_URI, values.getAsString(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

        //Log.e(LOG_TAG, "inseting = " + values.getAsString(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

        Cursor cursor = query(customUriItemName, null, null, null, null);

        if(!cursor.moveToFirst())
        {
            long item_id = database.insert(ShoppingListSetUp.ItemEntry.TABLE_NAME, null, values);

            database.execSQL("INSERT INTO " + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                    + "("  + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                    + ", " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                    + ")"  + " VALUES (" + list_id + ", " + item_id + ");");
        }
        else
        {
            long item_id = cursor.getLong(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry._ID));

            //Log.e(LOG_TAG, "inserting = " + item_id);

            Uri customUriItemId = ContentUris.withAppendedId(uri, item_id);

            String[] projections = {ShoppingListSetUp.ListItemEntry.FK_ITEM_ID};
            String selection = ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?" + " AND "
                    + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
            String[] selectionArgs = new String[] {String.valueOf(list_id), String.valueOf(item_id)};

            Cursor cursor2 = query(customUriItemId, projections, selection, selectionArgs, null);

            if(!cursor2.moveToFirst())
            {
                // the item is not in list_item table for this list
                // then insert it into list_item table for this list
                database.execSQL("INSERT INTO " + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                        + "("  + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                        + ", " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                        + ")"  + " VALUES (" + list_id + ", " + item_id + ");");
            }
            else
            {
                // item is already in list_item table for this list
                // update quantity

            }


        }

        // notify all listeners that data has changed for the item content URI
        getContext().getContentResolver().notifyChange(uri, null);

        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, id);
    }

    // insert an old item into a specific list
    private Uri insertOldItemIntoList(Uri uri, ContentValues values)
    {
        // Get writable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        List<String> pathSegments = uri.getPathSegments();
        long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 3));

        long item_id = Integer.valueOf(uri.getLastPathSegment());

        database.execSQL("INSERT INTO " + ShoppingListSetUp.ListItemEntry.TABLE_NAME
                + "("  + ShoppingListSetUp.ListItemEntry.FK_LIST_ID
                + ", " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID
                + ")"  + " VALUES (" + list_id + ", " + item_id + ");");

        Uri result = Uri.withAppendedPath(ShoppingListSetUp.ShoppingListEntry.CONTENT_URI, list_id + "/list_item");

        getContext().getContentResolver().notifyChange(result, null);

        //Log.e(LOG_TAG, "result uri = " + result.toString());

        return ContentUris.withAppendedId(result, id);
    }

    // Delete data from the database
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        int rowsDeleted = 0;
        List<String> pathSegments;
        long list_id;

        // Get writeable database
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);

        switch (match)
        {
            // Delete all shopping list rows that match the selection and selection args
            case SHOPPING_LIST:
                rowsDeleted = database.delete(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, selection, selectionArgs);
                break;

            // Delete a single row in shopping_list table given by the ID in the URI
            case SHOPPING_LIST_ID:
                selection = ShoppingListSetUp.ShoppingListEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                database.delete(ShoppingListSetUp.ListItemEntry.TABLE_NAME,
                        ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?",
                        selectionArgs);
                rowsDeleted = database.delete(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case ITEM_ID:
                String itemId = uri.getLastPathSegment();
                selection = ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
                selectionArgs = new String[] {itemId};
                rowsDeleted = database.delete(ShoppingListSetUp.ListItemEntry.TABLE_NAME, selection, selectionArgs);
                selection = ShoppingListSetUp.ItemEntry._ID + "=?";
                rowsDeleted = database.delete(ShoppingListSetUp.ItemEntry.TABLE_NAME, selection, selectionArgs);
                break;

            // Delete all rows in the list_item table that match the selection and selection args
            case LIST_ITEM:
                pathSegments = uri.getPathSegments();
                list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 2));

                selection = ShoppingListSetUp.ShoppingListEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(list_id) };
                rowsDeleted = database.delete(ShoppingListSetUp.ListItemEntry.TABLE_NAME, selection, selectionArgs);
                break;

            // Delete a single row in the list_item table given by the ID in the URI
            case LIST_ITEM_ID:
                pathSegments = uri.getPathSegments();
                list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 3));

                selection = ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?"
                        + " AND " + ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)), String.valueOf(list_id) };
                rowsDeleted = database.delete(ShoppingListSetUp.ListItemEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }

        if(rowsDeleted != 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsDeleted;
    }

    // Update data in the database
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs)
    {
        final int match = sUriMatcher.match(uri);
        switch (match)
        {
            // Update information for a specific row in the shopping_list table
            case SHOPPING_LIST_ID:
                selection = ShoppingListSetUp.ShoppingListEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return updateShoppingList(uri, contentValues, selection, selectionArgs);

            // Update information for a specific row in the list_item table
            case LIST_ITEM_ID:
                return updateItem(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }

    // Update information for a specific row in the shopping_list table
    private int updateShoppingList(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        int rowsUpdated = 0;

        rowsUpdated = database.update(ShoppingListSetUp.ShoppingListEntry.TABLE_NAME, values, selection, selectionArgs);

        if(rowsUpdated != 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }

    // Update information for a specific row in the list_item table
    private int updateItem(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = shoppingListDbHelper.getWritableDatabase();

        int rowsUpdated = 0;

        List<String> pathSegments = uri.getPathSegments();
        long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 3));

        long item_id = ContentUris.parseId(uri);


        if(values.containsKey(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME))
        {
            ContentValues nameValue = new ContentValues();
            nameValue.put(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME, values.getAsString(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

            Uri itemUri = insertItem(ShoppingListSetUp.ItemEntry.CONTENT_URI, nameValue);

            nameValue.clear();
            long new_item_id = ContentUris.parseId(itemUri);
            nameValue.put(ShoppingListSetUp.ListItemEntry.FK_ITEM_ID, new_item_id);

            selection = ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?"
                    + " AND " + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
            selectionArgs = new String[] {String.valueOf(list_id), String.valueOf(item_id)};
            rowsUpdated = database.update(ShoppingListSetUp.ListItemEntry.TABLE_NAME, nameValue, selection, selectionArgs);

            item_id = new_item_id;
        }

        if(values.containsKey(ShoppingListSetUp.CategoryEntry.COLUMN_CATEGORY_NAME))
        {
            ContentValues categoryValue = new ContentValues();
            categoryValue.put(ShoppingListSetUp.CategoryEntry.COLUMN_CATEGORY_NAME, values.getAsString(ShoppingListSetUp.CategoryEntry.COLUMN_CATEGORY_NAME));

            Uri categoryUri = insertCategory(ShoppingListSetUp.CategoryEntry.CONTENT_URI, categoryValue);

            categoryValue.clear();
            categoryValue.put(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID, ContentUris.parseId(categoryUri));

            selection = ShoppingListSetUp.ItemEntry._ID + "=?";
            selectionArgs = new String[] {String.valueOf(item_id)};
            rowsUpdated = database.update(ShoppingListSetUp.ItemEntry.TABLE_NAME, categoryValue, selection, selectionArgs);
        }

        if(values.containsKey(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID))
        {
            ContentValues categoryValue = new ContentValues();
            categoryValue.put(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID, values.getAsString(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID));

            selection = ShoppingListSetUp.ItemEntry._ID + "=?";
            selectionArgs = new String[] {String.valueOf(item_id)};
            rowsUpdated = database.update(ShoppingListSetUp.ItemEntry.TABLE_NAME, categoryValue, selection, selectionArgs);
        }

        if(values.containsKey(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY) ||
                values.containsKey(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE))
        {
            ContentValues quantityAndPrice = new ContentValues();
            quantityAndPrice.put(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY, values.getAsInteger(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY));
            quantityAndPrice.put(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE, values.getAsDouble(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE));
            selection = ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?" + " AND "
                    + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
            selectionArgs = new String[] {String.valueOf(list_id), String.valueOf(item_id)};
            rowsUpdated = database.update(ShoppingListSetUp.ListItemEntry.TABLE_NAME, quantityAndPrice, selection, selectionArgs);
        }

        if(values.containsKey(ShoppingListSetUp.ListItemEntry.COLUMN_IS_OBTAINED))
        {
            rowsUpdated = database.update(ShoppingListSetUp.ListItemEntry.TABLE_NAME, values, selection, selectionArgs);
        }

        if(rowsUpdated != 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }

    /**
     * Returns the MIME type of data for the content URI.
     */
    @Override
    public String getType(Uri uri)
    {
        final int match = sUriMatcher.match(uri);
        switch (match)
        {
            case SHOPPING_LIST:
                return ShoppingListSetUp.ShoppingListEntry.CONTENT_LIST_TYPE;
            case SHOPPING_LIST_ID:
                return ShoppingListSetUp.ShoppingListEntry.CONTENT_ITEM_TYPE;
            case CATEGORY:
                return ShoppingListSetUp.CategoryEntry.CONTENT_LIST_TYPE;
            case CATEGORY_ID:
                return ShoppingListSetUp.CategoryEntry.CONTENT_ITEM_TYPE;
            case ITEM:
                return ShoppingListSetUp.ItemEntry.CONTENT_LIST_TYPE;
            case ITEM_ID:
                return ShoppingListSetUp.ItemEntry.CONTENT_ITEM_TYPE;
            case LIST_ITEM:
                return ShoppingListSetUp.ListItemEntry.CONTENT_LIST_TYPE;
            case LIST_ITEM_ID:
                return ShoppingListSetUp.ListItemEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }
}

