package com.example.lesson7;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Storage  {

    public  static void save (ArrayList<Task> tasks, Context context){
        Gson gson = new Gson();
        String jsonTask = gson.toJson(tasks);
        SharedPreferences sp = context.getSharedPreferences("Spisok",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("task",jsonTask);
        editor.commit();



    }

    static ArrayList<Task> read(Context context){
        SharedPreferences sp = context.getSharedPreferences("Spisok",Context.MODE_PRIVATE);
       String jsonTask =  sp.getString("task","");
       if (jsonTask==""){return  new ArrayList<>();}
       Gson gson = new Gson();
       ArrayList<Task> tasks = gson.fromJson(jsonTask,new TypeToken<ArrayList<Task>>(){}.getType());
       return  tasks;
    }
}
