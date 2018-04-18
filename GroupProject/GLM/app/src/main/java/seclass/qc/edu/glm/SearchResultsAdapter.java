package seclass.qc.edu.glm;

import android.content.Context;
import android.database.Cursor;
import android.text.Layout;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public class SearchResultsAdapter extends CursorAdapter {

    SparseBooleanArray selectionArray = new SparseBooleanArray();

    public SearchResultsAdapter(Context context, Cursor c)
    {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){

        return LayoutInflater.from(context).inflate(R.layout.search_results, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){

    }

    public boolean isSelected(int position){
        return selectionArray.get(position);
    }

    public void setSelected(int position, boolean isSelected)
    {
        selectionArray.put(position, isSelected);
    }

    public void clearSelected()
    {
        selectionArray.clear();
    }


}
