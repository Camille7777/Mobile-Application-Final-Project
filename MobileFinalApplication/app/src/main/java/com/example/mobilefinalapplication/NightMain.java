package com.example.mobilefinalapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


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

    //insert message and receive message
    //insert values
    private String sendchat_url = "http://10.0.2.2:80/member/db/chatedit.php";
    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_CHATNAME = "chatname";
    private static final String KEY_CHATWORD = "chatword";
    private static final String KEY_EMPTY = "";
    private EditText etChatname;
    private EditText etChatword;
    private String chatname;
    private String chatword;
    private Button sendbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_talk_main);

        //insert data
        getJSON("http://10.0.2.2:80/member/db/chat.php");
        etChatname = findViewById(R.id.etEnterName_m);
        etChatword = findViewById(R.id.etEnterText_m);

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
                //animation
                email.setAlpha((float) 1.0);
                email.animate().alpha(1).translationY(-80).setDuration(300).start();
                email.playAnimation();

                //insert data
                chatword = etChatword.getText().toString();
                chatname = etChatname.getText().toString();

                if (validateInputs()) {
                    InsertData(chatname, chatword);
                }
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


    //insert data and receive data
    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json).append("\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);

        String[] heroes = new String[jsonArray.length()];


        TextView result = findViewById(R.id.text_rz);
        TextView resultname = findViewById(R.id.text2_rz);

        int index = (int)(Math.random()*(jsonArray.length()-1+1));

        JSONObject obj = jsonArray.getJSONObject(index);

        result.setText(obj.getString("chatword"));
        resultname.setText(obj.getString("chatname"));

        /*
        String[] heroes = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            heroes[i] = obj.getString("chatname");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, heroes);
        listView.setAdapter(arrayAdapter);
        */
    }


    //insert
    public void InsertData(final String chatname, final String chatword){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = chatname ;
                String WordHolder = chatword ;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("chatname", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("chatword", WordHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(sendchat_url);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(NightMain.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(chatname, chatword);
    }

    private boolean validateInputs() {
        if (KEY_EMPTY.equals(chatname)) {
            etChatname.setError("Full Name cannot be empty");
            etChatname.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(chatword)) {
            etChatword.setError("Username cannot be empty");
            etChatword.requestFocus();
            return false;
        }
        return true;
    }


}