package com.example.lesson7;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder  extends RecyclerView.ViewHolder {
    TextView textTitle;
    TextView textDiscript;
    TextView textDeadline;
    IRefactorActivity iRefactorActivity;


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
    }

    public void  onbind( Task task){

        textTitle.setText(task.title);
        textDiscript.setText(task.description);
        textDeadline.setText(task.deadLine);
    }

    
}
