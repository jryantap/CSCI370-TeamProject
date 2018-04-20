package edu.qc.seclass.grocerylist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sam on 4/12/2018.
 */

/**
 * // adapter for main Activity list
 */
public class AdapterList extends BaseAdapter {
    private List<LList> itemList;
    private Context context;

     AdapterList(Context context,List<LList> itemlist){
        this.itemList = itemlist;
        this.context = context;
    }

    private static class itemHolder{
        public TextView itemName;
        public CheckBox checkBox;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public boolean isChecked(int position){
         return itemList.get(position).isSelected;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        itemHolder holder = new itemHolder();
        if(convertView == null){
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        v= inflater.inflate(R.layout.list_view,null);
        holder.itemName =(TextView) v.findViewById(R.id.itemName);
        holder.checkBox =(CheckBox) v.findViewById(R.id.itemCheckBox);
        v.setTag(holder);
        }else{
            holder = (itemHolder) v.getTag();
        }

        LList p = itemList.get(position);
        holder.itemName.setText(p.getListName());
        holder.checkBox.setChecked(p.isSelected());
        holder.checkBox.setTag(p);

        //set isSelected and checkbox is checked
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean newState = !itemList.get(position).isSelected();
                itemList.get(position).isSelected=newState;
            }
        });

        holder.checkBox.setChecked(isChecked(position));
        return v;
    }
}
