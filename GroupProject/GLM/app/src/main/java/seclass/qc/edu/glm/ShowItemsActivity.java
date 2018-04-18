package seclass.qc.edu.glm;


import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ShowItemsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    public static Uri currentList;
    public boolean listIsChanged = false;
    public static int list_item_loader = 2;
    //for items in this listView
    public static HashMap<Integer, ItemSetUp> itemsInThisList = new HashMap<>();
    public static ItemsCursorAdapter itemsCursorAdapter;
    public static String LOG_TAG = ShowItemsActivity.class.getSimpleName();
    public static ArrayList<Integer> itemsInTheDb = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        currentList = getIntent().getData();

        //Set up the FAB to open the item Activity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_item);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ShowItemsActivity.this, AddItemActivity.class);

                intent.setData(currentList);
                startActivity(intent);
                //list is going to change
                listIsChanged = true;
            }
        });

        //get the LIstView which will be populated with the item data
        ListView listViewItems = (ListView) findViewById(R.id.list_of_items);

        //go to an empty list view on the ListView and show 0 if it's an empty list
        View emptyView = findViewById(R.id.empty_view);
        listViewItems.setEmptyView(emptyView);

        Random random = new Random();
        int picId = random.nextInt(6);

        ImageView emptyViewImageView = (ImageView) findViewById(R.id.empty_catalog_image);

        switch (picId)
        {
            case 0 : emptyViewImageView.setImageResource(R.drawable.ic_bread);
                break;
            case 1 : emptyViewImageView.setImageResource(R.drawable.ic_broc);
                break;
            case 2 : emptyViewImageView.setImageResource(R.drawable.ic_carrot);
                break;
            case 3 : emptyViewImageView.setImageResource(R.drawable.ic_eggs);
                break;
            case 4 : emptyViewImageView.setImageResource(R.drawable.ic_milk);
                break;
            case 5 : emptyViewImageView.setImageResource(R.drawable.ic_water);
                break;
            default: emptyViewImageView.setImageResource(R.drawable.ic_peach);
        }

        //ItemsCursorAdapter itemsCursorAdapter = new ItemsCursorAdapter(this, null);
        itemsCursorAdapter = new ItemsCursorAdapter(this, null);
        listViewItems.setAdapter(itemsCursorAdapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ShowItemsActivity.this, EditItemActivity.class);

                Uri currentItems = Uri.withAppendedPath(currentList, "list_item/" + id);

                intent.setData(currentItems);

                startActivity(intent);
            }
        });

        //stop loader
        getLoaderManager().initLoader(list_item_loader, null, this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        itemsInThisList.clear();

        //define a projection that will show data from the database
        String[] projections = {ShoppingListSetUp.ItemEntry._ID, ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME};

        Uri uri = Uri.withAppendedPath(currentList, "list_item");

        return new CursorLoader(getApplicationContext(), uri, projections, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        itemsCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        itemsInThisList.clear();
        itemsCursorAdapter.swapCursor(null);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        getLoaderManager().restartLoader(list_item_loader, null, this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_delete:
                deleteList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private String getCurrentListName(Uri currentListUri)
    {
        String[] projections = {
                ShoppingListSetUp.ShoppingListEntry._ID,
                ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME};

        String selection = ShoppingListSetUp.ShoppingListEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(ContentUris.parseId(currentListUri)) };

        Cursor cursor = getContentResolver().query(currentListUri, projections, selection, selectionArgs, null);

        cursor.moveToFirst();

        return cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME));
    }

    private void deleteList()
    {
        int rowsDeleted = getContentResolver().delete(currentList, null, null);

        if(rowsDeleted == 0)
        {
            // If rowsDeleted is 0, then there was an error while deleting list.
            Toast.makeText(this, getString(R.string.delete_list_failed),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Otherwise, the list was successfully deleted
            Toast.makeText(this, getString(R.string.delete_list_successful),
                    Toast.LENGTH_SHORT).show();
        }

        finish();
    }

    private void updateShoppingList()
    {
        int itemCount = ((ListView) findViewById(R.id.list_of_items)).getAdapter().getCount();

        ContentValues values = new ContentValues();
        values.put(ShoppingListSetUp.ShoppingListEntry.COLUMN_ITEM_COUNT, itemCount);

        int rowsUpdated = getContentResolver().update(currentList, values, null, null);
    }

    public void checkBoxHandler(View view) {
        CheckBox checkBox = (CheckBox) view;

        boolean isChecked = checkBox.isChecked();

        Log.e(LOG_TAG, "ISCHECKED = " + isChecked);

        int item_id = (Integer) checkBox.getTag();

        Log.e(LOG_TAG, "ID = " + item_id);

        updateListItemObtained(item_id, (isChecked) ? 1 : 0);

        itemsCursorAdapter.notifyDataSetChanged();
    }

    private void updateListItemObtained(int item_id, int isObtainedFlag)
    {
        long list_id = ContentUris.parseId(currentList);

        Uri uri = Uri.withAppendedPath(currentList, "list_item" + "/" + item_id);

        Log.e(LOG_TAG, "URI = " + uri);

        String selection = ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?" + " AND "
                + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(list_id), String.valueOf(item_id)};

        ContentValues values = new ContentValues();
        values.put(ShoppingListSetUp.ListItemEntry.COLUMN_IS_OBTAINED, isObtainedFlag);


        int rowsUpdated = getContentResolver().update(uri, values, selection, selectionArgs);
    }

    public void onBackPressed()
    {
        if(listIsChanged)
        {
            updateShoppingList();
        }
        finish();
    }

}
