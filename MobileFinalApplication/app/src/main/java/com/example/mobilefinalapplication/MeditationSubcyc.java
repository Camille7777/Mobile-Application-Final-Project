package com.example.mobilefinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MeditationSubcyc extends AppCompatActivity {
    Button playbtncyc;

    MediaPlayer mpcyc;
    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    ImageView meditationBG;

    TextView firstLinecyc;

    ImageView centerimagecyc;

    Button cycClear;

   // ImageView clickImagecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_subcyc);
        bar_icon1 =findViewById(R.id.bar_icon1);
        bar_icon2 =findViewById(R.id.bar_icon2);
        bar_icon3 =findViewById(R.id.bar_icon3);
        bar_icon4 =findViewById(R.id.bar_icon4);
        bar_icon5 =findViewById(R.id.bar_icon5);
        playbtncyc=(Button) findViewById(R.id.cycBtnPlay);

        cycClear=(Button) findViewById(R.id.cycClear);

        meditationBG=findViewById(R.id.subpagecycbg);

        mpcyc=MediaPlayer.create(this,R.raw.cycmusic);
        mpcyc.seekTo(0);
        mpcyc.setVolume(60f,60f);
        firstLinecyc=findViewById(R.id.sessiontext1);

        centerimagecyc=findViewById(R.id.centreimagecyc);
        bar_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MeditationSubcyc.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MeditationSubcyc.this, ActivityMeditationcyc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MeditationSubcyc.this, ComposerMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MeditationSubcyc.this, NightMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MeditationSubcyc.this, MyPageMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    @SuppressLint("Range")
    public void playBtnClick(View view){
        if(!mpcyc.isPlaying())
        {
            mpcyc.start();
            playbtncyc.setBackgroundResource(R.drawable.cyc_pausebtn);
            meditationBG.setBackgroundResource(R.drawable.playbgmeditationcyc);
            firstLinecyc.setTextColor(Color.rgb(164, 204, 222));
            centerimagecyc.setAlpha(100f);
        }
        else {
            mpcyc.pause();
            playbtncyc.setBackgroundResource(R.drawable.cyc_playbtn);
            meditationBG.setBackgroundResource(R.drawable.subpagebgcyc);
            firstLinecyc.setTextColor(Color.rgb(81, 142, 170));
            centerimagecyc.setAlpha(0f);
        }

    }

    public void ReturnMainMeditationcyc()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
