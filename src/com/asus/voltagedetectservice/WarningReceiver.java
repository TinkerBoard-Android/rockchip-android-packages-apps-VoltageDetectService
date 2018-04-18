package com.asus.voltagedetectservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WarningReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification warningNotification = new Notification();

        int icon = R.drawable.iconplug;
        long when = System.currentTimeMillis();

        warningNotification.icon = icon;
        warningNotification.when = when;

        Intent nIntent = new Intent(context, WarningActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, nIntent, 0);
        warningNotification.setLatestEventInfo(context, "Low Voltage", "Click to show more", pIntent);
        nManager.notify(1, warningNotification);
    }
}
