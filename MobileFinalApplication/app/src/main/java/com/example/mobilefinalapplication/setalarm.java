package com.example.mobilefinalapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mobilefinalapplication.MainActivity;
import com.example.mobilefinalapplication.R;

public class setalarm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button bar_icon1;
    Button bar_icon2;
    Button bar_icon3;
    Button bar_icon4;
    Button bar_icon5;
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView alarm_state;
    Context context;
    PendingIntent pending_intent;
    int sound_select;

    Animation atg,btgone,btgtwo;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_clock);
        atg=AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);
        // Initialize alarm manager, time picker, text update
        final AlarmManager alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final TimePicker alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);
        final TextView alarm_state = (TextView) findViewById(R.id.alarm_state);

        // Create calendar instance
        final Calendar calendar = Calendar.getInstance();

        // Create intent for AlarmReceiver class, send only once
        final Intent my_intent = new Intent(setalarm.this, com.example.mobilefinalapplication.AlarmReceiver.class);


        bar_icon1 =findViewById(R.id.bar_icon1);
        bar_icon2 =findViewById(R.id.bar_icon2);
        bar_icon3 =findViewById(R.id.bar_icon3);
        bar_icon4 =findViewById(R.id.bar_icon4);
        bar_icon5 =findViewById(R.id.bar_icon5);




        // Create spinner in main UI and corresponding ArrayAdapter
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.stepbrothers_array, android.R.layout.simple_spinner_item);
        // Specify layout used for option list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply adapter to spinner
        spinner.setAdapter(adapter);
        // Set onClickListener for spinner
        spinner.setOnItemSelectedListener(this);


        // Initialize start button and create onClickListener to start alarm
        Button alarm_on = (Button) findViewById(R.id.alarm_on);
        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        alarm_on.startAnimation(atg);

        alarm_off.startAnimation(atg);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set calendar based on user input
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                // Retrieve int values of hour and minute
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();

                // Convert ints into strings
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                // Handles to format time data
                if(hour > 12) hour_string = String.valueOf(hour - 12);
                if(minute < 10) minute_string = "0" + String.valueOf(minute);

                alarm_state.setText("Alarm set to: " + hour_string + ":" + minute_string);

                // Put extra string into my_intent, indicates on button pressed
                my_intent.putExtra("extra", "alarm on");

                // Input extra long into my_intent
                // Requests specific value from spinner
                my_intent.putExtra("sound_choice", sound_select);


                // Pending intent to delay intent until specific calendar time
                pending_intent = PendingIntent.getBroadcast
                        (setalarm.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                // Set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);

                Intent a = new Intent(setalarm.this, StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);

            }
        });

        // Initialize stop button and create onClick listener to stop alarm

        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(setalarm.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        bar_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setalarm.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setalarm.this, ActivityMeditationcyc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setalarm.this, ComposerMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setalarm.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        bar_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setalarm.this, SleepMain.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // Output id which user selected
        //Toast.makeText(parent.getContext(), "Spinner item is " + id, Toast.LENGTH_SHORT).show();
        sound_select = (int) id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

