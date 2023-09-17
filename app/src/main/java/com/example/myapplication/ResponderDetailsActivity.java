package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class ResponderDetailsActivity extends AppCompatActivity {

    private TextView etaTextView;
    private TextView locationTextView;
    private ImageView placeholderImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_details);

        // Initialize TextViews and ImageView
        etaTextView = findViewById(R.id.etaTextView);
        locationTextView = findViewById(R.id.locationTextView);
        placeholderImageView = findViewById(R.id.placeholderImageView);

        // Retrieve data from Intent extras
        String eta = getIntent().getStringExtra("ETA");
        String location = getIntent().getStringExtra("Location");

        // Set default values in case the data is null
        if (eta == null) {
            eta = "N/A"; // Set a default ETA value
        }

        if (location == null) {
            location = "N/A"; // Set a default location value
        }

        // Set data to TextViews
        etaTextView.setText("ETA: " + eta);
        locationTextView.setText("Location: " + location);
    }
}
