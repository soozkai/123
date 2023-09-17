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

public class FirstResponderAdapter extends RecyclerView.Adapter<FirstResponderAdapter.ViewHolder> {

    private List<FirstResponder> responderList;
    private Context context; // Add a context variable

    public FirstResponderAdapter(List<FirstResponder> responderList, Context context) {
        this.responderList = responderList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first_responder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FirstResponder responder = responderList.get(position);
        holder.nameTextView.setText(responder.getName());
        holder.phoneTextView.setText(responder.getPhone());
        holder.typeTextView.setText(responder.getType());

        // Set an item click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the ResponderDetailsActivity
                Intent intent = new Intent(context, ResponderDetailsActivity.class);
                // Pass data to the ResponderDetailsActivity
                intent.putExtra("ResponderName", responder.getName());
                intent.putExtra("ResponderPhone", responder.getPhone());
                intent.putExtra("ResponderType", responder.getType());
                // Start the activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView phoneTextView;
        TextView typeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
        }
    }
}
