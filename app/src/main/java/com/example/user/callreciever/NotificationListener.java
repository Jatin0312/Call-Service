package com.example.user.callreciever;


import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

@TargetApi(Build.VERSION_CODES.KITKAT)
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class NotificationListener extends NotificationListenerService {
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.i(TAG, "Notification Posted");
        Log.i(TAG, sbn.getPackageName() +
                "\t" + sbn.getNotification().tickerText +
                "\t" + sbn.getNotification().extras.getString(Notification.EXTRA_TEXT));

        Bundle extras = sbn.getNotification().extras;

        String text = extras.getCharSequence("android.text").toString();
        String title = extras.getString("android.title");
        Log.d("text",text);
        Log.d("title",title);
        Intent msgrcv = new Intent("Msg");

        if ("Ongoing call".equals(text) || "Call Ongoing".equals(text) || "Call Answered".equals(text)) {
            Intent i = new Intent();
            i.putExtra("done","now");
            Toast.makeText(this, "Picked up phone", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        Log.d("Removed","Notification");
    }
}
