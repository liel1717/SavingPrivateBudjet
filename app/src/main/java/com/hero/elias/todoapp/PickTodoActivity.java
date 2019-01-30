package com.hero.elias.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PickTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_todo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<StorageData.ToDo>(
                this,
                android.R.layout.simple_list_item_1,
                StorageData.todos
        ));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StorageData.ToDo clickedToDo = StorageData.todos.get(position);

                // Om jag tryckt på delete knappen så ska jag skickas vidare till DeleteTodoActivity
                Boolean deleteButtonPressed = getIntent().getBooleanExtra("DeletePressed", false);

                if (deleteButtonPressed) {
                    Intent intent = new Intent(PickTodoActivity.this, DeleteTodoActivity.class);
                    intent.putExtra("todoIndex", position);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(PickTodoActivity.this, ViewTodoActivity.class);
                    intent.putExtra("todoIndex", position);
                    startActivity(intent);
                }

            }
        });




        // Om jag får in extra information ifrån Delete knapp trycket
        // Så ge valet att delete istället för att läsa mer information!

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
