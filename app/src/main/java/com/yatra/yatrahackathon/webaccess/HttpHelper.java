package com.yatra.yatrahackathon.webaccess;

import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Arun on 27-08-2015.
 */
public class HttpHelper {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static InputStream sendGet(String url, String request) throws IOException {

        URL obj = new URL(url.replaceAll(" ", "%20"));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", "Universal API/uAPI-429725762", "Xz7Pr4BEH8mxgkXqJPpNeEq4Z").getBytes(), Base64.NO_WRAP);
        con.setRequestProperty("Authorization", basicAuth);
        con.setRequestProperty("Content-Type", "application/xml");

        OutputStream os = con.getOutputStream();

//Log.d("getMynCardParams--->",params[0]);

// String postParams = "uid="+params[2]+"&time="+params[1]+"&surveyIds="+params[0];
        os.write(request.getBytes());
        os.flush();
        os.close();
        //Log.d("url-->",url);

//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuilder response = new StringBuilder();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();

        return con.getInputStream();
    }
}
