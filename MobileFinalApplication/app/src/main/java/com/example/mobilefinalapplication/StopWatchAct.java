package com.example.mobilefinalapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.xml.datatype.Duration;


public class StopWatchAct extends AppCompatActivity {
    Button btnstart;
    Button btnstop;
    ImageView icanchor,circle;
    Animation roundingalone;
    Chronometer timeHere;
    TextView alarm_state,alarm_state2;
    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    Duration d;
    Animation atg,btgone,btgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_remainder);

        atg=AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);
        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);
        timeHere=findViewById(R.id.timeHere);
        icanchor=findViewById(R.id.icanchor);
        alarm_state=findViewById(R.id.alarm_state);
        alarm_state2=findViewById(R.id.alarm_state2);
        circle=findViewById(R.id.circle);

        bar_icon1 =findViewById(R.id.bar_icon1);
        bar_icon2 =findViewById(R.id.bar_icon2);
        bar_icon3 =findViewById(R.id.bar_icon3);
        bar_icon4 =findViewById(R.id.bar_icon4);
        bar_icon5 =findViewById(R.id.bar_icon5);

        btnstart.setAlpha(0);
        timeHere.startAnimation(atg);
        btnstop.setAnimation(btgtwo);
        circle.setAnimation(btgtwo);
        alarm_state.setAlpha(0);
        alarm_state2.setAlpha(0);
        //load animations
        roundingalone=AnimationUtils.loadAnimation(this,R.anim.roundingalone);
        icanchor.startAnimation(roundingalone);
        btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
        btnstart.animate().alpha(0).setDuration(300).start();



     

        timeHere.setBase(SystemClock.elapsedRealtime());
        timeHere.start();
        long millis=SystemClock.elapsedRealtime();


        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alarm_state.animate().alpha(1).start();

                int elapsed = (int)(SystemClock.elapsedRealtime()-timeHere.getBase());
                timeHere.stop();
                icanchor.clearAnimation();
                if(elapsed<60000)
                alarm_state2.setText("Your sleep time is "+String.valueOf(elapsed/1000)+" sec");
                else if (elapsed>60000)
                {
                    alarm_state2.setText("Your sleep time is "+String.valueOf(elapsed/60000)+" min "+String.valueOf((elapsed%60000)/1000)+" sec");
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(1000); // 休眠1秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        alarm_state.setAlpha(0);
                        alarm_state2.setAlpha(1);
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        try {
                            Thread.sleep(3000); // 休眠1秒
                        } catch (InterruptedException d) {
                            d.printStackTrace();
                        }

                        Intent a = new Intent(StopWatchAct.this, com.example.mobilefinalapplication.setalarm.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);

                    }
                }).start();
            }

        });

        bar_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StopWatchAct.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StopWatchAct.this, ActivityMeditationcyc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StopWatchAct.this, ComposerMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StopWatchAct.this, NightMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StopWatchAct.this, MyPageMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }

}
