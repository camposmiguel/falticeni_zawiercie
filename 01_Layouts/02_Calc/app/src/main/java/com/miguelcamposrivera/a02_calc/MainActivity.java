package com.miguelcamposrivera.a02_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // IU Components
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the 'screen' variable with the textViewScreen component
        screen = findViewById(R.id.textViewScreen);

        // Set a new value to the textViewScreen
        screen.setText("0");
    }

    public void numberClicked(View view) {
        // Button information
        Button buttonClicked = (Button)view;
        String buttonNumber = buttonClicked.getText().toString();
        String currentScreenText = screen.getText().toString();

        if(currentScreenText.equals("0")) {
            // If is the first time, we don't need to concatenate
            screen.setText(buttonNumber);
        } else {
            screen.setText(currentScreenText + buttonNumber);
        }
    }

    public void deleteClicked(View view) {
        // Write the code to delete
        // the last char in the screen

        // Examples
        // 7435 <<<  743
        // 0 <<< 0
        String s = screen.getText().toString();
        int lastIndex = s.length();
        String del = s.substring(0,lastIndex-1);

        screen.setText(del);

    }
}
