package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class EmergencyMapActivity extends AppCompatActivity {

    private TextView emergencynumTextView;
    private TextView locationTextView;
    private ImageView placeholderImageView;
    private TextView areaTempTextView;
    private TextView humidityTextView;
    private Button viewJobsbtn;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_map);

        // Initialize TextViews, ImageViews and Buttons
        emergencynumTextView = findViewById(R.id.emergencynumTextView);
        locationTextView = findViewById(R.id.locationTextView);
        placeholderImageView = findViewById(R.id.placeholderImageView);
        areaTempTextView = findViewById(R.id.areaTempTextView);
        humidityTextView = findViewById(R.id.humidityTextView);
        viewJobsbtn = findViewById(R.id.viewJobsbtn);
        logoutBtn = findViewById(R.id.logoutbtn);

        viewJobsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirects to view jobs
                redirectToViewJobsActivity();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a confirmation dialog before being taken to login page
                showConfirmationDialog();
            }
        });

        // Retrieve data from Intent extras
//        String emergencynum = getIntent().getStringExtra("Current Emergencies");
//        String location = getIntent().getStringExtra("Location");
//        String areaTemp = getIntent().getStringExtra("Area Temperature");
//        String humidity = getIntent().getStringExtra("Humidity");
//
//        // Set default values in case the data is null
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

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User confirmed, redirect to FirstRespondersActivity
//                        redirectToLoginActivity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User canceled, do nothing or show a message
                    }
                });
        builder.create().show();
    }

    // Method to redirect to the View Jobs Activity
    private void redirectToViewJobsActivity() {
        Intent intent = new Intent(this, ViewJobsActivity.class);
        startActivity(intent);
    }

    // Method to redirect to the LoginActivity
//    private void redirectToLoginActivity() {
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }
}
