package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createNew extends AppCompatActivity {
    private int index;
    private String tName;
    private String name;
    DataAccess dataAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        dataAccess = DataAccess.getInstance(this);
        Intent intent = getIntent();
        index = intent.getIntExtra("position",-1);
        tName = intent.getStringExtra("type");
        name = intent.getStringExtra("searchName");
        Log.d("create", "onCreate: "+index);
        Button submitButton =(Button) findViewById(R.id.createbutton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText item = (EditText) findViewById(R.id.itemName);
                EditText type = (EditText) findViewById(R.id.typeName);
                EditText quantity = (EditText) findViewById(R.id.quantity);
                String itemName = item.getText().toString();
                String typeName = type.getText().toString();
                String amount = quantity.getText().toString();
                if(itemName.equals("") || typeName.equals("") || amount.equals("")){
                    Toast.makeText(createNew.this,"please enter all information",Toast.LENGTH_LONG).show();
                }else{
                    boolean test= dataAccess.insertNewItem(itemName,typeName,amount,index);
                    if(!test){
                        Toast.makeText(createNew.this,"New item not added",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), Search.class);
                        intent.putExtra("position", index); //to find which list has been click
                        startActivity(intent);
                    }

                }
            }
        });
    }

    //back to preview page icon
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.imageButton:
                Intent intent = new Intent(createNew.this,Result.class);
                intent.putExtra("position",index);
                intent.putExtra("type",tName);
                intent.putExtra("searchName",name);
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
