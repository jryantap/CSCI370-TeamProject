package seclass.qc.edu.glm;


import android.app.LoaderManager;
import android.content.ClipData;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import seclass.qc.edu.glm.ItemSetUp;

import java.util.HashMap;

public class ShowItemsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    public static Uri currentList;
    public boolean listIsChanged = false;
    public static int list_item_loader = 2;
    //for items in this listView
    public static HashMap<Integer, ItemSetUp> itemsInThisList = new HashMap<>();
    public static ItemsCursorAdapter itemsCursorAdapter;



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

        //ItemsCursorAdapter itemsCursorAdapter = new ItemsCursorAdapter(this, null);
        itemsCursorAdapter = new ItemsCursorAdapter(this, null);
        listViewItems.setAdapter(itemsCursorAdapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ShowItemsActivity.this, EditItemsActivity.class);

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


}
