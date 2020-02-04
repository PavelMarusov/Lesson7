package com.example.lesson7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
ArrayList<Task> tasks = new ArrayList<>();
//дастаем таск создаем массив тасков .
RecyclerView recyclerView;
AdapterView adapter ;
Task task;
int position;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Task> savedTask = Storage.read(this);
        tasks = savedTask;
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new AdapterView(tasks);
        recyclerView.setAdapter(adapter);
        adapter.idInterfase(new IRefactorActivity() {
            @Override
            public void goToRefactorActiv(int position) {
                task =tasks.get(position);
                Intent intent = new Intent(MainActivity.this,RefactorActivity.class);
                intent.putExtra("key",task);
                startActivityForResult(intent,15);
            }
        });

        Button button = findViewById(R.id.open);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,42);
            }
        });



    }
    // переопределяем метод он активити резалт



    // логика добавления задач

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // проверяем реквест и резалт код(резалт код передаем сами там где принемаем интент)
        if(resultCode == RESULT_OK&& requestCode==42){
            // кастим для того что бы пришел таск а не сериалайзебл
            Task task = (Task) data.getSerializableExtra("task");
            // сохраняем в массив таск
            tasks.add(task);
            // вызываем у adapter метод notifyDataChange для того чтобы сообщить адаптеру об изменениях
            adapter.notifyDataSetChanged();
            Storage.save(tasks,this);
        }
        if(resultCode == RESULT_OK && requestCode ==15){
            Task task = (Task) data.getSerializableExtra("keys");
            tasks.add(task);
            adapter.notifyDataSetChanged();
            Storage.save(tasks,this);

        }


    }


}
