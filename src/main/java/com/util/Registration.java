package com.util;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Not its a demo, assertions are not there

public class Registration {


    private static CloseableHttpClient httpClient;

    @Test(priority = 1)
    //Below method is used to create booking
    public static void reg() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("name", "Zeus Olympus");
            object.put("phone", "+62811717823");
            object.put("email", "zeus@gmail.com");
            object.put("birthdate", "1986-10-06");
            object.put("identity_card_number", "2938399222");
            object.put("tnc", true);
            object.put("signature", "{signature_local}");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 2)
    //Below method is used to create booking
    public static void getAccountBalance() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 3)
    //Below method is used to create booking
    public static void terms() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/termsandconditions");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("approved", "true");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 4)
    //Below method is used to create booking
    public static void kyc() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/kyc1");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("id_card_picture", "<multi-part>");
            object.put("self_potrait_picture", "<multi-part>");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 5)
    //Below method is used to create booking
    public static void kyc2() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/kyc2");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("spouse_name", "Hera Olympus");
            object.put("emergency_contact_name", "Ares Olympus");
            object.put("emergency_contact_number", "0811717823");
            object.put("emergency_contact_relationship", "Anak Kandung");
            object.put("tax_id_number", "01.234.567-9.012.345");
            object.put("job", "Karyawan Swasta");
            object.put("company_name", "PT Great Olympus");
            object.put("yearly_salary", "Rp. 250.000.000 - Rp. 500.000.000");
            object.put("mother_maiden_name", "Rhea Olympus");
            object.put("property_ownership", 2);
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 6)
    //Below method is used to create booking
    public static void kycStatus() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/kyc");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 7)
    //Below method is used to create booking
    public static void calculateGOldPrice() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/products/gold?action=&type=&amount=&currency=");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 8)
    //Below method is used to create booking
    public static void currentGoldPrice() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/products/gold/prices?currency=&days_limit=");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 8)
    //Below method is used to create booking
    public static void calcualateInstallment() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/products/gold/installment?amount=100000&tenure=6&type=currency&currency=IDR&gold=2");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 9)
    //Below method is used to create booking
    public static void listGoldTransationHistory() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold?trans_type=buy&start_date=&end_date=&page=&limit=");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 10)
    //Below method is used to create booking
    public static void transactionStatus() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction?transaction_number=TRX123&type=buy");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 11)
    //Below method is used to create booking
    public static void goldSell() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold/po");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("amount", 1);
            object.put("unit_price", "578050");
            object.put("currency", "IDR");
            object.put("reference", "REF-0001");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 12)
    //Below method is used to create booking
    public static void goldInstallmentSubmission() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold/installment");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("gold_amount", 10);
            object.put("tenure", 2);
            object.put("currency", "IDR");
            object.put("reference", "REF-0001");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 13)
    //Below method is used to create booking
    public static void inquiryInstallmentDetail() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold/installment/transaction_number");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }

    @Test(priority = 14)
    //Below method is used to create booking
    public static void installmentPaymnet() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpPost postRequest = new HttpPost("private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold/installment/transaction_number");
            postRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            object.put("total_amount", 565075.32);
            object.put("currency", "IDR");
            object.put("reference", "REF-0001");
            object.put("signature", "{{signature}}");
            object.put("installment_index", 3);
            String message;
            message = object.toString();
            postRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 15)
    //Below method is used to create booking
    public static void goldSellHistory() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/account/account_id/transaction/gold/totalSell");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 16)
    //Below method is used to create booking
    public static void termsAndc() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/termsandconditions");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 17)
    //Below method is used to create booking
    public static void goldAmtOption() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/option/goldinstallment");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 17)
    //Below method is used to create booking
    public static void goldTenureOption() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/option/tenure");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 17)
    //Below method is used to create booking
    public static void kycOption1() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/option/kyc1");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }


    @Test(priority = 18)
    //Below method is used to create booking
    public static void kycOption2() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            //HashMap<String, String> bookingdetails = null;
            //bookingdetails = Commons.getHashmapfromtxt("weekDay.txt");
            HttpGet getRequest = new HttpGet("https://private-anon-3d1d0e6245-edgglobalapidocumentationv11.apiary-mock.com/vendor/v1/option/kyc2");
            getRequest.addHeader("content-type", "application/json");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            System.out.println(statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;

        } finally

        {
            httpClient.close();
            //Important: Close the connect
            // httpClient.getConnectionManager().shutdown();
        }
    }
}







