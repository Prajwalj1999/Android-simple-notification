package com.example.notification1;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String action = intent.getAction().toString();
        Toast.makeText(context, "hai"+ action, Toast.LENGTH_LONG).show();
        if(action.equals("Call Action"))
        {
            notificationManager.cancel(0);
            //to cancel all notifications- notificationManager.cancelAll()
        }

    }
}
