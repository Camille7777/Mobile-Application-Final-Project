package com.example.mobilefinalapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class myComposerActivity extends AppCompatActivity {

    Button backComposer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_composer);
        backComposer = findViewById(R.id.back_zyt);

        backComposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(myComposerActivity.this , ComposerMain.class);

                startActivity(i);
            }
        });
    }

}
