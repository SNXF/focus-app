package com.example.vincentmoriarty.sound_of_island;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Beach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);
        Button button_beach = (Button) findViewById(R.id.button_beach2town);
        button_beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beach.this, The_town.class);
                startActivity(intent);
            }
        });
    }
}
