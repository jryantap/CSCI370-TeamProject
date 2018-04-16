package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    int index;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        name = intent.getStringExtra("searchName");
        position = intent.getIntExtra("list",-1);
        setTitle(name);
        listView =(ListView) findViewById(R.id.resultList);
        initItems();
        Button createNew = (Button) findViewById(R.id.CreateNewItem);

        resultAdapter = new resultAdapter(Result.this,itemList);
        listView.setAdapter(resultAdapter);

        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),createNew.class);
                intent.putExtra("position",position); //to find which list has been click
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index=i;
                startActivityForResult(new Intent(getApplicationContext(),addItem.class),2);
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
        if(requestCode == 4 && resultCode == RESULT_OK){
        }
    }
}
