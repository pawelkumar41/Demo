package com.util;

/**
 * Created by pawelkumar on 26/10/17.
 */

import com.common.Commons;
import com.common.Logins;
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

public class PromoCode {

    /**
     * @param args
     * @throws Exception
     */


    public static DefaultHttpClient httpClient = new DefaultHttpClient();
    static HashMap<String, String> has = new HashMap<String, String>();
    private static String customerid = "";
    private static String accessToken = "";
    private static String c_accessToken = "";
    private static String endDate = "";
    private static String startDate = "";
    private static String longitude1 = "";
    private static String longitude2 = "";
    private static String latitude1 = "";
    private static String latitude2 = "";
    private static String carModelId = "";
    private static String model;
    private static String bookingIDForCustomer = "";
    private static String _id = "";
    private static String adminid = "";
    private static String priceInfoId = "";
    private static String priceInfoId1 = "";
    private static String getPriceInfoId2="";
    private static int promoCodeAmount = 0;
    private static int adjustAmount = 0;

    @Test(priority = 1)
    public static void login() throws Exception {
        Logins.main();
    }

    @Test(priority = 2)
    public static void getCarInfo() throws Exception {
        try

        {
            HashMap<String, String> bookingdetails;
            bookingdetails = Commons.getHashmapfromtxt("WeekDay.txt");
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/v2/carInfo/startDate=" + bookingdetails.get("startdate") + "&endDate=" + bookingdetails.get("enddate") + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId=0?" + "customerID=" + Logins.customerid + "&deviceType=panel");
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

    @Test(priority = 3)
    public static void applyPromo() throws Exception {
        try

        {
            HashMap<String, String> userDetails = null;
            userDetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/promoCodes");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("bookingCharges", 690);
            object.put("carModel", carModelId);
            object.put("customerID", Logins.customerid);
            object.put("endDate", userDetails.get("enddate"));
            object.put("lat", userDetails.get("latitude1"));
            object.put("leadSource", "WEB");
            object.put("lng", userDetails.get("longitude1"));
            object.put("pricingType", 2);
            object.put("promoCodeName", "rv10");
            object.put("startDate", userDetails.get("startdate"));
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
            promoCodeAmount = object1.getInt("promoCodeAmount");
            System.out.println("++Pawel++" + promoCodeAmount);

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }

    @Test(priority = 4)
    public static void getPriceInfoPromo() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/setPriceInfo");
            System.out.println(postRequest);
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude", bookingdetails.get("latitude1"));
            object.put("longitude", bookingdetails.get("longitude1"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("promoCodeName", "");
            object.put("deviceType", bookingdetails.get("panel"));
            object.put("pricingType", 2);
            object.put("bookingID", "0");
            object.put("adminID", Logins.adminid);
            object.put("useRevvCredit", false);
            object.put("promoCodeName", "RV10");
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
            adjustAmount = object1.getInt("adjustAmount");
            System.out.print("Pawel Kumar Dalal" + priceInfoId + "Pawel Kumar Dalal" + adjustAmount);
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 5)

    public static void promoCodebooking() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/booking/bookByAdmin");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude1", bookingdetails.get("latitude1"));
            object.put("latitude2", bookingdetails.get("latitude2"));
            object.put("longitude1", bookingdetails.get("longitude1"));
            object.put("longitude2", bookingdetails.get("longitude2"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("alternateIDProofType", "2");
            object.put("adminID", Logins.adminid);
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

    public static void getCarModifyPromoInfo() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/v2/carInfo/startDate=" + bookingdetails.get("startdate") + "&endDate=" + bookingdetails.get("enddate") + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId=" + bookingIDForCustomer + "?" + "customerID=" + Logins.customerid);
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

    public static void getPriceInfoModifyPromo() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/setPriceInfo");
            System.out.println(postRequest);
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude", bookingdetails.get("latitude1"));
            object.put("longitude", bookingdetails.get("longitude1"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("promoCodeName", "RV10");
            object.put("deviceType", bookingdetails.get("panel"));
            object.put("pricingType", 2);
            object.put("bookingID", bookingIDForCustomer);
            object.put("adminID", Logins.adminid);
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


    public static void modifyPromoBooking() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            HttpPut putRequest = new HttpPut("http://staging.admin.revv.co.in/api/booking/modifyBookingByAdmin");
            putRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude1", bookingdetails.get("latitude1"));
            object.put("latitude2", bookingdetails.get("latitude2"));
            object.put("longitude1", bookingdetails.get("longitude1"));
            object.put("longitude2", bookingdetails.get("longitude2"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate"));
            object.put("bookingID", bookingIDForCustomer);
            object.put("adminID", Logins.adminid);
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
    // Below method is used to fetch available cars
    public static void getCarModifyInfo1() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/v2/carInfo/startDate=" + bookingdetails.get("startdate") + "&endDate=" + bookingdetails.get("enddate1") + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId="+bookingIDForCustomer+"?" + "customerID=" + Logins.customerid);
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

    @Test(priority = 10)
    //Below method is used to fetch priceinfo for further modification
    public static void getPriceInfoModifyWeekday1() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/v1/booking/setPriceInfo");
            System.out.println(postRequest);
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude", bookingdetails.get("latitude1"));
            object.put("longitude", bookingdetails.get("longitude1"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate1"));
            object.put("promoCodeName", "RV10");
            object.put("deviceType", bookingdetails.get("panel"));
            object.put("pricingType", 2);
            object.put("bookingID", "0");
            object.put("adminID", Logins.adminid);
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
            getPriceInfoId2 = object1.getString("priceInfoId");
        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }



    @Test(priority = 11)
    //Below method is used to modify booking, subtract x hrs
    public static void modifyBooking1() throws Exception {

        try

        {
            HashMap<String, String> bookingdetails = null;
            bookingdetails = Commons.getHashmapfromtxt("weekdayModify.txt");
            HttpPut putRequest = new HttpPut("http://staging.admin.revv.co.in/api/booking/modifyBookingByAdmin");
            putRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("customerID", Logins.customerid);
            object.put("accessToken", Logins.accessToken);
            object.put("carModelID", carModelId);
            object.put("latitude1", bookingdetails.get("latitude1"));
            object.put("latitude2", bookingdetails.get("latitude2"));
            object.put("longitude1", bookingdetails.get("longitude1"));
            object.put("longitude2", bookingdetails.get("longitude2"));
            object.put("startDate", bookingdetails.get("startdate"));
            object.put("endDate", bookingdetails.get("enddate1"));
            object.put("bookingID",bookingIDForCustomer);
            object.put("adminID", Logins.adminid);
            object.put("pickUpLocation1", bookingdetails.get("pickUpLocation1"));
            object.put("pickUpLocation2", bookingdetails.get("pickUpLocation2"));
            object.put("priceInfoID", getPriceInfoId2);
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

}
