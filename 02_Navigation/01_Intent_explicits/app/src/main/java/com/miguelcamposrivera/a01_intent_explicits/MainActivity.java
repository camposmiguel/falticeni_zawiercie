package com.miguelcamposrivera.a01_intent_explicits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvSurname, tvSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a refence for each view component
        tvName = findViewById(R.id.textViewName);
        tvSurname = findViewById(R.id.textViewSurname);
        tvSex = findViewById(R.id.textViewSex);

        // Get the information that we receive from the SignUpActivity
        Bundle extras = getIntent().getExtras();

        String name = extras.getString("first_name");
        String surname = extras.getString("last_name");
        String sex = extras.getString("sex");
        int number = extras.getInt("random_number");


        // Set the information into the TextView components
        tvName.setText(name);
        tvSurname.setText(surname);
        tvSex.setText(sex);

    }
}
