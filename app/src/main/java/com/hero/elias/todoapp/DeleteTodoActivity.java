package com.hero.elias.todoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DeleteTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Hittar rätt sträng ifrån todo listan, med hjälp av position jag får ifrån Intent

        TextView TodoText = (TextView) findViewById(R.id.deleteTextView);

        String text = StorageData.todos.get(getIntent().getIntExtra("todoIndex", 1)).toString();
        TodoText.setText(text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // När jag ska delete en ToDo
    public void DeleteTodoButtonPressed(View view){
        System.out.println("DELETE :   "+StorageData.todos.get(getIntent().getIntExtra("todoIndex", 1)).toString());

        new AlertDialog.Builder(this)
                .setTitle("Delete ToDo")
                .setMessage("Do you really want to delete it?")
                .setPositiveButton(
                        android.R.string.yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int whichButton){
                                // Delete it.
                                StorageData.todos.remove(getIntent().getIntExtra("todoIndex", 1));

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);

                                 }
                        }
                        ).setNegativeButton(
                                android.R.string.no,
                                new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int whichButton){
                                        // Do not delete it.
                                         }
                                }
                                ).show();
                            }

}



