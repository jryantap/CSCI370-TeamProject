package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    dbms mydb;
    public static List<LList> itemList;
    ListView listView;
    AdapterList ListAdapter;
    DataAccess dataAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("main","1");
//        mydb=new dbms(this);
        //set up the list layout
        listView =(ListView) findViewById(R.id.groceryList);
        //set up database
        dataAccess = DataAccess.getInstance(this);
        //open data base
        dataAccess.open();
        //read data from database
        itemList = dataAccess.getMainList();

        ListAdapter = new AdapterList(MainActivity.this,itemList);
        listView.setAdapter(ListAdapter);

        //go to the itemlist when click the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ItemList.class);
                intent.putExtra("position",i); //to find which list has been click
                startActivity(intent);
            }
        });;


    }



    //delete list
    public void delete(){
        Iterator<LList> i = itemList.iterator();
        while (i.hasNext()) {
            LList o = i.next();
            if(o.isSelected())
                i.remove();
        }
        ListAdapter.notifyDataSetChanged();

    }


    //remove all check off
    public void clearCheck(){
        for(LList p:itemList){
            p.isSelected =false;
        }
        ListAdapter.notifyDataSetChanged();
    }


    //for menu action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_addList:
                startActivityForResult(new Intent(getApplicationContext(),AddNewList.class),2);// go to add list page
                return true;
            case R.id.action_delList:
                startActivityForResult(new Intent(getApplicationContext(),Pop.class),3);// pop up confirm  window
                return true;
            case R.id.action_clearCheck:
                clearCheck();


        }
        return super.onOptionsItemSelected(item);
    }

    //button on action bar plug in
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_context,menu);
        return true;
    }


    //the send back data from addlist and delete list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2 && resultCode == RESULT_OK){
            String name=(String)data.getStringExtra("ListName");
            itemList.add(new LList(name,1));
            ListAdapter.notifyDataSetChanged();
        }
        if(requestCode == 3 && resultCode == RESULT_OK){
            delete();
        }
    }

}
