package com.example.vincentmoriarty.sound_of_island;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Caffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffee);
        Button button_caffee = (Button) findViewById(R.id.button_caffee2town);
        button_caffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Caffee.this, The_town.class);
                startActivity(intent);
            }
        });
    }
}
