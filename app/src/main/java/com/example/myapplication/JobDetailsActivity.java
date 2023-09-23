package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class JobDetailsActivity extends AppCompatActivity {

    private TextView emergencyclassTextView;
    private TextView emergencytypeTextView;
    private TextView locationTextView;
    private ImageView placeholderImageView;
    private TextView areaTempTextView;
    private TextView etaTextView;
    private Button respondbtn;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        // Initialize TextViews, ImageViews and Buttons
        emergencyclassTextView = findViewById(R.id.emergencyclassTextView);
        emergencytypeTextView = findViewById(R.id.emergencytypeTextView);
        locationTextView = findViewById(R.id.locationTextView);
        placeholderImageView = findViewById(R.id.placeholderImageView);
        areaTempTextView = findViewById(R.id.areaTempTextView);
        etaTextView = findViewById(R.id.etaTextView);
        respondbtn = findViewById(R.id.respondbtn);
        backBtn = findViewById(R.id.backbtn);

        String emergencyclass = getIntent().getStringExtra("Class");
        String emergencytype = getIntent().getStringExtra("Type");
        String location = getIntent().getStringExtra("Location");
        String eta = getIntent().getStringExtra("ETA");
        String areaTemp = getIntent().getStringExtra("Area Temperature");

        // Set default values in case the data is null
        if (emergencyclass == null) {
            emergencyclass = "N/A"; // Set a default ETA value
        }
        if (emergencytype == null) {
            emergencytype = "N/A"; // Set a default ETA value
        }
        if (location == null) {
            location = "N/A"; // Set a default ETA value
        }
        if (eta == null) {
            eta = "N/A"; // Set a default ETA value
        }
        if (areaTemp == null) {
            areaTemp = "N/A"; // Set a default ETA value
        }

        // Set data to TextViews
        emergencyclassTextView.setText("Class: " + emergencyclass);
        emergencytypeTextView.setText("Type: " + emergencytype);
        locationTextView.setText("Location: " + location);
        etaTextView.setText("ETA: " + eta);
        areaTempTextView.setText("Area Temperature: " + areaTemp);

        respondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(JobDetailsActivity.this, "Job Accepted!", Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a confirmation dialog before being taken to jobs page
                redirectToViewJobsActivity();
            }
        });

        // Retrieve data from Intent extras
//        String emergency = getIntent().getStringExtra("Current Emergencies");
//        String location = getIntent().getStringExtra("Location");
//        String areaTemp = getIntent().getStringExtra("Area Temperature");
//        String humidity = getIntent().getStringExtra("Humidity");

        // Set default values in case the data is null
//        if (emergencynum == null) {
//            emergencynum = "N/A"; // Set a default ETA value
//        }
//
//        if (location == null) {
//            location = "N/A"; // Set a default location value
//        }
//
//        if (areaTemp == null) {
//            areaTemp = "N/A"; // Set a default temperature value
//        }
//
//        if (humidity == null) {
//            humidity = "N/A"; // Set a default humidity value
//        }

        // Set data to TextViews
//        emergencynumTextView.setText("Current Emergencies: " + emergencynum);
//        locationTextView.setText("Location: " + location);
//        areaTempTextView.setText("Area Temperature: " + areaTemp);
//        humidityTextView.setText("Humidity: " + humidity);
    }


    // Method to redirect to the ViewJobsActivity
    private void redirectToViewJobsActivity() {
        Intent intent = new Intent(this, ViewJobsActivity.class);
        startActivity(intent);
    }
}
