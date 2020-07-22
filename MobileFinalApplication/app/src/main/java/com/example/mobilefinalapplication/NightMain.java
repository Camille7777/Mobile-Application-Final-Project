package com.example.mobilefinalapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class NightMain extends AppCompatActivity {
    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    Button email_rz;
    LottieAnimationView email;
    TextView text_rz;
    TextView text2_rz;
    ImageView icon_rz;


    Animation atg, btgone, btgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_talk_main);

        bar_icon1 =findViewById(R.id.bar_icon1);
        bar_icon2 =findViewById(R.id.bar_icon2);
        bar_icon3 =findViewById(R.id.bar_icon3);
        bar_icon4 =findViewById(R.id.bar_icon4);
        bar_icon5 =findViewById(R.id.bar_icon5);
        email_rz=findViewById(R.id.email_rz);
        email=findViewById(R.id.email);

        text_rz=findViewById(R.id.text_rz);
        text2_rz=findViewById(R.id.text2_rz);
        icon_rz=findViewById(R.id.icon_rz);

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);


        text_rz.startAnimation(atg);
        text2_rz.startAnimation(btgone);
        icon_rz.startAnimation(btgone);
        email_rz.startAnimation(btgtwo);

        email.setAlpha((float) 0.0);

        //load animations
        email_rz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setAlpha((float) 1.0);
                email.animate().alpha(1).translationY(-80).setDuration(300).start();
                email.playAnimation();
            }
        });



        bar_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NightMain.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NightMain.this, ActivityMeditationcyc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NightMain.this, ComposerMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NightMain.this, NightMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NightMain.this, MyPageMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }


}