package com.example.mobilefinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.RelativeLayout;

public class ComposerMain extends AppCompatActivity{
    ImageButton playViolin, playFire, playWave, playRainy, playThunder, playBird, playWaterD;
    ImageButton likeBtn;
    ImageButton controlBtn;
    ImageButton adjustBtn;
    Button myCollection;
    Button collecttonlist;
    MediaPlayer mpzyt_violin, mpzyt_fire, mpzyt_wave, mpzyt_rainy, mpzyt_thunder, mpzyt_bird, mpzyt_water;
    int flag = 0;
    int flag_ctl = 0;
    int flag_volume = 0;
    RelativeLayout volumePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.composer_main);

        mpzyt_violin = MediaPlayer.create(ComposerMain.this, R.raw.violin_zyt);
        mpzyt_fire = MediaPlayer.create(ComposerMain.this, R.raw.fire_zyt);
        mpzyt_wave = MediaPlayer.create(ComposerMain.this, R.raw.wave_zyt);
        mpzyt_rainy = MediaPlayer.create(ComposerMain.this, R.raw.rain_zyt);
        mpzyt_bird = MediaPlayer.create(ComposerMain.this, R.raw.bird_zyt);
        mpzyt_thunder = MediaPlayer.create(ComposerMain.this, R.raw.thunder_zyt);
        mpzyt_water = MediaPlayer.create(ComposerMain.this, R.raw.waterdrop_zyt);

        mpzyt_violin.setLooping(true);
        mpzyt_fire.setLooping(true);
        mpzyt_wave.setLooping(true);
        mpzyt_rainy.setLooping(true);
        mpzyt_bird.setLooping(true);
        mpzyt_thunder.setLooping(true);
        mpzyt_water.setLooping(true);


        playViolin = findViewById(R.id.violinHang_zyt);
        playFire = findViewById(R.id.fireHang_zyt);
        playBird = findViewById(R.id.birdHang_zyt);
        playWaterD = findViewById(R.id.waterHang_zyt);
        playRainy = findViewById(R.id.rainHang_zyt);
        playThunder = findViewById(R.id.thunderHang_zyt);
        playWave = findViewById(R.id.waveHang_zyt);
        likeBtn = findViewById(R.id.like_zyt);
        controlBtn = findViewById(R.id.start_zyt);
        adjustBtn = findViewById(R.id.adjust_zyt);
        myCollection = findViewById(R.id.myCollection_zyt);
        collecttonlist = findViewById(R.id.collectionlist_zyt);
        volumePopup = findViewById(R.id.owncomposer_zyt);

        playViolin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_violin.isPlaying())
                {
                    mpzyt_violin.start();
                    playViolin.setBackgroundResource(R.drawable.violinlightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_violin.pause();
                    playViolin.setBackgroundResource(R.drawable.violin_zyt);
                }
            }
        });
        playFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_fire.isPlaying())
                {
                    mpzyt_fire.start();
                    playFire.setBackgroundResource(R.drawable.firelightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_fire.pause();
                    playFire.setBackgroundResource(R.drawable.fire_zyt);
                }
            }
        });
        playWave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_wave.isPlaying())
                {
                    mpzyt_wave.start();
                    playWave.setBackgroundResource(R.drawable.wavelightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_wave.pause();
                    playWave.setBackgroundResource(R.drawable.wave_zyt);
                }
            }
        });
        playRainy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_rainy.isPlaying())
                {
                    mpzyt_rainy.start();
                    playRainy.setBackgroundResource(R.drawable.rainlightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_rainy.pause();
                    playRainy.setBackgroundResource(R.drawable.rain_zyt);
                }
            }
        });
        playBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_bird.isPlaying())
                {
                    mpzyt_bird.start();
                    playBird.setBackgroundResource(R.drawable.birdlightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_bird.pause();
                    playBird.setBackgroundResource(R.drawable.bird_zyt);
                }
            }
        });
        playThunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_thunder.isPlaying())
                {
                    mpzyt_thunder.start();
                    playThunder.setBackgroundResource(R.drawable.thunderlightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_thunder.pause();
                    playThunder.setBackgroundResource(R.drawable.thunder_zyt);
                }
            }
        });
        playWaterD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mpzyt_water.isPlaying())
                {
                    mpzyt_water.start();
                    playWaterD.setBackgroundResource(R.drawable.waterdroplightened_zyt);
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                    flag_ctl = 1;
                }else{
                    mpzyt_water.pause();
                    playWaterD.setBackgroundResource(R.drawable.water_zyt);
                }
            }
        });

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0)
                {
                    flag = 1;
                    likeBtn.setBackgroundResource(R.drawable.like_pink);

                    myCollection.setVisibility(View.VISIBLE);
                    collecttonlist.setVisibility(View.VISIBLE);
                }
                else if(flag == 1){
                    flag = 0;
                    likeBtn.setBackgroundResource(R.drawable.like_zyt);

                    myCollection.setVisibility(View.GONE);
                    collecttonlist.setVisibility(View.GONE);
                }
            }
        });

        controlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag_ctl == 0)
                {
                    flag_ctl =1;
                    controlBtn.setBackgroundResource(R.drawable.pause_zyt);
                }
                else if(flag_ctl == 1){
                    flag_ctl = 0;
                    controlBtn.setBackgroundResource(R.drawable.start_zyt);
                    mpzyt_rainy.pause();
                    mpzyt_water.pause();
                    mpzyt_thunder.pause();
                    mpzyt_bird.pause();
                    mpzyt_wave.pause();
                    mpzyt_fire.pause();
                    mpzyt_violin.pause();
                    playViolin.setBackgroundResource(R.drawable.violin_zyt);
                    playFire.setBackgroundResource(R.drawable.fire_zyt);
                    playWave.setBackgroundResource(R.drawable.wave_zyt);
                    playRainy.setBackgroundResource(R.drawable.rain_zyt);
                    playThunder.setBackgroundResource(R.drawable.thunder_zyt);
                    playBird.setBackgroundResource(R.drawable.bird_zyt);
                    playWaterD.setBackgroundResource(R.drawable.water_zyt);
                }
            }
        });

        adjustBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag_volume == 0)
                {
                    flag_volume = 1;
                    volumePopup.setVisibility(View.VISIBLE);
                }
                else if(flag_volume == 1){
                    flag_volume = 0;
                    volumePopup.setVisibility(View.GONE);
                }
            }
        });
    }

}