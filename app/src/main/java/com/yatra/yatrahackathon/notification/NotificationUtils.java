package com.yatra.yatrahackathon.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import android.widget.RemoteViews;

import com.yatra.yatrahackathon.BookCabActivity;
import com.yatra.yatrahackathon.MainActivity;
import com.yatra.yatrahackathon.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by ibm_admin on 4/1/2016.
 */
public class NotificationUtils {

    public static void showNotification(Context context, Object news)
    {

//        // Creates an explicit intent for an ResultActivity to receive.
        Intent resultIntent = new Intent(context, MainActivity.class);
//        resultIntent.putExtra("news", news);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        // This ensures that the back button follows the recommended convention for the back key.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//
//        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
//
//        // Adds the Intent that starts the Activity to the top of the stack.
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        // Create remote view and set bigContentView.
        RemoteViews expandedView = new RemoteViews(context.getPackageName(), R.layout.notification_for_ask_survey);
        expandedView.setTextViewText(R.id.tvQuestion, "Hey");


        PendingIntent piBookNow = PendingIntent.getActivity(context, 101, new Intent(context, BookCabActivity.class)
                                                                          .putExtra("type", 1), PendingIntent.FLAG_UPDATE_CURRENT, null);

        expandedView.setOnClickPendingIntent(R.id.btnBookNow, piBookNow);


        PendingIntent piChoose = PendingIntent.getActivity(context, 102, new Intent(context, BookCabActivity.class)
                .putExtra("type", 2), PendingIntent.FLAG_UPDATE_CURRENT, null);

        expandedView.setOnClickPendingIntent(R.id.btnChoose, piBookNow);


        PendingIntent piCancel = PendingIntent.getBroadcast(context, 103, new Intent(context, NotificationBroadcast.class)
                                                                .putExtra("isCancel", true), PendingIntent.FLAG_UPDATE_CURRENT);

        expandedView.setOnClickPendingIntent(R.id.btnCancel, piBookNow);




//        expandedView.setImageViewBitmap(R.id.ivMediaUrl, remote_picture);

        Notification noti = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.notification_template_icon_bg)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle("Yatra")
                .setContentText("Rahul").build();

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
            noti.bigContentView = expandedView;

        noti.defaults |= Notification.DEFAULT_LIGHTS;
        noti.defaults |= Notification.DEFAULT_VIBRATE;
        noti.defaults |= Notification.DEFAULT_SOUND;

        noti.flags |= Notification.FLAG_ONLY_ALERT_ONCE;
        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, noti);
    }

    public static void setAlarm(Context context, long time)
    {
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, NotificationBroadcast.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.set(AlarmManager.RTC_WAKEUP, time,  pi); // Millisec * Second * Minute
    }



}
