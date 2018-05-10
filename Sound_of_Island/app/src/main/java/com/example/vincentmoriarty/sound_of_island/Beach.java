package com.example.vincentmoriarty.sound_of_island;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class Beach extends AppCompatActivity {
    private TextView mTvShow;
    int fish = 10;//持有鱼的数量
    boolean boat_sound = false;//船的声音是否可用
    long settime=25*60*1000;//settime用于保存计时器的总时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);
        mTvShow = (TextView) findViewById(R.id.timer);
        Button button_beach = (Button) findViewById(R.id.button_beach2town);
        button_beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beach.this, The_town.class);
                startActivity(intent);
            }
        });
    }
    public void oncancel(View v) {
        timer.cancel();
        settime = 0;
        changeMillisInFuture(settime);
        mTvShow.setText("倒计时结束");
    }//结束按钮
    public void restart(View v) {
        changeMillisInFuture(settime);
        timer.start();
    }//开始按钮
    private CountDownTimer timer = new CountDownTimer(settime,1000) {
        long minute = 0;
        long second = 0;
        @Override
        public void onTick(long millisUntilFinished) {
            minute = millisUntilFinished/60000;
            second = (millisUntilFinished - minute*60000)/1000;
            mTvShow.setText(minute+":"+second);
        }

        @Override
        public void onFinish() {
            settime = 0;
            mTvShow.setEnabled(true);
            mTvShow.setText("倒计时结束");
        }
    };
    private void changeMillisInFuture(long time) {
        try {
            // 反射父类CountDownTimer的mMillisInFuture字段，动态改变定时总时间
            Class clazz = Class.forName("android.os.CountDownTimer");
            Field field = clazz.getDeclaredField("mMillisInFuture");
            field.setAccessible(true);
            field.set(timer, time);
        } catch (Exception e) {
            Log.e("Ye", "反射类android.os.CountDownTimer.mMillisInFuture失败： "+ e);
        }
    }//用于改变CountDownTimer的总时间
    public void fisherman(View v){
        AlertDialog.Builder give_fish = new AlertDialog.Builder(Beach.this);
        give_fish.setTitle("渔夫");
        give_fish.setMessage("要送一些鱼给他吗？");
        give_fish.setPositiveButton("是的"+"(" +fish+")", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (fish>0) {
                    fish--;
                    boat_sound = true;
                    time_choose();
                }else{
                    boat_sound = false;
                    time_choose();
                    Toast.makeText(Beach.this,"你没有足够的鱼",Toast.LENGTH_SHORT).show();
                }
            }
        });
        give_fish.setNegativeButton("不了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boat_sound = false;
                time_choose();
            }
        });
        give_fish.show();

    }//fisherman按钮将会打开一个对话框用于选择时间
    public void time_choose(){
        AlertDialog.Builder time_dia = new AlertDialog.Builder(Beach.this);
        time_dia.setTitle("你想钓鱼多久？");
        String[] time_menu = new String[]{"5min", "10min", "25min", "30min", "60min"};
        time_dia.setSingleChoiceItems(time_menu, 2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0: settime = 5*60*1000;break;
                    case 1: settime = 10*60*1000;break;
                    case 2: settime = 25*60*1000;break;
                    case 3: settime = 30*60*1000;break;
                    case 4: settime = 60*60*1000;break;
                }
            }
        });
        time_dia.setPositiveButton("开始", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeMillisInFuture(settime);
                timer.start();
            }
        });
        time_dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                settime = 0;
                changeMillisInFuture(settime);
                timer.cancel();
            }
        });
        time_dia.create().show();
    }//二级对话框，用于选择时间
}
