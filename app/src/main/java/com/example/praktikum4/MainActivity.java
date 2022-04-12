package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;

    Button buttonWebsite;
    Button buttonLocation;
    Button buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_main));

        phoneNumber = findViewById(R.id.nohp);
        websiteUri = findViewById(R.id.url);
        locationUri = findViewById(R.id.lokasi);
        textShare = findViewById(R.id.teks);

        buttonWebsite = findViewById(R.id.buttonurl);
        buttonWebsite.setOnClickListener(this);

        buttonLocation = findViewById(R.id.buttonlokasi);
        buttonLocation.setOnClickListener(this);

        buttonText = findViewById(R.id.buttonteks);
        buttonText.setOnClickListener(this);
    }
    public void openDialPhone (View view) {
        Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.getText().toString()));
        startActivity(dialPhone);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonurl:
                Intent openWebsite = new
                        Intent(Intent.ACTION_VIEW,
                        Uri.parse(websiteUri.getText().toString()));
                startActivity(openWebsite);
                break;

            case R.id.buttonlokasi:
                Intent openLocation = new
                        Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + locationUri.getText().toString()));
                startActivity(openLocation);
                break;

            case R.id.buttonteks:
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType("text/plan")
                        .setChooserTitle("Share this text with : "
                        )
                        .setText(textShare.getText().toString())
                        .startChooser();
                break;
        }
    }
}