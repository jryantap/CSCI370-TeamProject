package com.grocerylistmanager.sam.grocerylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<LList> itemList;
    ListView listView;
    AdapterList ListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView) findViewById(R.id.groceryList);
        initItems();
        ListAdapter = new AdapterList(MainActivity.this,itemList);
        listView.setAdapter(ListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ItemList.class);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });;


    }

    public void initItems(){
        itemList = new ArrayList<LList>();

        TypedArray arrayText = getResources().obtainTypedArray(R.array.list);

        for(int i=0; i<arrayText.length();i++){
            String s = arrayText.getString(i);
            boolean b= false;
            LList list = new LList(s,b);
            itemList.add(list);
        }

        arrayText.recycle();
    }

    public void detele(){
        Iterator<LList> i = itemList.iterator();
        while (i.hasNext()) {
            LList o = i.next();
            if(o.isSelected())
                i.remove();
        }
        ListAdapter.notifyDataSetChanged();;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_addList:
                startActivityForResult(new Intent(getApplicationContext(),AddNewList.class),2);// go to add list page
                return true;
            case R.id.action_delList:
                startActivityForResult(new Intent(getApplicationContext(),Pop.class),3);// pop up confirm  window

                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_context,menu);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2 && resultCode == RESULT_OK){
            String name=(String)data.getStringExtra("ListName");
            itemList.add(new LList(name,false));
        }
        if(requestCode == 3 && resultCode == RESULT_OK){
            detele();
        }
    }

}
