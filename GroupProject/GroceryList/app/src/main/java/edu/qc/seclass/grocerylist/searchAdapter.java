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

public class searchAdapter extends BaseAdapter{
    private List<type> typeList;
    private Context context;

    searchAdapter(Context context,List<type> typelist){
        this.typeList = typelist;
        this.context = context;
    }

    private static class typeHolder{
        public TextView typeName;
    }
    @Override
    public int getCount() {
        return typeList.size();
    }

    @Override
    public Object getItem(int i) {
        return typeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View v = view;

       typeHolder holder = new typeHolder();
       if(view ==null){
           LayoutInflater inflater = ((Activity) context).getLayoutInflater();
           v = inflater.inflate(R.layout.type_list,null);
           holder.typeName=(TextView) v.findViewById(R.id.typeName);
           v.setTag(holder);
       }else{
           holder = (typeHolder) v.getTag();
       }

       type p = typeList.get(i);
       holder.typeName.setText(p.getTypeName());

        return v;
    }
}
