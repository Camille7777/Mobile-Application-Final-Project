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


    ImageView clickImagecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditationcyc);



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


            }
        });

    }

    public void openSubMeditationcyc()
    {
        Intent intent=new Intent(this,MeditationSubcyc.class);
        startActivity(intent);
    }
}
