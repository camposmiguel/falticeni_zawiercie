package com.miguelcamposrivera.a01_duckhunt;

import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView tvNick, tvTimer, tvCounter, tvStart;
    ImageView ivDuck;
    int counter = 0;
    String nick;
    boolean gameOver = false;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Restart game!
                counter = 0;
                tvCounter.setText("0");
                gameOver = false;
                fab.setVisibility(View.GONE);
                loadingGame();
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
        tvStart = findViewById(R.id.textViewStartGame);

        ivDuck.setVisibility(View.GONE);

        // Set the nickname
        tvNick.setText(nick);

        loadingGame();


    }

    private void loadingGame() {
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished <= 1000) {
                    tvStart.setText("Go!");
                } else {
                    tvStart.setText(String.valueOf(millisUntilFinished / 1000));
                }
            }

            public void onFinish() {
                tvStart.setVisibility(View.GONE);
                ivDuck.setVisibility(View.VISIBLE);
                // Move the duck to a random position when we start
                duckRandomPosition();
                // We start the timer (60s)
                startCountDown();

            }
        }.start();


    }

    private void startCountDown() {
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                showGameOverDialog();
                gameOver = true;
                fab.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    private void showGameOverDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("You've got this result: "+counter+" ducks")
                .setTitle("Game Over");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        // 4. Show the dialog
        dialog.show();

        // The method to close a dialog programmatically is:
        // dialog.dismiss();
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
        if(gameOver) {
            Toast.makeText(this, "The game is over. Restart to play!", Toast.LENGTH_SHORT).show();
        } else {
            duckRandomPosition();
            tvCounter.setText(String.valueOf(++counter));
        }

    }
}
