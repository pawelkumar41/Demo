package com.revv.util;

/**
 * Created by pawelkumar on 12/04/16.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import static com.revv.common.commons.getHashmapfromtxt;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import static com.revv.common.commons.getHashmapfromtxt;

public class peakSeason {

    public static String customerid="";
    public static    String startdate="";
    public static String endDate="";
    public static  String longi="";
    public static  String lat="";
    String model;
    static String _id="";
    static HashMap<String,String> has=new HashMap<String,String>();
    /**
     * @param args
     * @throws Exception
     */

    // public static void main(String args[]){
    //   PostRESTAPI();

    //}



    public static DefaultHttpClient httpClient = new DefaultHttpClient();
    @Test(priority = 1)
    public static void PostRESTAPI()  throws Exception {
        try

        {
            HashMap<String,String> userDetails=null;
            userDetails=getHashmapfromtxt("logindetails.txt");
            System.out.println("xyz");
            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/customer/login");
            //Set the API media type in http content-type header
            postRequest.addHeader("content-type", "application/json");
            //Set the request post body
            // StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
            //postRequest.setEntity(userEntity);
            JSONObject object = new JSONObject();
            object.put("email",userDetails.get("email"));
            object.put("password", userDetails.get("password"));
            object.put("deviceType", userDetails.get("deviceType"));
            object.put("deviceName", userDetails.get("deviceName"));
            object.put("deviceToken", userDetails.get("deviceToken"));
            object.put("appVersion", userDetails.get("appVersion"));
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            //Send the request; It will immediately return the response in HttpResponse object if any
            HttpResponse response = httpClient.execute(postRequest);
            //verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            //read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject object1 =null;
            while ((output = br.readLine()) != null) {
                object1 = new JSONObject(output);
            }
            String resMessage = object1.getString("message");
            object1=object1.getJSONObject("data");
            // object1= new JSONObject(data);
            customerid=object1.getString("customerID");
            //return customerid;
            //bookAPI();

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }

    }

    @Test(priority = 2)
    public static void  getCarInfo()  throws Exception {

        try

        {
            HashMap<String,String> bookingdetails=null;
            bookingdetails=getHashmapfromtxt("peakSeason.txt");
            //Define a postRequest request
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/carInfo/startDate="+bookingdetails.get("startdate")+"&endDate="+bookingdetails.get("endDate")+"&longitude="+bookingdetails.get("longi")+"&latitude="+bookingdetails.get("lat")+"&carInfoID=0&bookingId=0");

            getRequest.addHeader("content-type", "application/json");


            //Send the request; It will immediately return the response in HttpResponse object if any
            HttpResponse response = httpClient.execute(getRequest);
            //verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            // JSONParser parser=new JSONParser();


            //read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            StringBuilder output=new StringBuilder();
            String out;
            while ((out = br.readLine()) != null) {
                output.append(out);
            }



            String finaloutput=output.toString();
            JSONObject obj = new JSONObject(finaloutput);
            //String data=obj.getString("data");
            obj=obj.getJSONObject("data");
            //JSONObject obj1 = new JSONObject(data);
            org.json.JSONArray arr = obj.getJSONArray("carDetails");
            String tot_id="";
            String model="";
            HashMap<String,String> id=new HashMap<String, String>();
            for (int j = 0; j < arr.length(); j++) {
                JSONObject obj2 = arr.getJSONObject(j);
                model = obj2.getString("model");
                _id=obj2.getString("_id");
                try {
                    id.put(obj2.getString("model"), obj2.getString("_id"));
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
            //return id;
            //getPriceInfo(tot_id);


        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 3)
    public static void getPriceInfo() throws Exception {

        try

        {


            // has.put("carid","55fb29862fa41dba37c67c49");

            System.out.println("dddddddddddd"+_id);
            HashMap<String,String> bookingdetails=null;
            bookingdetails=getHashmapfromtxt("peakSeason.txt");
            //Define a postRequest request
            HttpGet getRequest = new HttpGet("http://staging.admin.revv.co.in/api/booking/carModelID="+_id+"&startDate="+bookingdetails.get("startdate")+"&endDate="+bookingdetails.get("endDate")+"&location="+bookingdetails.get("address")+"&latitude="+bookingdetails.get("lat")+"&longitude="+bookingdetails.get("longi")+"&bookingId=0");

            getRequest.addHeader("content-type", "application/json");


            //Send the request; It will immediately return the response in HttpResponse object if any
            HttpResponse response = httpClient.execute(getRequest);
            //verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            // JSONParser parser=new JSONParser();


            //read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            StringBuilder output = new StringBuilder();
            String out;
            while ((out = br.readLine()) != null) {
                output.append(out);
            }


            String finaloutput = output.toString();
            JSONObject obj = new JSONObject(finaloutput);
            obj = obj.getJSONObject("data");
            //JSONObject obj1 = new JSONObject(data);
            org.json.JSONArray arr = obj.getJSONArray("carDetails");
            String tot_id = "";
            for (int j = 0; j < arr.length(); j++) {
                JSONObject obj2 = arr.getJSONObject(j);
                has.put("carid",_id);
                has.put("startDate",obj2.getString("startDate"));
                has.put("endDate",obj2.getString("endDate"));
                has.put("address",obj2.getString("address"));
                has.put("latitude", String.valueOf(obj2.getDouble("latitude")));
                has.put("longitude",String.valueOf(obj2.getDouble("longitude")));
                has.put("duration",obj2.getString("duration"));
                has.put("bookingCharges",String.valueOf(obj2.getDouble("bookingCharges")));
                has.put("total",String.valueOf(obj2.getDouble("total")));
                has.put("securityCharges",String.valueOf(obj2.getDouble("securityCharges")));
                has.put("fuelInsuranceTaxes",obj2.getString("fuelInsuranceTaxes"));
                has.put("homeDelivery",String.valueOf(obj2.getDouble("homeDelivery")));
                has.put("priceInfoID",obj2.getString("priceInfoID"));
                has.put("promoCodeName",obj2.getString("promoCodeName"));
                try {
                    has.put("promoCodeAmount",obj2.getString("promoCodeAmount"));

                }catch(Exception e) {
                    has.put("promoCodeAmount", "0");
                }
                has.put("customerId",customerid);

            }
            System.out.println("sssssssss"+has.get("customerId"));

            // return has;
            //  bookAPI("55fb29862fa41dba37c67c49",startDate,endDate,address,latitude,longitude,duration,bookingCharges,total,securityCharges,fuelInsuranceTaxes,homeDelivery,priceInfoID,promoCodeName,promoCodeAmount);


        } finally

        {
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 4)
    public static void bookAPI() throws Exception {

        try

        {
            String carid=has.get("carid");
            String startDate=has.get("startDate");
            String endDate=has.get("endDate");
            String address=has.get("address");
            String latitude=has.get("latitude");
            String longitude=has.get("longitude");
            String duration=has.get("duration");
            String bookingCharges=has.get("bookingCharges");
            String total=has.get("total");
            String securityCharges=has.get("securityCharges");
            String fuelInsuranceTaxes=has.get("fuelInsuranceTaxes");
            String homeDelivery=has.get("homeDelivery");
            String priceInfoID=has.get("priceInfoID");
            String promoCodeName=has.get("promoCodeName");
            String promoCodeAmount=has.get("promoCodeAmount");
            String customerid=has.get("customerId");





            //Define a postRequest request
            HttpPost postRequest = new HttpPost("http://staging.admin.revv.co.in/api/booking/bookByAdmin");

            postRequest.addHeader("content-type", "application/json");


            //postRequest.setEntity(userEntity);
            JSONObject object = new JSONObject();
            object.put("customerID", customerid);
            object.put("carModelID", carid);
            object.put("startDate", startDate);
            object.put("endDate", endDate);
            object.put("pickUpLocation", address);
            object.put("latitude", latitude);
            object.put("longitude", longitude);
            object.put("duration", duration);
            object.put("bookingCharges", bookingCharges);
            object.put("totalAmount", total);
            object.put("securityDeposit", securityCharges);
            object.put("fuelInsuranceTaxes", fuelInsuranceTaxes);
            object.put("homeDeliveryCharge", homeDelivery);
            object.put("priceInfoID", priceInfoID);
            object.put("promoCodeName",promoCodeName);
            object.put("promoCodeAmount",promoCodeAmount);

            String message;
            message = object.toString();


            postRequest.setEntity(new StringEntity(message, "UTF8"));
            //Send the request; It will immediately return the response in HttpResponse object if any
            HttpResponse response = httpClient.execute(postRequest);
            //verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            //if (statusCode != 201) {
            //throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            //}

            //read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String output;
            JSONObject obj =null;

            while ((output = br.readLine()) != null) {
                obj = new JSONObject(output);
            }
            // return obj.getString("message");

        } finally

        {
            //Important: Close the connect
            //  httpClient.getConnectionManager().shutdown();
        }
    }




}
