package com.yatra.yatrahackathon.notification;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by XVTS8308 on 06/27/15.
 */
public class Utils {

    private static final String SIMPLE_DATE_FORMAT = "EEE, MMM d, yyyy";
    public static final String DATE_FORMAT_MM_dd_yyyy = "MM.dd.yyyy";
    public static final String DATE_FORMAT_EEE_MM_d_yyyy_hh_mm_a = "EEE, MMM d, yyyy hh:mm a";
    private static final String SIMPLE_HOUR_DATE = "hh:mm a";

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public static String getMobileNumber(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(context.getApplicationContext().TELEPHONY_SERVICE);
        String number = tm.getLine1Number();
        return number;
    }

    public static String getDateStringFromLong(long timeInMillis) {
        Date date = new Date(timeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.US);
        String dateString = dateFormat.format(date);
        return dateString;
    }

    public static String getTimeStringFromLong(long timeInMillis) {
        Date date = new Date(timeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_HOUR_DATE, Locale.US);
        String dateString = dateFormat.format(date);
        return dateString;
    }

    public static long getLongTimeFromStringDate(String strDate, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static String retreivePackageName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return "com.dextromind.carpoolalwar";
        }
    }

}
