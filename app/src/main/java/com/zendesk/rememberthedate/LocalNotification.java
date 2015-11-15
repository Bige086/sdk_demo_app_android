package com.zendesk.rememberthedate;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.zendesk.rememberthedate.ui.MainActivity;

public class LocalNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManagerCompat nm = NotificationManagerCompat.from(context);

        CharSequence from = "Remember the Date";
        CharSequence message = intent.getExtras().getString("message");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        final Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(from)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .build();

//        Notification notif = new Notification(R.drawable.ic_notification, message, System.currentTimeMillis());
//        notif.setLatestEventInfo(context, from, message, pendingIntent);
//        notif.flags = Notification.FLAG_AUTO_CANCEL;
//        nm.notify((int)System.currentTimeMillis(),notif);

        NotificationManagerCompat.from(context)
                .notify(0, notification);
    }
}