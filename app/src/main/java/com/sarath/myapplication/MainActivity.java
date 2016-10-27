package com.sarath.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.PopupMenu;
import android.text.Layout;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Switch;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    Button button,changeBakground;
    ScrollView activity_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main = (ScrollView)findViewById(R.id.activity_main);
        changeBakground =(Button)findViewById(R.id.changeBakground);
        /*changeBakground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBakground.setBackgroundColor(Color.YELLOW);
            }
        });*/
    }

    public void process(View view) {
      Intent   chooser = null;
        switch (view.getId()) {

            case R.id.btnLaunchMap:
                Intent intentMap = new Intent(Intent.ACTION_VIEW);
                intentMap.setData(Uri.parse("geo:20.40,50.70"));
                chooser = Intent.createChooser(intentMap, "Launch Maps");
                startActivity(intentMap);
                break;
            case R.id.btnMarket:
               Intent intentMarket = new Intent(Intent.ACTION_VIEW);
                intentMarket.setData(Uri.parse("market://details?id=com.whatsapp&hl=en"));
               // chooser = Intent.createChooser(intent, "Launch Market");
                startActivity(intentMarket);
                break;
            case R.id.btnMail:
                Intent email = new Intent(Intent.ACTION_SEND);
                String to="kumarnsarath7@gmail.com";
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                String subject="hi";
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                String messa="hi";
                email.putExtra(Intent.EXTRA_TEXT, messa);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                break;
            /*case R.id.btnNotification:
                Intent intentNotification = new Intent(getBaseContext(),Notification.class);
                startActivity(intentNotification);
                break;
            case R.id.changeBakground:
              Intent  intentBC = new Intent(getBaseContext(), com.sarath.myapplication.PopMenu.class);
                startActivity(intentBC);
                break;*/
            }


        }
    }


