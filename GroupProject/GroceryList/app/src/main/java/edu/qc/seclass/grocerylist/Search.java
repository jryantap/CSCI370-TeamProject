package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
   List<type> typeList;
    ListView listView;
    searchAdapter searchAdapter;
    int position;// for item list
    DataAccess dataAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        dataAccess = DataAccess.getInstance(this);
        Intent intent = getIntent();
        position = intent.getIntExtra("position",-1);
        listView =(ListView) findViewById(R.id.searchList);
        typeList = dataAccess.getTypeList(position);
        searchAdapter =new searchAdapter(Search.this,typeList);
        listView.setAdapter(searchAdapter);


        Button search = (Button) findViewById(R.id.searchButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText search = (EditText) findViewById(R.id.search);
                String name = search.getText().toString();
                if(name.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter a name of product or type", Toast.LENGTH_LONG).show();
                }else {
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.searchType);
                    int buttonId = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton)
                            radioGroup.findViewById(buttonId);
                    String selectedtext = (String) radioButton.getText();
                    if(selectedtext.equals("Type")) {
                        int typeID =dataAccess.getTypeID(name);
                        String t=""+typeID;
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra("type", selectedtext); //to find which list has been click
                        intent.putExtra("searchName", name);
                        intent.putExtra("position", position);
                        intent.putExtra("id",typeID);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtra("type", selectedtext); //to find which list has been click
                        intent.putExtra("searchName", name);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = typeList.get(i).getTypeName();
                int typeID =typeList.get(i).getTypeId();
                Intent intent = new Intent(getApplicationContext(),Result.class);
                intent.putExtra("type","Type"); //to find which list has been click
                intent.putExtra("searchName",s);
                intent.putExtra("position",position);
                intent.putExtra("id",typeID);
                startActivity(intent);
            }
        });
    }



    //back to preview page icon
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.imageButton:
                Intent intent = new Intent(Search.this,ItemList.class);
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
