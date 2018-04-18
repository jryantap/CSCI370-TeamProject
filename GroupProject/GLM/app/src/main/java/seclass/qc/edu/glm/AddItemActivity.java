package seclass.qc.edu.glm;

import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static seclass.qc.edu.glm.ShowItemsActivity.itemsInThisList;
import static seclass.qc.edu.glm.ShowItemsActivity.itemsInTheDb;

public class AddItemActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static boolean isDataSaved;
    public Uri currentListUri;
    public SearchResultsAdapter searchResultsAdapter;
    //generate a random limit
    int firstIdLimit = Integer.MAX_VALUE - 1000;
    public static HashMap<Integer, String> newItemsInMemory = new HashMap<Integer, String>();
    int tempIdToBeUsedForNewItem;
    public static int SEARCH_RESULTS_LOADER_ID = 3;
    public SearchView searchView;
    public MenuItem searchItem;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_add_item);

        isDataSaved = false;

        Intent intent = getIntent();
        currentListUri = intent.getData();

        // Find the ListView which will be populated with the item data
        final ListView searchResultsListView = (ListView) findViewById(R.id.search_results);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        searchResultsListView.setEmptyView(emptyView);

        searchResultsAdapter = new SearchResultsAdapter(this, null);
        searchResultsListView.setAdapter(searchResultsAdapter);

        /**
         * When a an item is clicked on the list view, select the item at this position as a
         * candidate to go in the database and add it to the ArrayList for items in current list
         */
        searchResultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                if(!searchResultsAdapter.isSelected(position))
                {
                    LinearLayout linearLayout = (LinearLayout) view;
                    TextView textView = (TextView) linearLayout.getChildAt(1);
                    String name = textView.getText().toString();
                    if(id > firstIdLimit)
                    {
                        /*itemsInThisList.put((int) id, new Item(name));
                        itemsInTheDb.add((int)id);*/
                        newItemsInMemory.put(tempIdToBeUsedForNewItem, name);
                    }
                    else
                        itemsInThisList.put((int) id, null);

                    searchResultsAdapter.setSelected(position, true);
                    searchResultsAdapter.notifyDataSetChanged();
                }
                else
                {
                    // may be update quantity in the future
                }

            }
        });
        getLoaderManager().initLoader(SEARCH_RESULTS_LOADER_ID, null, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_add_item.xml file.
        // This adds menu items to the app bar.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_item, menu);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        tempIdToBeUsedForNewItem = firstIdLimit;

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        searchView.setSearchableInfo( searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getResources().getString(R.string.hint_item_name));

        searchView.setIconified(false);

        searchView.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);


        // This will handle the event when something is typed in the search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                bundle = new Bundle();
                bundle.putCharArray("name", newText.toCharArray());
                getLoaderManager().restartLoader(SEARCH_RESULTS_LOADER_ID, bundle, AddItemActivity.this);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                //saveItems();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // insert a new item into database and then into current list
    public void saveNewItems(HashMap<Integer, String> itemsToBeAddedToDb)
    {
        Uri uriSaveItem = Uri.withAppendedPath(currentListUri, "list_item");

        for(Integer key : itemsToBeAddedToDb.keySet())
        {
            ContentValues values = new ContentValues();
            //Log.e(LOG_TAG, "new name = " + itemsToBeAddedToDb.get(i));
            values.put(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME, itemsToBeAddedToDb.get(key));
            Uri newUri = getContentResolver().insert(uriSaveItem, values);
        }
    }

    // insert an item into the list that is already in the database
    public void saveOldItems(ArrayList<Integer> itemsAdded)
    {
        Uri uriSaveItem = Uri.withAppendedPath(currentListUri, "list_item");
        for(int i = 0; i < itemsAdded.size(); i++)
        {
            Uri newUri = getContentResolver().insert(ContentUris.withAppendedId(uriSaveItem, itemsAdded.get(i)), null);
        }

    }

    // delete given items from the list
    public void deleteItems(ArrayList<Integer> itemsDeleted)
    {
        Uri uriDeleteItem = Uri.withAppendedPath(currentListUri, "list_item");

        int rowsDeleted = 0;

        for(int i = 0; i < itemsDeleted.size(); i++)
        {
            rowsDeleted = getContentResolver().delete(ContentUris.withAppendedId(uriDeleteItem, itemsDeleted.get(i)), null, null);
        }
    }


    // update quantity for item with the given id
    public void updateQuantity(long id)
    {
        ItemSetUp item = itemsInThisList.get(id);
        item.incrementPrice();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        searchResultsAdapter.clearSelected();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projections = {
                ShoppingListSetUp.ItemEntry._ID,
                ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME};

        if(bundle == null)
            return new CursorLoader(getApplicationContext(), ShoppingListSetUp.ItemEntry.CONTENT_URI, projections, null, null, null);
        else
        {
            //Log.e(LOG_TAG, "IN here");
            String name = new String(bundle.getCharArray("name"));
            Uri uri = Uri.withAppendedPath(ShoppingListSetUp.ItemEntry.CONTENT_URI, name + "/");
            return new CursorLoader(getApplicationContext(), uri, projections, null, null, null);
        }
    }

    /**
     * After the we have the result from the query, set the cursor on the adapter
     * However, if there was nothing in the cursor, then use a MatrixCursor to deliver fake data
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor)
    {
        String itemName = (bundle == null) ? null : new String(bundle.getCharArray("name"));

        if(itemName == null || itemName.equals(""))
        {
            searchResultsAdapter.swapCursor(cursor);
            return;
        }
        else
        {
            String initialName = null;

            String[] columns = new String[] { "_id", "item_name"};

            MatrixCursor matrixCursor1 = new MatrixCursor(columns);

            matrixCursor1.addRow(new Object[] {++tempIdToBeUsedForNewItem, itemName});

            MatrixCursor matrixCursor2 = new MatrixCursor(columns);

            for(Integer key : newItemsInMemory.keySet())
            {
                if(newItemsInMemory.get(key).matches(itemName + ".*"))
                    matrixCursor2.addRow(new Object[] {key, newItemsInMemory.get(key)});
            }

            if(!cursor.moveToFirst())
                searchResultsAdapter.swapCursor(matrixCursor1);
            else
            {
                initialName = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

                if(initialName.toLowerCase().equals(itemName.toLowerCase()))
                {
                    searchResultsAdapter.swapCursor(cursor);
                    return;
                }
                else
                {
                    Cursor[] cursors = new Cursor[3];

                    cursors[0] = matrixCursor1;
                    cursors[1] = matrixCursor2;
                    cursors[2] = cursor;

                    MergeCursor mergeCursor = new MergeCursor(cursors);

                    searchResultsAdapter.swapCursor(mergeCursor);
                }

            }
        }

        if(bundle != null)
            bundle.clear();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader)
    {
        searchResultsAdapter.clearSelected();
        searchResultsAdapter.swapCursor(null);
    }

    /**
     * Perform data integrity checks so that only legal candidate are inserted into the database
     * and only the right data is deleted.
     */
    private void onBack()
    {
        ArrayList<Integer> itemsAdded = new ArrayList<>();
        ArrayList<Integer> itemsDeleted = new ArrayList<>();

        for(Integer key : itemsInThisList.keySet())
        {
            if(!itemsInTheDb.contains(key))
                itemsAdded.add(key);
        }

        for(Integer itemId : itemsInTheDb)
        {
            if(!itemsInThisList.containsKey(itemId))
                itemsDeleted.add(itemId);
        }

        //Log.e(LOG_TAG, "items to be added to db = " + itemsToBeAddedToDb.toString());

        if(itemsAdded.size() != 0)
            saveOldItems(itemsAdded);

        if(itemsDeleted.size() != 0)
            deleteItems(itemsDeleted);

        if(newItemsInMemory.size() != 0)
            saveNewItems(newItemsInMemory);

        itemsAdded.clear();
        itemsDeleted.clear();
        newItemsInMemory.clear();
        itemsInThisList.clear();
    }


}
