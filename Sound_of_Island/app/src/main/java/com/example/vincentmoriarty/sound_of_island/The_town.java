package com.example.vincentmoriarty.sound_of_island;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class The_town extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_town);
        Button button_beach = (Button) findViewById(R.id.button_town2beach);
        button_beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_town.this, Beach.class);
                startActivity(intent);
            }
        });
        Button button_forest = (Button) findViewById(R.id.button_town2forest);
        button_forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_town.this, Forest.class);
                startActivity(intent);
            }
        });
        Button button_caffee = (Button) findViewById(R.id.button_town2caffee);
        button_caffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_town.this, Caffee.class);
                startActivity(intent);
            }
        });
        Button button_achievement = (Button) findViewById(R.id.button_town2achievement);
        button_achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_town.this, achievement.class);
                startActivity(intent);
            }
        });
        Button button_calendar = (Button) findViewById(R.id.button_town2calendar);
        button_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_town.this, calendar.class);
                startActivity(intent);
            }
        });

    }
    public void begger_button(View v){
        AlertDialog.Builder support = new AlertDialog.Builder(The_town.this);
        support.setTitle("开发者");
        support.setMessage("SNXF\nCY\nKN\nLHT\nYWT");
        support.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        support.show();
    }
}
