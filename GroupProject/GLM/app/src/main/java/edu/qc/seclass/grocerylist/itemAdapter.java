package edu.qc.seclass.grocerylist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sam on 4/14/2018.
 */

/**
 * adapter for item list page
 */

public class itemAdapter extends BaseAdapter {
    private List<Item> itemList;
    private Context context;

     itemAdapter( Context context,List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
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
        return  i;
    }

    private static class itemHolder{
        public TextView itemName;
        public CheckBox checkBox;
        public TextView amount;
    }

    public boolean isChecked(int position){
        return itemList.get(position).isSelected;
    }


    @Override
    public View getView(final int i, View convertView , ViewGroup viewGroup) {
        View v = convertView;

        itemHolder holder = new itemHolder();
        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            v= inflater.inflate(R.layout.item_list,null);
            holder.itemName =(TextView) v.findViewById(R.id.itemName);
            holder.amount = (TextView) v.findViewById(R.id.amount);
            holder.checkBox =(CheckBox) v.findViewById(R.id.itemCheckBox);
            v.setTag(holder);
        }else{
            holder = (itemHolder) v.getTag();
        }

        Item p = itemList.get(i);
        holder.itemName.setText(p.getItemName());
        holder.amount.setText(p.getAmount());
        holder.checkBox.setChecked(p.isSelected());
        holder.checkBox.setTag(p);


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean newState = !itemList.get(i).isSelected();
                itemList.get(i).isSelected=newState;
            }
        });



        holder.checkBox.setChecked(isChecked(i));
        return v;
    }
}
