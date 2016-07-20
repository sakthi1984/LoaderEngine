package com.mobileiron.interview.loader.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sakthivel.v on 20/07/16.
 */
public class myHttpClient {
    private Logger logger = LoggerFactory.getLogger(myHttpClient.class);

    public String get(String url) {
        String inputLine;
        StringBuffer response = new StringBuffer();
        BufferedReader in;
        int responseCode;
        HttpURLConnection con;
        try {
            URL apiUrl = new URL(url);
            con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            responseCode = con.getResponseCode();
            logger.info("Getting URL: " + url);
            logger.info("Response Code: " + responseCode);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Connection Error!");
        }
        return response.toString();
    }

    public String post(String url) {
        int responseCode;
        BufferedReader in;
        String inputLine;
        StringBuffer response = new StringBuffer();
        HttpURLConnection con;
        try {
            URL apiUrl = new URL(url);
            con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoOutput(true);
            DataOutputStream dataStream = new DataOutputStream(con.getOutputStream());
            dataStream.flush();
            dataStream.close();
            responseCode = con.getResponseCode();
            logger.info("Running POST request to URL: " + url);
            logger.info("Response Code:  " + responseCode);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
            logger.error("Connection Error!");
        }
        return response.toString();
    }
}
