package edu.qc.seclass.grocerylist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sam on 4/16/2018.
 */

/**
 * adapter for result class list view
 */

public class resultAdapter extends BaseAdapter{
    private List<Item> itemList;
    private Context context;

    resultAdapter(Context context,List<Item> itemList){
        this.itemList = itemList;
        this.context = context;
    }
    private static class itemHolder{
        public TextView itemName;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;

        itemHolder holder = new itemHolder();
        if(view == null){
            LayoutInflater inflater =((Activity) context).getLayoutInflater();
            v=inflater.inflate(R.layout.type_list,null);
            holder.itemName = (TextView) v.findViewById(R.id.typeName);
            v.setTag(holder);
        }else{
            holder=(itemHolder) v.getTag();
        }

        Item p = itemList.get(i);
        holder.itemName.setText(p.getItemName());

        return v;
    }



}
