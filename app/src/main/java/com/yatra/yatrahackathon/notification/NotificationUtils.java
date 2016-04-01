package com.yatra.yatrahackathon.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import android.widget.RemoteViews;

import com.yatra.yatrahackathon.MainActivity;
import com.yatra.yatrahackathon.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by ibm_admin on 4/1/2016.
 */
public class NotificationUtils {

    private void showNewData(Context context, Object news)
    {
//        Bitmap remote_picture = null;
//        try {
//            String mediaUrl = news.mediaUrl;
//            if(!TextUtils.isEmpty(news.videoRef) && !news.videoRef.equalsIgnoreCase("null")) {
//                mediaUrl = String.format(MynitApplication.YOUTUBE_URL, news.videoRef);
//            }
//            remote_picture = BitmapFactory.decodeStream((InputStream) new URL(mediaUrl).getContent());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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

    public void setAlarm()
    {

    }

}
