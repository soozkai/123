package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FirstResponderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirstResponderAdapter adapter;
    private List<FirstResponder> responderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_responders);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the data source and adapter
        responderList = createFirstResponderList();
        FirstResponderAdapter adapter = new FirstResponderAdapter(responderList, this);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private List<FirstResponder> createFirstResponderList() {
        List<FirstResponder> list = new ArrayList<>();
        list.add(new FirstResponder("Medical Emergency", "123", "Dial 123 for Medical Assistance"));
        list.add(new FirstResponder("Fire Emergency", "456", "Dial 456 for Fire Emergency"));
        // Add more emergency types and hotlines as needed
        return list;
    }
}
