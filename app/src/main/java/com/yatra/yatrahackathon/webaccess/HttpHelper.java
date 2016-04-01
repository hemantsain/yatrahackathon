package com.yatra.yatrahackathon.webaccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Arun on 27-08-2015.
 */
public class HttpHelper {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static InputStream sendGet(String url) throws IOException {

        URL obj = new URL(url.replaceAll(" ", "%20"));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

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
