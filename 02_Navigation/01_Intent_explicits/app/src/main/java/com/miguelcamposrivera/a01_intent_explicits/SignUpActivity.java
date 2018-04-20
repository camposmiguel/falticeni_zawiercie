package com.miguelcamposrivera.a01_intent_explicits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    // View components variables
    EditText etName, etSurname;
    RadioGroup rgSex;
    CheckBox cbTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // 1. Connect all the view components with our local variables
        etName = findViewById(R.id.editTextName);
        etSurname = findViewById(R.id.editTextSurname);
        rgSex = findViewById(R.id.radioGroupSex);
        cbTerms = findViewById(R.id.checkBoxTerms);
    }


    public void doSignUp(View view) {
        // 1. Get the form information that user wrotes
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        int radioButtonId = rgSex.getCheckedRadioButtonId();

        // Validate the form
        boolean isValid = true;
        if(name.isEmpty()) {
            etName.setError("Please, write a name!!!");
            isValid = false;
        } else if(surname.isEmpty()) {
            etSurname.setError("Please, write a surname");
            isValid = false;
        } else if(!cbTerms.isChecked()) {
            cbTerms.setError("You must to accept the terms");
            isValid = false;
        }

        // 2. Create and intent to pass the information to MainActivity screen
        if(isValid) {
            // 3. Open MainActivity screen
            Intent i = new Intent(this, MainActivity.class);

            i.putExtra("first_name", name);
            i.putExtra("last_name", surname);
            i.putExtra("random_number",50);
            if(radioButtonId == R.id.radioMale) {
                i.putExtra("sex", "male");
            } else {
                i.putExtra("sex", "female");
            }

            startActivity(i);
        } else {
            Toast.makeText(this, "Try to review the form", Toast.LENGTH_LONG).show();        }
    }
}
