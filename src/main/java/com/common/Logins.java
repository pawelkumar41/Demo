/**
 * Created by pawelkumar on 06/11/17.
 */

package com.common;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Logins {

        public static String customerid = "";
        public static String accessToken = "";
        public static String c_accessToken = "";
        private static String _id = "";
        public static String adminid = "";
        static HashMap<String, String> has = new HashMap<String, String>();
        /**
         * @param args
         * @throws Exception
         */


        public static DefaultHttpClient httpClient = new DefaultHttpClient();

        public static void main() throws Exception {
            Logins.adminLogin();
            Logins.userLogin();

        }

        //@Test(priority = 1)
        //Below method is used to fetch admin details
        public static void adminLogin() throws Exception {
            try

            {
                HashMap<String, String> adminDetails = null;
                adminDetails = Commons.getHashmapfromtxt("adminlogin.txt");
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

       // @Test(priority = 2)
        //Below method is used to fetch user details
        public static void userLogin() throws Exception {
            try

            {
                HashMap<String, String> userDetails = null;
                userDetails = Commons.getHashmapfromtxt("logindetails.txt");
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
                c_accessToken = object1.getString("accessToken");
                System.out.println("++Pawel++" + customerid);

            } finally

            {
                //Important: Close the connect
                //  httpClient.getConnectionManager().shutdown();
            }

        }

    }
