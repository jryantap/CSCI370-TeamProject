package seclass.qc.edu.glm;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CatalogActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    ShoppingListCursorAdapter shoppingListCursorAdapter;
    int shopping_list_loader_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show view
        setContentView(R.layout.activity_show_catalog);

        //set up the FAB for CreateListActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //switch to this view
                Intent intent = new Intent(CatalogActivity.this, CreateListActivity.class);
                startActivity(intent);
            }
        });

        //find the List view which will be populated with this list data
        ListView shopplingListView = (ListView) findViewById(R.id.list);

        //when the list has 0 items, use this view
        View emptyView = findViewById(R.id.empty_view);
        shopplingListView.setEmptyView(emptyView);

        //use this adapter to populate the shoppingListView
        //reference:  https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter
        shoppingListCursorAdapter = new ShoppingListCursorAdapter(this, null);
        shopplingListView.setAdapter(shoppingListCursorAdapter);

        shopplingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //create a new intent to go to the ShowItemsActivity
                Intent intent = new Intent(CatalogActivity.this, ShowItemsActivity.class);

                //get the content
                Uri listUri = ContentUris.withAppendedId(ShoppingListSetUp.ShoppingListEntry.CONTENT_URI, id);

                //set the data to the field of the intent
                intent.setData(listUri);

                startActivity(intent);
            }
        });

        //stop the loader
        getLoaderManager().initLoader(shopping_list_loader_id, null, this);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args)
    {
//        String[] fetch = {
//                ShoppingListSetUp.ShoppingListEntry._ID,
//                ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME,
//                ShoppingListSetUp.ShoppingListEntry.COLUMN_ITEM_COUNT,
//                ShoppingListSetUp.ShoppingListEntry.CONTENT_URI,
//                ShoppingListSetUp.ShoppingListEntry.CONTENT_LIST_TYPE,
//
//        };
        //fetch info from database
        String [] projection = {
                ShoppingListSetUp.ShoppingListEntry._ID,
                ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME
        };

        //return the data that was fetched
        return new CursorLoader(getApplicationContext(), ShoppingListSetUp.ShoppingListEntry.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data)
    {
        shoppingListCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }



}
