package com.example.day20190709zhoukao1.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class http {

    //请求网络
    public static String getData(String s){
        try {
            URL url = new URL(s);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            int code = connection.getResponseCode();
            if (code==connection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str=reader.readLine())!=null){
                    builder.append(str);
                }
                reader.close();
                return builder.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
