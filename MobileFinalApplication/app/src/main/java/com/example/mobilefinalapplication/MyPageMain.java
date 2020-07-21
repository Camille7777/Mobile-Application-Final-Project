package com.example.mobilefinalapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageMain extends AppCompatActivity {
    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_page);

        bar_icon1 =findViewById(R.id.bar_icon1);
        bar_icon2 =findViewById(R.id.bar_icon2);
        bar_icon3 =findViewById(R.id.bar_icon3);
        bar_icon4 =findViewById(R.id.bar_icon4);
        bar_icon5 =findViewById(R.id.bar_icon5);

        bar_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyPageMain.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyPageMain.this, ActivityMeditationcyc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyPageMain.this, ComposerMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyPageMain.this, NightMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyPageMain.this, MyPageMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }


}
