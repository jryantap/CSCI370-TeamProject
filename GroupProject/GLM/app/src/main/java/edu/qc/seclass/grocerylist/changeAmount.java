package edu.qc.seclass.grocerylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// pop up window for change item quantity in item list
public class changeAmount extends AppCompatActivity {
    String quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        // set the size of pop up window
        getWindow().setLayout((int)(width*0.8), (int)(height*0.4));
        Button ok = (Button) findViewById(R.id.okButton);
        Button cancel = (Button) findViewById(R.id.cancelButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText amount = (EditText) findViewById(R.id.amount);
                quantity = amount.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("amount",quantity);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
}
