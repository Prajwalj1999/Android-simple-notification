package com.example.notification1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        /*
        //Broadcastreceiver registered dynamically
        // https://stackoverflow.com/a/8740845
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Custom intent action");
        registerReceiver(new NotificationReceiver(),intentFilter);
        */

        Intent mainIntent = new Intent(this,NotificationReceiver.class);
        mainIntent.setAction(" Main Notification clicked");
        PendingIntent pmainIntent = PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),mainIntent,0);

        Intent intent1 = new Intent(this,NotificationReceiver.class);
        intent1.setAction("Call Action");
        PendingIntent pIntent1 = PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),intent1,0);
        Intent intent2 = new Intent(this,NotificationReceiver.class);
        intent2.setAction("Dial Action");
        PendingIntent pIntent2 = PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),intent2,0);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("New mail from asdfg@gmail.com")
                .setContentText("Subject:")
                .setSmallIcon(R.drawable.ic_big_star)
                .setContentIntent(pmainIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_memory, "Call", pIntent1)
                .addAction(R.drawable.ic_memory, "Dial", pIntent2).build();

        notificationManager.notify(0,notification);


    }
}
