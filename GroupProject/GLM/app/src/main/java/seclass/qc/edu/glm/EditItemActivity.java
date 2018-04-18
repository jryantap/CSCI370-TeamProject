package seclass.qc.edu.glm;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import seclass.qc.edu.glm.ShoppingListSetUp.CategoryEntry;
import static seclass.qc.edu.glm.ShowItemsActivity.itemsInThisList;
import seclass.qc.edu.glm.R;

public class EditItemActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    boolean itemHasChanged = false;
    boolean nameHasChanged = false;
    boolean categoryHasChanged = false;
    boolean quantityHasChanged = false;
    boolean priceHasChanged = false;

    Spinner categorySpinner;
    int category = 1;

    Uri currentItemUri;

    EditText nameEditText;
    EditText quantityEditText;
    EditText priceEditText;

    int ITEM_LOADER_ID = 3;

    String initialName;
    String initialQuantity;
    String initialPrice;

    // A listener that listens for changes to a any field in this activity
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int viewId = view.getId();
            itemHasChanged = true;
            switch (viewId)
            {
                case R.id.edit_item_name:
                    nameHasChanged = true;
                    break;
                case R.id.spinner_category:
                    categoryHasChanged = true;
                    break;
                case R.id.edit_quantity:
                    quantityHasChanged = true;
                    break;
                case R.id.edit_price:
                    priceHasChanged = true;
                    break;
                default: itemHasChanged = false;

            }
            return false;
        }
    };

    /**
     * Setup the dropdown spinner that allows the user to select the category of the item.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_category_options, android.R.layout.simple_dropdown_item_1line);
                //R.array.array_category_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        categorySpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer category to the constant values
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.category_produce))) {
                        category = CategoryEntry.CATEGORY_PRODUCE; // Produce
                    } else if (selection.equals(getString(R.string.category_dairy))) {
                        category = CategoryEntry.CATEGORY_DAIRY; // Dairy
                    } else if (selection.equals(getString(R.string.category_meat))) {
                        category = CategoryEntry.CATEGORY_MEAT; // Poultry
                    } else if (selection.equals(getString(R.string.category_bakery))) {
                        category = CategoryEntry.CATEGORY_BAKERY; // Bakery
                    } else if (selection.equals(getString(R.string.category_beverages))) {
                        category = CategoryEntry.CATEGORY_BEVERAGES; // Beverages
                    } else if (selection.equals(getString(R.string.category_snacks))) {
                        category = CategoryEntry.CATEGORY_SNACKS; // Snacks
                    } else if (selection.equals(getString(R.string.category_frozen))) {
                        category = CategoryEntry.CATEGORY_FROZEN; // Frozen
                    } else if (selection.equals(getString(R.string.category_personal_care))) {
                        category = CategoryEntry.CATEGORY_PERSONAL; // Personal
                    } else if (selection.equals(getString(R.string.category_cleaning))) {
                        category = CategoryEntry.CATEGORY_CLEANING; // Cleaning
                    } else if (selection.equals(getString(R.string.category_grains))) {
                        category = CategoryEntry.CATEGORY_GRAINS; // Grains
                    } else if (selection.equals(getString(R.string.category_sauces))) {
                        category = CategoryEntry.CATEGORY_SAUCES; // Sauces
                    } else if (selection.equals(getString(R.string.category_coffee))) {
                        category = CategoryEntry.CATEGORY_COFFEE; // Coffee
                    } else if (selection.equals(getString(R.string.category_other))) {
                        category = CategoryEntry.CATEGORY_OTHER; // Other
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                category = 13; // Other
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        currentItemUri = getIntent().getData();

        getLoaderManager().initLoader(ITEM_LOADER_ID, null, this);

        nameEditText = (EditText) findViewById(R.id.edit_item_name);
        categorySpinner = (Spinner) findViewById(R.id.spinner_category);
        quantityEditText = (EditText) findViewById(R.id.edit_quantity);
        priceEditText = (EditText) findViewById(R.id.edit_price);

        nameEditText.setOnTouchListener(touchListener);
        categorySpinner.setOnTouchListener(touchListener);
        quantityEditText.setOnTouchListener(touchListener);
        priceEditText.setOnTouchListener(touchListener);

        setupSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_edit_item.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Edit Item");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_save:
                onSavePress();
                return true;
            case R.id.action_delete:
                deleteItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onSavePress()
    {
        if(!itemHasChanged)
        {
            // Otherwise, the update was successful and we can display a toast.
            Toast.makeText(this, getString(R.string.update_item_successful),
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            saveItem();
            finish();
        }
    }

    public void saveItem(View view)
    {
        onSavePress();
    }

    public void deleteItem(View view)
    {
        deleteItem();
    }

    /**
     * Save the item back into the database after the user is done with editing the item
     */
    private void saveItem()
    {
        String nameString = nameEditText.getText().toString().trim();
        String quantityString  = quantityEditText.getText().toString().trim();
        String priceString  = priceEditText.getText().toString().trim();

        if(TextUtils.isEmpty(nameString) && category == CategoryEntry.CATEGORY_OTHER
                && TextUtils.isEmpty(quantityString) && TextUtils.isEmpty(priceString)) {return;}


        int quantity = 1;
        if(!TextUtils.isEmpty(quantityString))
        {
            quantity = Integer.parseInt(quantityString);
            if(quantity < 1)
                quantity = 1;
        }


        Double price = null;

        if(!TextUtils.isEmpty(priceString))
        {
            if(!priceString.equals("."))
            {
                price = Double.parseDouble(priceString);
                if(price <= 0 )
                    price = null;
                else if(price > 100000)
                    price = 100000.0;
            }
        }

        ContentValues contentValues = new ContentValues();

        if(nameHasChanged)
            contentValues.put(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME, nameString);

        if(categoryHasChanged)
            contentValues.put(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID, category);

        if(quantityHasChanged || priceHasChanged)
        {
            contentValues.put(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY, quantity);
            contentValues.put(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE, price);
        }

        List<String> pathSegments = currentItemUri.getPathSegments();
        long list_id = Integer.valueOf(pathSegments.get(pathSegments.size() - 3));

        String selection = ShoppingListSetUp.ListItemEntry.FK_LIST_ID + "=?" + " AND "
                + ShoppingListSetUp.ListItemEntry.FK_ITEM_ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(list_id), String.valueOf(ContentUris.parseId(currentItemUri))};

        int rowsUpdated = getContentResolver().update(currentItemUri, contentValues, selection, selectionArgs);

        if(rowsUpdated == 0)
        {
            // If the rows updated is 0, then there was an error with updating.
            Toast.makeText(this, getString(R.string.update_item_failed),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Otherwise, the update was successful and we can display a toast.
            Toast.makeText(this, getString(R.string.update_item_successful),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Delete the item from the database if the user selects the delete option
     */
    private void deleteItem()
    {
        int rowsDeleted = getContentResolver().delete(currentItemUri, null, null);

        if(rowsDeleted == 0)
        {
            // If rowsDeleted is 0, then there was an error while deleting item.
            Toast.makeText(this, getString(R.string.delete_item_failed),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Otherwise, the item was successfully deleted
            Toast.makeText(this, getString(R.string.delete_item_successful),
                    Toast.LENGTH_SHORT).show();
        }

        int item_id = Integer.valueOf(currentItemUri.getLastPathSegment());

        itemsInThisList.remove(item_id);


        finish();
    }

    public void deleteItemPermanently(View view)
    {

        DialogInterface.OnClickListener deletePermClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Yes, Delete" button, delete the item and close the current activity.
                        deletePermanently();
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showPermanentlyDeleteConfirmationDialog(deletePermClickListener);
    }

    private void deletePermanently()
    {
        Uri itemUri = Uri.withAppendedPath(ShoppingListSetUp.ItemEntry.CONTENT_URI, currentItemUri.getLastPathSegment());

        int rowsDeleted = getContentResolver().delete(itemUri, null, null);

        if(rowsDeleted == 0)
        {
            // If rowsDeleted is 0, then there was an error while deleting item.
            Toast.makeText(this, getString(R.string.delete_item_failed),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Otherwise, the item was successfully deleted
            Toast.makeText(this, getString(R.string.delete_item_successful),
                    Toast.LENGTH_SHORT).show();
        }

        int item_id = Integer.valueOf(currentItemUri.getLastPathSegment());

        itemsInThisList.remove(item_id);

        finish();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getApplicationContext(), currentItemUri, null, null, null, null);
    }

    /**
     * After we have got the data from the db, set the data on the respective views
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor)
    {
        if(cursor.moveToFirst())
        {
            initialName = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));
            int category = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID));
            initialQuantity = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY));
            initialPrice = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE));

            nameEditText.setText(initialName);


            switch (category)
            {
                case CategoryEntry.CATEGORY_PRODUCE : categorySpinner.setSelection(CategoryEntry.CATEGORY_PRODUCE - 1);
                    break;
                case CategoryEntry.CATEGORY_DAIRY : categorySpinner.setSelection(CategoryEntry.CATEGORY_DAIRY - 1);
                    break;
                case CategoryEntry.CATEGORY_MEAT : categorySpinner.setSelection(CategoryEntry.CATEGORY_MEAT - 1);
                    break;
                case CategoryEntry.CATEGORY_BAKERY : categorySpinner.setSelection(CategoryEntry.CATEGORY_BAKERY - 1);
                    break;
                case CategoryEntry.CATEGORY_BEVERAGES : categorySpinner.setSelection(CategoryEntry.CATEGORY_BEVERAGES - 1);
                    break;
                case CategoryEntry.CATEGORY_SNACKS : categorySpinner.setSelection(CategoryEntry.CATEGORY_SNACKS - 1);
                    break;
                case CategoryEntry.CATEGORY_FROZEN : categorySpinner.setSelection(CategoryEntry.CATEGORY_FROZEN - 1);
                    break;
                case CategoryEntry.CATEGORY_PERSONAL : categorySpinner.setSelection(CategoryEntry.CATEGORY_PERSONAL - 1);
                    break;
                case CategoryEntry.CATEGORY_CLEANING : categorySpinner.setSelection(CategoryEntry.CATEGORY_CLEANING - 1);
                    break;
                case CategoryEntry.CATEGORY_GRAINS : categorySpinner.setSelection(CategoryEntry.CATEGORY_GRAINS - 1);
                    break;
                case CategoryEntry.CATEGORY_SAUCES : categorySpinner.setSelection(CategoryEntry.CATEGORY_SAUCES - 1);
                    break;
                case CategoryEntry.CATEGORY_COFFEE : categorySpinner.setSelection(CategoryEntry.CATEGORY_COFFEE - 1);
                    break;
                case CategoryEntry.CATEGORY_OTHER : categorySpinner.setSelection(CategoryEntry.CATEGORY_OTHER - 1);
                    break;
                default: categorySpinner.setSelection(CategoryEntry.CATEGORY_OTHER);
            }

            quantityEditText.setText(initialQuantity);
            priceEditText.setText(initialPrice);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader)
    {
        nameEditText.getText().clear();
        category = CategoryEntry.CATEGORY_OTHER;
        quantityEditText.getText().clear();
        priceEditText.getText().clear();
    }

    @Override
    public void onBackPressed() {
        // If the item hasn't changed, continue with handling back button press
        if (!itemHasChanged) {
            super.onBackPressed();
            return;
        }

        // Otherwise if there are unsaved changes, setup a dialog to warn the user.
        // Create a click listener to handle the user confirming that changes should be discarded.
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener)
    {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the item.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showPermanentlyDeleteConfirmationDialog(DialogInterface.OnClickListener deletePermClcikListener)
    {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.perm_delete_dialog_msg);
        builder.setPositiveButton(R.string.delete_perm_yes, deletePermClcikListener);
        builder.setNegativeButton(R.string.delete_perm_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "No" button, so dismiss the dialog
                // and continue editing the item.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
