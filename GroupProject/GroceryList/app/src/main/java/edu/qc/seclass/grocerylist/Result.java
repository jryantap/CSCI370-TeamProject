package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {
    List<Item> itemList;
    ListView listView;
    resultAdapter resultAdapter;
    String type;
    String name;
    int index;// position for type list
    int position;//position for item list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int result=0;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        name = intent.getStringExtra("searchName");
        position = intent.getIntExtra("position",-1);
        Log.d("result", "onCreate: "+position);
        if(result ==0) {
            setContentView(R.layout.result_not_found);
        }else {
            setContentView(R.layout.activity_result);

            setTitle(name);
            listView = (ListView) findViewById(R.id.resultList);
            initItems();

            resultAdapter = new resultAdapter(Result.this, itemList);
            listView.setAdapter(resultAdapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    index = i;
                    startActivityForResult(new Intent(getApplicationContext(), addItem.class), 2);
                }
            });
        }
        Button createNew = (Button) findViewById(R.id.CreateNewItem);
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), createNew.class);
                intent.putExtra("position", position); //to find which list has been click
                intent.putExtra("type",type);
                intent.putExtra("searchName",name);
                startActivity(intent);

            }
        });

    }

    public void initItems(){
        itemList = new ArrayList<Item>();

        TypedArray arrayText = getResources().obtainTypedArray(R.array.product);

        for(int i=0; i<arrayText.length();i++){
            String s = arrayText.getString(i);
            boolean b= false;
            Item item = new Item(s,b,"food");
            itemList.add(item);
        }

        arrayText.recycle();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2 && resultCode == RESULT_OK){
        }
    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.home:
//                Intent intent = new Intent(getApplicationContext(),ItemList.class);
//                intent.putExtra("position",position);
//                startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    //back to preview page icon
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.imageButton:
                Intent intent = new Intent(Result.this,Search.class);
                intent.putExtra("position",position);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //button on action bar plug in
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_back,menu);
        return true;
    }
}
