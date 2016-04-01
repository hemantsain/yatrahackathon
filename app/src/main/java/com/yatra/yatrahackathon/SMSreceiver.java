package com.yatra.yatrahackathon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.yatra.yatrahackathon.notification.NotificationUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ibm_admin on 4/2/2016.
 */
public class SMSreceiver extends BroadcastReceiver {

//Your flight 9W827 on 10/04/2016 is expected to leave DEL at 21:50 hrs," +
//            "reach BLR at 00:31 hrs. To know your flight status.";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        String strMessage = "";

        if (extras != null) {
            Object[] smsextras = (Object[]) extras.get("pdus");

            for (int i = 0; i < smsextras.length; i++) {
                SmsMessage smsmsg = SmsMessage.createFromPdu((byte[]) smsextras[i]);

                String strMsgBody = smsmsg.getMessageBody().toString();
                if (strMsgBody.contains("flight")) {
                    String strMsgSrc = smsmsg.getOriginatingAddress();
                    strMessage += "SMS from " + strMsgSrc + " : " + strMsgBody;


                    Log.i("dfds", strMessage);
                    String flight = strMsgBody.substring(12, 17);
                    String date = strMsgBody.substring(21, 31);
                    String time = strMsgBody.substring(60, 65);

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        Date d = sdf.parse(date+" "+time);
                        NotificationUtils.setAlarm(context, d.getTime());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }
}
