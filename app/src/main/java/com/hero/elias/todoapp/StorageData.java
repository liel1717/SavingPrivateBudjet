package com.hero.elias.todoapp;

import java.util.ArrayList;

public class StorageData {

    public static ArrayList<ToDo> todos = new ArrayList<>();
    static{
        todos.add(new ToDo("Do A"));
        todos.add(new ToDo("Do B"));
        todos.add(new ToDo("Do C"));
    }

    public static class ToDo{
        public String title;
        public ToDo(String title) { this.title = title; }
        @Override
        public String toString() { return "ToDo: " +this.title; }
    }
}
