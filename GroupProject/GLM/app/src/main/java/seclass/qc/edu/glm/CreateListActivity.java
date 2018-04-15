package seclass.qc.edu.glm;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

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
        enterEditText = (EditText) findViewById(R.id.edit_list_name);

//        if (currentListUri == null) {
//            setTitle("Add new product");
//        } else {
//            setTitle("Edit product");
//            getLoaderManager().initLoader(EXISTING_PRODUCT_LOADER, null, this);
//        }
    }

    //create a newList
    public void createNewList(String listName)
    {
        //store sets of values we're going to use later
        ContentValues value = new ContentValues();

    }
}
