package com.yatra.yatrahackathon.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ibm_admin on 4/2/2016.
 */
public class NotificationBroadcast extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        if(bundle.getBoolean("isCancel", false))
        {

        }
        else
        {
            NotificationUtils.showNotification(context, null);
        }

    }
}
