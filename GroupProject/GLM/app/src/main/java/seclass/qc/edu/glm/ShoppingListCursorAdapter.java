package seclass.qc.edu.glm;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * reference:  https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter
 */

public class ShoppingListCursorAdapter extends CursorAdapter{

    public ShoppingListCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(R.layout.shopping_list, parent, false);

    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView nameTextView = (TextView) view.findViewById(R.id.list_name_text_view);

        String name = cursor.getString(cursor.getColumnIndexOrThrow(ShoppingListSetUp.ShoppingListEntry.COLUMN_LIST_NAME));

        nameTextView.setText(name);
    }



}
