package com.example.lesson7;

import java.io.Serializable;

public class Task implements Serializable {
    //  интерфейс дает возможность разобрать на части что бы отправить в интент. разберет на стринги
    public  String title;
    public  String description;
    public  String deadLine;
    // TODO: Поменять на тип дата

}
