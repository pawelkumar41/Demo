package com.util;

import com.common.CityData;
import com.common.Commons;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;



public class ServiceCitiesList {
    public static String b_st;
    public static String b_et;
    public static String m_et;
    public static String m_et2;
    public static CloseableHttpClient httpClient = HttpClients.createDefault();
    static HashMap<String, String> has = new HashMap<String, String>();
    static Properties prop = new Properties();
    static InputStream input = null;
    static String sActive = "";
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
    private static String oid = "";
    private static String model;
    private static String bookingIDForCustomer = "";
    private static String _id = "";
    private static String adminid = "";
    private static String priceInfoId = "";
    private static String priceInfoId1 = "";
    private static String getPriceInfoId2 = "";
    private static String accessLevel = "";


    @BeforeTest
    public static void login() throws Exception {
        input = new FileInputStream("config.properties");

        // load a properties file
        prop.load(input);
        sActive = prop.getProperty("Active");
    }

    @BeforeTest
    public static void userLogin() throws Exception {
        try

        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 20);
            String output1 = sdf.format(c.getTime());
            System.out.println(output1);
            b_st = output1.concat("T00:00:00");
            b_et = output1.concat("T10:00:00");
            m_et = output1.concat("T12:00:00");
            m_et2 = output1.concat("T11:00:00");
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

    @Test(priority = 1)
    public static void bangaloreCityLoad() throws Exception {
        try

        {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude1") + "&latitude1=" + bookingdetails.get("latitude1") + "&longitude2=" + bookingdetails.get("longitude2") + "&latitude2=" + bookingdetails.get("latitude2") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Bangalore");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("BANGALORE LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 2)
    public static void HydCityLoad() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Hyderabad");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Hyderabad LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }


    @Test(priority = 3)
    public static void NCR() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Delhi-NCR");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("NCR LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }
        @Test(priority = 4)
        public static void Mumbai() throws Exception {
            try {
                httpClient = HttpClients.createDefault();
                HashMap<String, String> bookingdetails;
                bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
                System.out.println("--Date--" + ServiceCitiesList.b_st);
                HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Mumbai");
                JSONObject object = new JSONObject();
                String message;
                message = object.toString();
                HttpResponse response = httpClient.execute(getRequest);
                System.out.println(getRequest);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                } else {
                    System.out.println("Mumbai LOAD SUCCESSFULL");
                }
            } finally

            {
                httpClient.close();
            }
    }


    @Test(priority = 5)
    public static void Chennai() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Mumbai");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Mumbai LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 6)
    public static void Pune() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Pune");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Pune LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }


    @Test(priority = 7)
    public static void Jaipur() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Jaipur");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Jaipur LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 8)
    public static void Mysore() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Mysore");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Mysore LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 9)
    public static void Vizag() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Vizag");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Vizag LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 10)
    public static void Coimbatore() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Coimbatore");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Coimbatore LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }

    @Test(priority = 11)
    public static void Chandigarh() throws Exception {
        try {
            httpClient = HttpClients.createDefault();
            HashMap<String, String> bookingdetails;
            bookingdetails = CityData.getHashmapfromtxt1("Bangalore.txt");
            System.out.println("--Date--" + ServiceCitiesList.b_st);
            HttpGet getRequest = new HttpGet(prop.getProperty(sActive) + "/api/v2/carInfo/startDate=" + ServiceCitiesList.b_st + "&endDate=" + ServiceCitiesList.b_et + "&longitude1=" + bookingdetails.get("longitude11") + "&latitude1=" + bookingdetails.get("latitude11") + "&longitude2=" + bookingdetails.get("longitude22") + "&latitude2=" + bookingdetails.get("latitude22") + "&carInfoID=0&bookingId=0?&customerID=" + ServiceCitiesList.customerid + "&pickupLocation=Chandigarh");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            } else {
                System.out.println("Chandigarh LOAD SUCCESSFULL");
            }
        } finally

        {
            httpClient.close();
        }
    }








}