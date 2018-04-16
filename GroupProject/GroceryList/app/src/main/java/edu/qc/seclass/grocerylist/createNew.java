package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createNew extends AppCompatActivity {
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        Intent intent = getIntent();
        index = intent.getIntExtra("position",-1);
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
                    Toast.makeText(createNew.this,"item is add to list and database",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),Search.class);
                    intent.putExtra("position",index); //to find which list has been click
                    startActivity(intent);

                }
            }
        });
    }
}
