package com.miguelcamposrivera.a03_relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatar = findViewById(R.id.imageViewAvatar);

        Picasso.get().load("https://s3.amazonaws.com/uifaces/faces/twitter/felipebsb/128.jpg").into(avatar);
    }
}
