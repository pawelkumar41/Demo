package com.util;

import com.common.Logins;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Dump {

    static Properties prop = new Properties();
    static InputStream input = null;
    static String sActive="";
    public static CloseableHttpClient httpClient = HttpClients.createDefault();

    @BeforeTest
    public static void login() throws Exception {
        Logins.main();
        input = new FileInputStream("config.properties");
        // load a properties file
        prop.load(input);
        sActive= prop.getProperty("Active");
    }


    @Test(priority = 1)
    public static void getCarHubDump() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost(prop.getProperty(sActive)+"/api/get/car/hub");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("email", "pawel.kumar@revv.co.in");
            object.put("fromDate", "2018-10-01T00:00:00.000Z");
            object.put("toDate", "2018-10-02T00:00:00.000Z");
            String message;
            message = object.toString();
            System.out.println(message);
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            System.out.println(postRequest);
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode==200){
                System.out.println(statusCode);
                System.out.println("Success");
            }
            else if(statusCode != 200){
                System.out.println(statusCode);
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

        }
        finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }


    }

    @Test(priority = 2)
    public static void getDriverInOutTime() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost(prop.getProperty(sActive) + "/api/admin/getDriverInOutTime");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("email", "pawel.kumar@revv.co.in");
            object.put("fromDate", "2018-10-01T00:00:00.000Z");
            object.put("toDate", "2018-10-02T00:00:00.000Z");
            String message;
            message = object.toString();
            System.out.println(message);
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            System.out.println(postRequest);
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.println(statusCode);
                System.out.println("Success");
            } else if (statusCode != 200) {
                System.out.println(statusCode);
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

        @Test(priority = 3)
        public static void getbookingDump() throws Exception {

            try

            {
                httpClient = HttpClients.createDefault();
                HttpGet getRequest = new HttpGet("http://35.154.151.188:3333/api/admin/"+Logins.adminid+"/"+Logins.accessToken+"/3/getBookingSumPanel?searchKey=%7B%22startDate%22:%222018-10-02T18:30:00.000Z%22,%22endDate%22:%222018-10-03T18:30:00.000Z%22%7D");
                getRequest.addHeader("content-type", "application/json");
                JSONObject object = new JSONObject();
                String message;
                message = object.toString();
                System.out.println(message);
                HttpResponse response = httpClient.execute(getRequest);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode==200){
                    System.out.println(statusCode);
                    System.out.println("Success");
                }
                else if(statusCode != 200){
                    System.out.println(statusCode);
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }

            }
            finally

            {
                httpClient.close();
                //Important: Close the connect
                // httpClient.getConnectionManager().shutdown();
            }



        }



}