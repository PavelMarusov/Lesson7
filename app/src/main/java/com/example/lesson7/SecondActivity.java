package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText title;
    EditText descript;
    EditText deadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        title = findViewById(R.id.title);
        descript = findViewById(R.id.discripton);
        deadline = findViewById(R.id.deadLine);
        Button svBtn = findViewById(R.id.task_save);
        svBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task();
                // Проверка на пустые строки. Трим уберает все пробелы в начале и в конце
                if (title.getText().toString().trim().equals("")) {
                    message("Введите тему");
                    return;
                } else {
                    task.title = title.getText().toString().trim();
                }
                if (descript.getText().toString().trim().equals("")) {
                    message("Введите описание");
                    return;
                } else {
                    task.description = descript.getText().toString().trim();

                }
                if (deadline.getText().toString().trim().equals("")) {
                    message("Нет дэд лайн");
                    return;
                } else {
                    task.deadLine = deadline.getText().toString();
                }
                // Интент для возврата на гл экран инфы
                Intent intent = new Intent();
                intent.putExtra("task", task);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void message(String s) {
        // Таск всплывающие сообщения в конце обязательно добавить метод show()
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}
