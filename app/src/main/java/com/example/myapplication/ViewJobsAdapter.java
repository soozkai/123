package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewJobsAdapter extends RecyclerView.Adapter<ViewJobsAdapter.ViewHolder> {

    private List<ViewJobs> jobsList;
    private Context context; // Add a context variable

    public ViewJobsAdapter(List<ViewJobs> jobsList, Context context) {
        this.jobsList = jobsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_jobs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewJobs job = jobsList.get(position);
        holder.emsTextView.setText(job.getEms());
        holder.typeTextView.setText(job.getType());
        holder.dangerTextView.setText(job.getDanger());

        // Set an item click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the ResponderDetailsActivity
                Intent intent = new Intent(context, JobDetailsActivity.class);
                // Pass data to the JobDetailsActivity
                intent.putExtra("EmergencyClass", job.getEms());
                intent.putExtra("EmergencyType", job.getType());
                intent.putExtra("EmergencyDanger", job.getDanger());
                // Start the activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView emsTextView;
        TextView typeTextView;
        TextView dangerTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emsTextView = itemView.findViewById(R.id.emergencyClassTextView);
            typeTextView = itemView.findViewById(R.id.emergencyTypeTextView);
            dangerTextView = itemView.findViewById(R.id.dangerLevelTextView);
        }
    }
}
