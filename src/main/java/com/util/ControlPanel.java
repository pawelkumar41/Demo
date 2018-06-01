package com.util;

import com.Database.MongoConnection;
import com.common.Logins;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by pawelkumar on 31/05/18.
 */
public class ControlPanel{
    private static String customerid = "";
    private static String accessToken = "";
    private static String c_accessToken="";
    private static String endDate = "";
    private static String startDate = "";
    private static String longitude1 = "";
    private static String longitude2 = "";
    private static String latitude1 = "";
    private static String latitude2 = "";
    private static String carModelId = "";
    private static String oid="";
    private static String model;
    private static String bookingIDForCustomer="";
    private static String _id = "";
    private static String adminid = "";
    private static String priceInfoId = "";
    private static String priceInfoId1="";
    private static String getPriceInfoId2="";
    private static String accessLevel="";
    static HashMap<String, String> has = new HashMap<String, String>();

    public static DefaultHttpClient httpClient = new DefaultHttpClient();

    @BeforeTest
    public static void login() throws Exception {
        Logins.main();
    }

    @Test
    //car list
    public static void getModelList() throws Exception {
        try
        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/ModelList");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            System.out.println(resMessage);
        }
        finally

        {
            System.out.println("ModelList load successfull");
            httpClient.close();
        }

    }

    @Test
    //car list
    public static void getHubIDsList() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubIDsList");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            System.out.println(resMessage);
        }
        finally

        {
            System.out.println("HubIDsList load successfull");
            httpClient.close();
        }

    }

    @Test
    //car list
    public static void getrouteIPP() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/routeIPP/get");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            System.out.println(resMessage);
        }
        finally

        {
            System.out.println("routeIPP load successfull");
            httpClient.close();
        }

    }

    @Test
    //car list
    public static void controlPanelAll() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/controlPanel/all");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            System.out.println(resMessage);
        }
        finally

        {
            System.out.println("controlPanel load successfull");
            httpClient.close();
        }

    }

    @Test
    //car list
    public static void getServiceCityList() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getServiceCityList");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            System.out.println(resMessage);
        }
        finally

        {
            System.out.println("ServiceCityList load successfull");
            httpClient.close();
        }

    }

    @Test
    //add car
    public static void addcar() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/admin/"+Logins.adminid+"/"+Logins.accessToken+"/controlPanel/addCar");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("accessLevel", 0);
            object.put("currentKmReading", "0");
            object.put("carModelID", "55fb290a2fa41dba37c67c47");
            object.put("hubID", "55fb26fb2fa41dba37c67c45");
            object.put("registrationNumber", "AutomationTest");
            object.put("serviceCityID", "5614f2caed142d0983f9124d");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 201) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 = null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            object1 = object1.getJSONObject("data");
            System.out.print(resMessage);



        }
        finally

        {
            MongoConnection.deletecar();
            httpClient.close();
        }


    }


}
