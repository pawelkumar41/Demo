package com.util;

import com.common.commons;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WeekDay {

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
    private static String model;
    private static String bookingIDForCustomer="";
    private static String _id = "";
    private static String adminid = "";
    private static String priceInfoId = "";
    private static String priceInfoId1="";
    static HashMap<String, String> has = new HashMap<String, String>();
    /**
     * @param args
     * @throws Exception
     */


    public static DefaultHttpClient httpClient = new DefaultHttpClient();

    @Test(priority = 1)
    public static void main() throws Exception {
        try

        {
            HashMap<String, String> adminDetails = null;
            adminDetails = commons.getHashmapfromtxt("adminlogin.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/admin/login");
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

    @Test(priority = 2)
    public static void userLogin() throws Exception {
        try

        {
            HashMap<String, String> userDetails = null;
            userDetails = commons.getHashmapfromtxt("logindetails.txt");
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
            customerid = object1.getString("customerID");
            c_accessToken=object1.getString("accessToken");
            System.out.println("++Pawel++" + customerid);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }

    @Test(priority = 3)
    public static void getCarInfo() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails;
            bookingdetails = commons.getHashmapfromtxt("WeekDay.txt");
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/v2/carInfo/startDate=" + bookingdetails.get("startdate") + "&endDate=" + bookingdetails.get("enddate") + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId=0?" + "customerID=" + customerid + "&deviceType=panel");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode + "Pawel Status Code");
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            StringBuilder output = new StringBuilder();
            String out;
            while ((out = br.readLine()) != null) {
                output.append(out);
            }
            String finalOutput = output.toString();
            JSONObject obj = new JSONObject(finalOutput);
            obj = obj.getJSONObject("data");
            System.out.println("++++++++++++");
            org.json.JSONArray arr = obj.getJSONArray("carModels");
            HashMap<String, String> id = new HashMap<String, String>();
            // for(int i=0;i<arr.length();i++){
            JSONObject obj2 = arr.getJSONObject(0);
            obj2.toString();
            System.out.println(obj2);
            carModelId = obj2.getString("_id");
            model = obj2.getString("model");
            try {
                id.put(obj2.getString("_id"), obj2.getString("model"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(carModelId);
            System.out.println(model);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 4)
    public static void getPriceInfoWeekday() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = commons.getHashmapfromtxt("WeekDay.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/setPriceInfo");
            System.out.println(postRequest);
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("accessToken", accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude", bookingdetails.get("latitude1"));
            object.put("longitude", bookingdetails.get("longitude1"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("promoCodeName", "");
            object.put("deviceType", bookingdetails.get("panel"));
            object.put("pricingType", 1);
            object.put("bookingID", "0");
            object.put("adminID", adminid);
            object.put("useRevvCredit", false);
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
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            object1 = object1.getJSONObject("data");
            priceInfoId = object1.getString("priceInfoId");
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 5)
    public static void book() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = commons.getHashmapfromtxt("WeekDay.txt");
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/booking/bookByAdmin");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("accessToken", accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude1", bookingdetails.get("latitude1"));
            object.put("latitude2", bookingdetails.get("latitude2"));
            object.put("longitude1", bookingdetails.get("longitude1"));
            object.put("longitude2", bookingdetails.get("longitude2"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("alternateIDProofType", "2");
            object.put("adminID", adminid);
            object.put("pickUpLocation1", bookingdetails.get("pickUpLocation1"));
            object.put("pickUpLocation2", bookingdetails.get("pickUpLocation2"));
            object.put("priceInfoID", priceInfoId);
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
            bookingIDForCustomer = object1.getString("bookingIDForCustomer");
            System.out.println("++Pawel++" + bookingIDForCustomer);
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }


    }

    @Test(priority = 6)

    public static void getCarModifyInfo() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails;
            bookingdetails = commons.getHashmapfromtxt("weekdayModify.txt");
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/v2/carInfo/startDate=" + bookingdetails.get("startdate") + "&endDate=" + bookingdetails.get("enddate") + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId="+bookingIDForCustomer+"?" + "customerID=" + customerid);
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode + "Pawel Status Code");
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            StringBuilder output = new StringBuilder();
            String out;
            while ((out = br.readLine()) != null) {
                output.append(out);
            }
            String finalOutput = output.toString();
            JSONObject obj = new JSONObject(finalOutput);
            obj = obj.getJSONObject("data");
            System.out.println("++++++++++++");
            org.json.JSONArray arr = obj.getJSONArray("carModels");
            HashMap<String, String> id = new HashMap<String, String>();
            // for(int i=0;i<arr.length();i++){
            JSONObject obj2 = arr.getJSONObject(0);
            obj2.toString();
            System.out.println(obj2);
            carModelId = obj2.getString("_id");
            model = obj2.getString("model");
            try {
                id.put(obj2.getString("_id"), obj2.getString("model"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(carModelId);
            System.out.println(model);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }


    }

    @Test(priority = 7)

    public static void getPriceInfoModifyWeekday() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = commons.getHashmapfromtxt("weekdayModify.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/setPriceInfo");
            System.out.println(postRequest);
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("accessToken", accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude", bookingdetails.get("latitude1"));
            object.put("longitude", bookingdetails.get("longitude1"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("promoCodeName", "");
            object.put("deviceType", bookingdetails.get("panel"));
            object.put("pricingType", 1);
            object.put("bookingID", "0");
            object.put("adminID", adminid);
            object.put("useRevvCredit", false);
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
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            object1 = object1.getJSONObject("data");
            priceInfoId1 = object1.getString("priceInfoId");
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 8)


    public static void modifyBooking() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = commons.getHashmapfromtxt("weekdayModify.txt");
            HttpPut putRequest = new HttpPut("http://staging.admin.revv.co.in/api/booking/modifyBookingByAdmin");
            putRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("accessToken", accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude1", bookingdetails.get("latitude1"));
            object.put("latitude2", bookingdetails.get("latitude2"));
            object.put("longitude1", bookingdetails.get("longitude1"));
            object.put("longitude2", bookingdetails.get("longitude2"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("bookingID",bookingIDForCustomer);
            object.put("adminID", adminid);
            object.put("pickUpLocation1", bookingdetails.get("pickUpLocation1"));
            object.put("pickUpLocation2", bookingdetails.get("pickUpLocation2"));
            object.put("priceInfoID", priceInfoId1);
            String message;
            message = object.toString();
            putRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(putRequest);
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
            object1 = object1.getJSONObject("data");
            //bookingIDForCustomer = object1.getString("bookingIDForCustomer");
            System.out.println("++Pawel++" + bookingIDForCustomer);
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }


    }

    @Test(priority = 9)


    public static void cancelWeekdayBooking() throws Exception {
        try

        {
            HashMap<String, String> bookingdetails = null;
            HttpPut putRequest = new HttpPut("http://staging.admin.revv.co.in/api/booking/cancel");
            putRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("accessToken", c_accessToken);
            object.put("bookingID", bookingIDForCustomer);
            String message;
            message = object.toString();
            putRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(putRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 218) {
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
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }


    }


}
