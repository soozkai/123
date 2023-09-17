package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_home);

        Button buttonPing = findViewById(R.id.button_ping);
        buttonPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a confirmation dialog before redirecting to FirstRespondersActivity
                showConfirmationDialog();
            }
        });
    }

    // Method to show the confirmation dialog
    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Ping")
                .setMessage("Are you sure you want to send a ping for emergency?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User confirmed, redirect to FirstRespondersActivity
                        redirectToFirstRespondersActivity();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User canceled, do nothing or show a message
                    }
                });
        builder.create().show();
    }

    // Method to redirect to the FirstRespondersActivity
    private void redirectToFirstRespondersActivity() {
        Intent intent = new Intent(this, FirstResponderActivity.class);
        startActivity(intent);
    }
}
