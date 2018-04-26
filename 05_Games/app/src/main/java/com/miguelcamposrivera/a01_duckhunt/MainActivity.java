package com.miguelcamposrivera.a01_duckhunt;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextNick;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the toolbar in this Activity
        getSupportActionBar().hide();

        editTextNick = findViewById(R.id.editTextNick);
        btnStart = findViewById(R.id.buttonStart);

        // Change the type font to the editTextNick & btnStart
        Typeface typeface = ResourcesCompat.getFont(this, R.font.pixel);
        editTextNick.setTypeface(typeface);
        btnStart.setTypeface(typeface);
    }

    public void startGame(View view) {
        String nick = editTextNick.getText().toString();

        if(!nick.isEmpty()) {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("name", nick);
            startActivity(i);
        } else {
            editTextNick.setError("Write a nickname");
        }
    }
}
