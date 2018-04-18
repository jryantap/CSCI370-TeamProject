package seclass.qc.edu.glm;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import static seclass.qc.edu.glm.ShowItemsActivity.itemsInThisList;
import static seclass.qc.edu.glm.ShowItemsActivity.itemsInTheDb;

public class ItemsCursorAdapter extends CursorAdapter {

    SparseBooleanArray checkedArray = new SparseBooleanArray();
    int position = 0;
    String LOG_TAG = ItemsCursorAdapter.class.getSimpleName();


    public void setChecked(int position, boolean isChecked)
    {
        checkedArray.put(position, isChecked);
    }

    public boolean isChecked(int position)
    {

        return checkedArray.get(position);
    }


    public ItemsCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {


        return LayoutInflater.from(context).inflate(R.layout.items_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        position = cursor.getPosition();

        final LinearLayout linearListItem = (LinearLayout) view.findViewById(R.id.item_info_container);

        final TextView nameTextView = (TextView) view.findViewById(R.id.item_name_text_view);

        final TextView itemColorTextView = (TextView) view.findViewById(R.id.item_color_text_view);

        final TextView quantityTextView = (TextView) view.findViewById(R.id.item_quantity_text_view);

        final String name = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry.COLUMN_ITEM_NAME));

        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_checkbox);

        //Log.e(LOG_TAG, "NAME IS = " + name);

        nameTextView.setText(name);

        final int item_id = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry._ID));

        int is_obtained = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ListItemEntry.COLUMN_IS_OBTAINED));

        Log.e(LOG_TAG, "isObtained = " + is_obtained);

        int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ListItemEntry.COLUMN_QUANTITY));

        int price = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ListItemEntry.COLUMN_PRICE));

        int categoryId = cursor.getInt(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ItemEntry.FK_CATEGORY_ID));

        quantityTextView.setText((quantity > 1) ? (String.valueOf(quantity)) : "");


//        switch (categoryId)
//        {
//            case CategoryEntry.CATEGORY_PRODUCE: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.produceColor));
//                break;
//            case CategoryEntry.CATEGORY_DAIRY: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.dairyColor));
//                break;
//            case CategoryEntry.CATEGORY_MEAT: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.meatColor));
//                break;
//            case CategoryEntry.CATEGORY_BAKERY: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.bakeryColor));
//                break;
//            case CategoryEntry.CATEGORY_BEVERAGES: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.beveragesColor));
//                break;
//            case CategoryEntry.CATEGORY_SNACKS: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.snacksColor));
//                break;
//            case CategoryEntry.CATEGORY_FROZEN: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.frozenColor));
//                break;
//            case CategoryEntry.CATEGORY_PERSONAL: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.personalColor));
//                break;
//            case CategoryEntry.CATEGORY_CLEANING: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.cleaningColor));
//                break;
//            case CategoryEntry.CATEGORY_GRAINS: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.grainsColor));
//                break;
//            case CategoryEntry.CATEGORY_SAUCES: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.saucesColor));
//                break;
//            case CategoryEntry.CATEGORY_COFFEE: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.coffeeColor));
//                break;
//            case CategoryEntry.CATEGORY_OTHER: itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.otherColor));
//                break;
//            default:  itemColorTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.otherColor));
//        }

        ItemSetUp item = new ItemSetUp(categoryId, quantity, price, (is_obtained == 1));

        itemsInThisList.put(item_id, item);

        itemsInTheDb.add(item_id);

        checkBox.setTag(item_id);

        if(is_obtained == 1)
            setChecked(position, true);
        else
            setChecked(position, false);

        if(isChecked(position))
            checkBox.setChecked(true);
        else
            checkBox.setChecked(false);

        //Log.e(LOG_TAG, "HASHMAP = " + itemsInThisList.toString());


    }
}

