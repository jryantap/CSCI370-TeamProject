package seclass.qc.edu.glm;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class CreateListActivity extends AppCompatActivity {

    //EditText to enter field name
    EditText enterEditText;

    //uniform resource locator to help locate files or resources
    Uri currentListUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set it to this view
        setContentView(R.layout.activity_show_create_list);

        //get the data of this intent
        Intent intent = getIntent();
        currentListUri = intent.getData();

        //Find all relevant views that are needed to read user input from
        enterEditText = (EditText) findViewById(R.id.editlist_name);

//        if (currentListUri == null) {
//            setTitle("Add new product");
//        } else {
//            setTitle("Edit product");
//            getLoaderManager().initLoader(EXISTING_PRODUCT_LOADER, null, this);
//        }
    }

    //create a newList
    private void createNewList(String listName)
    {

        ContentValues values = new ContentValues();
        values.put(ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME, listName);

        Uri newUri = getContentResolver().insert(ShoppingListSetUp.ShoppingListEntry.CONTENT_URI, values);

        if(newUri == null)
        {
            // If the new content URI is null, then there was an error with insertion.
            Toast.makeText(this, getString(R.string.insert_list_failed),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Otherwise, the insertion was successful and we can display a toast.
            Toast.makeText(this, getString(R.string.insert_list_successful),
                    Toast.LENGTH_SHORT).show();
        }

        // Close this activity
        finish();

        // Create a new intent to go the {@Link ShowItemsActivity}
        Intent intent = new Intent(CreateListActivity.this, ShowItemsActivity.class);

        // set the URI on the data field of the intent
        intent.setData(newUri);

        // launch the ShowItemsActivity so that the user can start adding items to the new list
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_create_list.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_create_list, menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveList();
                return true;
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveList()
    {
        String nameString = enterEditText.getText().toString().trim();

        if(!TextUtils.isEmpty(nameString))
            createNewList(nameString);
        else
            finish();

    }
}
