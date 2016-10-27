package com.sarath.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by sarath on 10/25/2016.
 */

public class Notification extends AppCompatActivity{

      NotificationCompat.Builder notification;
    private static final int uniqueid=45612;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);

    }
   public  void createNotification(View view){
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
       notificationManager.notify(uniqueid,notification.build());
   }

}
