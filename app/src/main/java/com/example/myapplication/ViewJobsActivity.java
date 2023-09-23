package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewJobsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ViewJobsAdapter adapter;
    private List<ViewJobs> jobsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the data source and adapter
        jobsList = createViewJobsList();
        ViewJobsAdapter adapter = new ViewJobsAdapter(jobsList, this);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private List<ViewJobs> createViewJobsList() {
        List<ViewJobs> list = new ArrayList<>();
        list.add(new ViewJobs("Fire Emergency", "Type: House Fire", "Danger Level: Medium"));
        list.add(new ViewJobs("Ambulance Emergency", "Type: Broken Leg", "Danger Level: Low"));
        list.add(new ViewJobs("Police Emergency", "Type: Noise Complaint", "Danger Level: Low"));
//        // Add more emergencies as needed
        return list;
    }
}
