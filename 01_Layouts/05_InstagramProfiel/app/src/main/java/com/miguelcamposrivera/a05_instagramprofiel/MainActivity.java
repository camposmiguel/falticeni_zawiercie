package com.miguelcamposrivera.a05_instagramprofiel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.imageViewProfile);

        Picasso.get().load("https://instagram.fmad8-1.fna.fbcdn.net/vp/c6b4dbf4752e03afb97453c4782955f3/5B51ACF0/t51.2885-19/s320x320/27580324_1961241000859897_4541351977585475584_n.jpg").into(profileImage);
    }

    public void openWebsite(View view) {
        // The website address we want to open
        Uri webpage = Uri.parse("http://depechemode.com");

        // We're defining an Intent object to call to external
        // application.
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void callPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:954112233"));
        startActivity(intent);
    }
}
