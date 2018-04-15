package seclass.qc.edu.glm;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

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


    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {

    }



}
