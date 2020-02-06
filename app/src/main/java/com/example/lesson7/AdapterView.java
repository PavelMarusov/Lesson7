package com.example.lesson7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
IRefactorActivity iRefactorActivity;
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

    public void  idInterfase(IRefactorActivity listner){
        this.iRefactorActivity =listner;

    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDiscript;
        TextView textDeadline;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.VH_text_view_title);
            textDiscript = itemView.findViewById(R.id.VH_text_view_discript);
            textDeadline = itemView.findViewById(R.id.VH_text_view_deadline);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iRefactorActivity.goToRefactorActiv(getAdapterPosition());

                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    iRefactorActivity.delete();
                    return true;
                }
            });
        }

        public void  onbind( Task task){

            textTitle.setText(task.title);
            textDiscript.setText(task.description);
            textDeadline.setText(task.deadLine);
        }



    }
}


