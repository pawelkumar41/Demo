package com.util;

import com.common.Logins;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by pawelkumar on 29/05/18.
 */
public class HubsPickDelivery {
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


    @Test(priority = 1)
    //get bookings for delivery and pickup of a Saket hub
    public static void getDeliveryPickupList0() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/55fb26fb2fa41dba37c67c45?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("NCR load successfull");
            httpClient.close();
        }

    }

    /*@Test(priority = 2)
    //get bookings for delivery and pickup of a dummy hub
    public static void getDeliveryPickupList1() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/5614fa2654893b914967ad93?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 500) {
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
            System.out.println("Dummy load successfull");
            httpClient.close();
        }

    }*/

    @Test(priority = 3)
    //get bookings for delivery and pickup of a Madhapur hub
    public static void getDeliveryPickupList2() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/565725997dd9cd5d0c006ce2?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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

            System.out.println("Madhapur load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 4)
    //get bookings for delivery and pickup of a Bellandur hub
    public static void getDeliveryPickupList3() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/568e2c46e604ffb655acb753?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Bellandur load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 5)
    //get bookings for delivery and pickup of a Kalina hub
    public static void getDeliveryPickupList4() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/570666e1c7cdb98d13ed383a?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Kalina load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 6)
    //get bookings for delivery and pickup of a Chandigarh hub
    public static void getDeliveryPickupList5() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/5772594fe61f902b24096192?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Chandigarh load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 7)
    //get bookings for delivery and pickup of a Madipakkam hub
    public static void getDeliveryPickupList6() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/5876133eb034386fbe3ac1fd?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Madipakkam load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 8)
    //get bookings for delivery and pickup of a Jaipur hub
    public static void getDeliveryPickupList7() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/5876f03fcbe76e994421027c?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Jaipur load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 9)
    //get bookings for delivery and pickup of a Arval hub
    public static void getDeliveryPickupList8() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/58b80e218c6024af87e29ccf?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Arval load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 10)
    //get bookings for delivery and pickup of a Pune hub
    public static void getDeliveryPickupList9() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/58d51d4315ae23c461c85adc?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Pune load successfull");
            httpClient.close();
        }

    }
    @Test(priority = 11)
    //get bookings for delivery and pickup of a Vizag hub
    public static void getDeliveryPickupList10() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/58e3945d2267bd96537a2ea0?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Vizag load successfull");
            httpClient.close();
        }

    }
    @Test(priority = 12)
    //get bookings for delivery and pickup of a Mysore hub
    public static void getDeliveryPickupList11() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/59c16ed3a94dc44ff572fa5d?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println("3");
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
            System.out.println("Mysore load successfull");
            httpClient.close();
        }

    }

    @Test(priority = 13)
    //get bookings for delivery and pickup of a Coimbatore hub
    public static void getDeliveryPickupList12() throws Exception {
        try

        {
            httpClient = new DefaultHttpClient();
            HashMap<String, String> bookingdetails = null;
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/admin/" + Logins.adminid + "/" + Logins.accessToken + "/getHubPanel/59c1799ba94dc45a9f73db0f?page=1&perPage=20&searchKey=%7B%7D&sortParams=%7B%22sortKey%22:%22rescheduleTime%22,%22sortOrder%22:1%7D");
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
            System.out.println("Coimbatore load successfull");
            httpClient.close();
        }

    }

}
