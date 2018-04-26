package com.miguelcamposrivera.a01_duckhunt;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView tvNick, tvTimer, tvCounter;
    ImageView ivDuck;
    int counter = 0;
    String nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Get the nick value
        Bundle extras = getIntent().getExtras();
        nick = extras.getString("name");

        // Hide the toolbar
        getSupportActionBar().hide();

        // Hide the FAB
        fab.setVisibility(View.GONE);

        // Get the view components references
        tvNick = findViewById(R.id.textViewNick);
        tvTimer = findViewById(R.id.textViewTimer);
        tvCounter = findViewById(R.id.textViewCounter);
        ivDuck = findViewById(R.id.imageViewDuck);

        // Set the nickname
        tvNick.setText(nick);

        // Move the duck to a random position when we start
        duckRandomPosition();

    }

    private void duckRandomPosition() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        int duckWidth = ivDuck.getWidth();
        int duckHeight = ivDuck.getHeight();

        int maxX = screenWidth - duckWidth;
        int maxY = screenHeight - duckHeight;

        Random rand = new Random();
        int randomX = 0 + rand.nextInt((maxX - 0) + 1);
        int randomY = 0 + rand.nextInt((maxY - 0) + 1);

        ivDuck.setX(randomX);
        ivDuck.setY(randomY);
    }

    public void duckClicked(View view) {
        duckRandomPosition();
        if(nick=="Miguel") {
            counter = counter + 3;
            tvCounter.setText(String.valueOf(counter));
        } else {
            tvCounter.setText(String.valueOf(++counter));
        }
    }
}
