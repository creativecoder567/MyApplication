package com.sarath.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import android.text.Layout;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.ToggleButton;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    Button changeBakground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeBakground = (Button)findViewById(R.id.btnchangeBakground);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.btnToggle);
    }



    public void process(View view) {
        Intent chooser = null;
        switch (view.getId()) {

            case R.id.btnLaunchMap:
                Intent intentMap = new Intent(Intent.ACTION_VIEW);
                intentMap.setData(Uri.parse("geo:20.40,50.70"));
                Intent intentMapChooser = Intent.createChooser(intentMap, "Launch Maps");
                startActivity(intentMapChooser);
                break;
            case R.id.btnMarket:
                Intent intentMarket = new Intent(Intent.ACTION_VIEW);
                intentMarket.setData(Uri.parse("market://details?id=com.whatsapp&hl=en"));
                 chooser = Intent.createChooser(intentMarket, "Launch Market");
                startActivity(intentMarket);
                break;
            case R.id.btnMail:
                Intent email = new Intent(Intent.ACTION_SEND);
                String to = "kumarnsarath7@gmail.com";
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                String subject = "hi";
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                String messa = "hi";
                email.putExtra(Intent.EXTRA_TEXT, messa);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                break;
            case R.id.btnSend:
                Uri imageUri = Uri.parse("android.resource://sarath.myapplication/drawable/"+R.drawable.welcome);
                Intent intentimage = new Intent(Intent.ACTION_SEND);
                intentimage.setType("image/*");
                intentimage.putExtra(Intent.EXTRA_STREAM,imageUri);
                intentimage.putExtra(Intent.EXTRA_TEXT,"hey i have attached this image");
                chooser = Intent.createChooser(intentimage,"sendimage");
                startActivity(chooser);
                break;
            /*case R.id.btnNotification:
                Intent intentNotification = new Intent(getBaseContext(),Notification.class);
                startActivity(intentNotification);
                break;*/

            /*case R.id.btnchangeBakground:
              Intent  intentBC = new Intent(getBaseContext(), com.sarath.myapplication.PopMenu.class);
                startActivity(intentBC);
                break;*/
        }


    }

    public void popup(View view) {
        PopupMenu pm = new PopupMenu(getBaseContext(), view);
        MenuInflater inflater = pm.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, pm.getMenu());


        switch (view.getId()) {
            case R.id.pBlue:
                changeBakground.setBackgroundColor(Color.BLUE);
                break;
            case R.id.pGreen:
                changeBakground.setBackgroundColor(Color.GREEN);
                break;
            case R.id.pred:
                changeBakground.setBackgroundColor(Color.RED);
                break;
            case R.id.pCyan:
                changeBakground.setBackgroundColor(Color.CYAN);
                break;
            case R.id.pYellow:
                changeBakground.setBackgroundColor(Color.YELLOW);
                break;
        }
        pm.show();
    }
    public  void createNotification(View view){
        NotificationCompat.Builder notification;
        notification = new NotificationCompat.Builder(this);
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.setSound(Uri.parse("android.resource://" + view.getContext().getPackageName() + "/" + R.raw.solemn));
        notification.setSmallIcon(R.drawable.notification);
        notification.setTicker("This is the Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Title");
        notification.setContentText(" notification created");
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(123,notification.build());
    }
}


