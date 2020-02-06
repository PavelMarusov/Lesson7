package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RefactorActivity extends AppCompatActivity {
    EditText titelFix;
    EditText discriptFix;
    EditText deadlineFix;
    Button editBtn;
    Button deletBtn;
    Task task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refactor);
        titelFix = findViewById(R.id.title_fix);
        discriptFix = findViewById(R.id.descrition_fix);
        deadlineFix = findViewById(R.id.deadline_fix);
        editBtn =findViewById(R.id.RA_edit_button);
        deletBtn =findViewById(R.id.RA_delete_button);

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("key");
        if(task!=null){
            titelFix.setText(task.title);
            discriptFix.setText(task.description);
            deadlineFix.setText(task.deadLine);
        }
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task();
                if (titelFix.getText().toString().trim().equals("")) {
                    message("Введите тему");
                    return;
                } else {
                    task.title = titelFix.getText().toString().trim();
                }
                if (discriptFix.getText().toString().trim().equals("")) {
                    message("Введите описание");
                    return;
                } else {
                    task.description = discriptFix.getText().toString().trim();

                }
                if (deadlineFix.getText().toString().trim().equals("")) {
                    message("Нет дэд лайн");
                    return;
                } else {
                    task.deadLine = deadlineFix.getText().toString();
                }
                Intent intent = new Intent();
                intent.putExtra("task", task);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        deletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });



    }
    public void message(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
