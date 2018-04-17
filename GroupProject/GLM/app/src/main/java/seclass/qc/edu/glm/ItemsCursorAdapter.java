package seclass.qc.edu.glm;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public class ItemsCursorAdapter extends CursorAdapter {

    public ItemsCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
