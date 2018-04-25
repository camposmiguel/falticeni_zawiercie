package com.miguelcamposrivera.a01_fragmentlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail, editTextPwd;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPwd = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.button) ;

        // Button login: click event listener
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPwd.getText().toString();

        if(email.equals("admin@admin.com") && pass.equals("1234")) {
            Intent i = new Intent(this, LoggedInActivity.class);
            i.putExtra("email", email);
            startActivity(i);
        } else {
            Toast.makeText(this, "Email and/or password wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}
