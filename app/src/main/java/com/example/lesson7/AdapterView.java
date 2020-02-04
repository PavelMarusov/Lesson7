package com.example.lesson7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<Task> tasks;
    public AdapterView(ArrayList<Task> tasks){
        this.tasks = tasks;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.onbind(tasks.get(position));
    }



    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
