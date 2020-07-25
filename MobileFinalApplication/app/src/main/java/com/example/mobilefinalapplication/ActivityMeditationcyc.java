package com.example.mobilefinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ActivityMeditationcyc extends AppCompatActivity {

    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    ImageView clickImagecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditationcyc);

        bar_icon1 =(Button)findViewById(R.id.bar_icon1);
        bar_icon2 =(Button)findViewById(R.id.bar_icon2);
        bar_icon3 =(Button)findViewById(R.id.bar_icon3);
        bar_icon4 =(Button)findViewById(R.id.bar_icon4);
        bar_icon5 =(Button)findViewById(R.id.bar_icon5);

        clickImagecyc= (ImageView) findViewById(R.id.cycmeditationseries1);
        clickImagecyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(

                        ActivityMeditationcyc.this,R.style.BottomSheet
                );
                View bottomSheet= LayoutInflater.from(getApplicationContext()).
                        inflate(R.layout.meditation_subpagecyc,(LinearLayout) findViewById(R.id.bottomlogcyc));
                bottomSheet.findViewById(R.id.subpagedialogcyc).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openSubMeditationcyc();
                    }
                });

                bottomSheetDialog.setContentView(bottomSheet);
                bottomSheetDialog.show();



                bar_icon1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent a = new Intent(ActivityMeditationcyc.this, SleepMain.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);
                    }
                });
                bar_icon2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent a = new Intent(ActivityMeditationcyc.this, ActivityMeditationcyc.class);
                       a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);
                    }
                });
                bar_icon3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent a = new Intent(ActivityMeditationcyc.this, ComposerMain.class);
                       a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);
                    }
                });
                bar_icon4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent a = new Intent(ActivityMeditationcyc.this, NightMain.class);
                      a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);
                    }
                });
                bar_icon5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent a = new Intent(ActivityMeditationcyc.this,SleepMain.class);

                       a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(a);
                    }
                });


            }
        });

    }

    public void openSubMeditationcyc()
    {
        Intent intent=new Intent(this,MeditationSubcyc.class);
        startActivity(intent);
    }
}
