package seclass.qc.edu.glm;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class CatalogActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

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
        View empytView = findViewById(R.id.empty_view);
        shopplingListView.setEmptyView(empytView);

        //use this adapter to populate the shoppingListView
        //reference:  https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter
        ShoppingListCursorAdapter shoppingListCursorAdapter = new ShoppingListCursorAdapter(this, null);
        shopplingListView.setAdapter(shoppingListCursorAdapter);










    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
