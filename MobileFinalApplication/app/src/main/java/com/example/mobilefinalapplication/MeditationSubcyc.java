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

    ImageView meditationBG;

    TextView firstLinecyc;

    ImageView centerimagecyc;

    Button cycClear;

   // ImageView clickImagecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_subcyc);

        playbtncyc=(Button) findViewById(R.id.cycBtnPlay);

        cycClear=(Button) findViewById(R.id.cycClear);

        meditationBG=findViewById(R.id.subpagecycbg);

        mpcyc=MediaPlayer.create(this,R.raw.cycmusic);
        mpcyc.seekTo(0);
        mpcyc.setVolume(60f,60f);
        firstLinecyc=findViewById(R.id.sessiontext1);

        centerimagecyc=findViewById(R.id.centreimagecyc);

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
