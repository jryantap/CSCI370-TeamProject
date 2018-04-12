package seclass.qc.edu.glm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText userName, password;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.usernameInput);
        password = (EditText) findViewById(R.id.passwordInput);

        signIn = (Button) findViewById(R.id.buttonSignIn);
        signIn.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view) {
        if (userName.getText().toString().equals("admin") && password.getText().toString().equals("password")) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent("qc.edu.seclasses.glm.");
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Incorrect User Name and/or Password", Toast.LENGTH_LONG).show();
            signIn.setEnabled(false);
        }
    }
}
