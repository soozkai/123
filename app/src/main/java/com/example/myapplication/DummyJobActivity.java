package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DummyJobActivity extends AppCompatActivity {

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

        respondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DummyJobActivity.this, "Job Accepted!", Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a confirmation dialog before being taken to jobs page
                redirectToViewJobsActivity();
            }
        });
    }

    // Method to redirect to the ViewJobsActivity
    private void redirectToViewJobsActivity() {
        Intent intent = new Intent(this, ViewJobsActivity.class);
        startActivity(intent);
    }
}
