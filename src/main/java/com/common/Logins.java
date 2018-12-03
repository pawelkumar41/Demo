/**
 * Created by pawelkumar on 06/11/17.
 */
package com.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Logins {

    public static String customerid = "";
    public static String android_customerid="";
    public static String accessToken = "";
    public static String c_accessToken = "";
    private static String _id = "";
    public static String adminid = "";
    public static String b_st;
    public static String b_et;
    public static String m_et;
    public static String m_et2;
    static HashMap<String, String> has = new HashMap<String, String>();

    public static DefaultHttpClient httpClient = new DefaultHttpClient();

    public static void main() throws Exception {
        Logins.adminLogin();
        Logins.userLogin();
        //DBCrash.serviceCityRead();
        //Logins.androidUserLogin();

    }

    public static void adminLogin() throws Exception {
        try

        {
            HashMap<String, String> adminDetails = null;
            adminDetails = Commons.getHashmapfromtxt("adminlogin.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("https://admin.revv.co.in/api/admin/login");
            //Set the API media type in http content-type header
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("email", adminDetails.get("email"));
            object.put("password", adminDetails.get("password"));
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            //read response
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object = new JSONObject(output);
            }
            String resMessage = object.getString("message");
            object1 = object.getJSONObject("data");
            adminid = object1.getString("_id");
            System.out.println("++Pawel++" + adminid);
            accessToken = object1.getString("accessToken");
            System.out.println("++Pawel++" + accessToken);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }

    public static void userLogin() throws Exception {
        try

        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 88);
            String output1 = sdf.format(c.getTime());
            System.out.println(output1);
            b_st=output1.concat("T00:00:00");
            b_et=output1.concat("T10:00:00");
            m_et=output1.concat("T12:00:00");
            m_et2=output1.concat("T11:00:00");
            System.out.println(b_st);
            System.out.println(b_et);
            System.out.println(m_et);
            System.out.println(m_et2);
            HashMap<String, String> userDetails = null;
            userDetails = Commons.getHashmapfromtxt("logindetails.txt");
            HttpPost postRequest = new HttpPost("https://admin.revv.co.in/api/v2/customer/login");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("email", userDetails.get("email"));
            object.put("password", userDetails.get("password"));
            object.put("deviceType", userDetails.get("deviceType"));
            object.put("deviceName", userDetails.get("deviceName"));
            object.put("deviceToken", userDetails.get("deviceToken"));
            object.put("appVersion", userDetails.get("appVersion"));
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object = new JSONObject(output);
            }
            String resMessage = object.getString("message");
            object1 = object.getJSONObject("data");
            customerid = object1.getString("customerID");
            c_accessToken = object1.getString("accessToken");
            System.out.println("++Pawel++" + customerid);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }


    /*public static void androidUserLogin() throws Exception {
        try

        {
            HashMap<String, String> userDetails = null;
            userDetails = Commons.getHashmapfromtxt("androidLogin.txt");
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v2/customer/login");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("email", userDetails.get("email"));
            object.put("password", userDetails.get("password"));
            object.put("deviceType", userDetails.get("deviceType"));
            object.put("deviceName", userDetails.get("deviceName"));
            object.put("deviceToken", userDetails.get("deviceToken"));
            object.put("appVersion", userDetails.get("appVersion"));
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object = new JSONObject(output);
            }
            String resMessage = object.getString("message");
            object1 = object.getJSONObject("data");
            android_customerid = object1.getString("customerID");
            c_accessToken = object1.getString("accessToken");
            System.out.println("++Pawel++" + customerid);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }*/

}
