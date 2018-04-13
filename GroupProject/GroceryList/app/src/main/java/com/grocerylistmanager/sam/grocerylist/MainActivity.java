package com.grocerylistmanager.sam.grocerylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LList itemList =new LList();
//        String [] item=itemList.getList();
//        //put the item list into a array
//        ListAdapter itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
//        //link the ListView to main
//        ListView groceryList =(ListView) findViewById(R.id.groceryList);
//        //put the list into ListView
//        groceryList.setAdapter(itemAdapter);

        AdapterList adbList;
        ArrayList<LList> mylist = new ArrayList<LList>;

        adbList = new AdapterList(this,mylist);

        ListView groceryList =(ListView) findViewById(R.id.groceryList);
        groceryList.setAdapter(AdapterList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_context,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_addList:
                startActivity(new Intent(this,AddNewList.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
