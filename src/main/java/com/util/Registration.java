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
//Note its a demo, assertions are not there

public class Registration {


    private static CloseableHttpClient httpClient;

    @Test
    public static void reg() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("https://staging-b2b.emasdigi.com/api/vendor/v1/account/");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "ab059da0-d80e-11e8-b534-51e13309b637");
            postRequest.addHeader("User-Agent", "vendor-id:1");
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
            if (statusCode == 200) {
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


    @Test
    public static void getAccountBalance() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "ab059da0-d80e-11e8-b534-51e13309b637");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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

    @Test
    public static void ternsAndCond() throws Exception {

        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("staging-b2b.emasdigi.com/api/vendor/v1/account/739/termsandconditions");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            postRequest.addHeader("User-Agent", "vendor-id:7");
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


    @Test
    public static void updateKyc1() throws Exception {

        //Update KYC 1

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void geyKycStatus() throws Exception {

        //Get KYC Status

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/kyc");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void calculateTheGoldPrice() throws Exception {

        //Calculate the gold prices

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/products/gold?action=sell&type=gram&amount=14.97&currency=IDR");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void goldPrice() throws Exception {

        //Calculate the gold prices

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/products/gold/prices");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void calculateGOldInstallment() throws Exception {

        //Calculate Gold Installment

        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/products/gold/installment?amount=100000&tenure=6&currency=IDR");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void listGoldTransactionHistory() throws Exception {

        //Gold Transaction History
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void transactionStatus() throws Exception {

        //Transaction Status
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction?transaction_number=TRX123&type=buy");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void goldBuyTransaction() throws Exception {

        //Gold Buy Transaction
        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/po");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            postRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            object.put("reference", "REF-0001");
            object.put("amount", 1);
            object.put("unit_price", 582330);
            object.put("currency", "IDR");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
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


    @Test
    public static void goldSellTransaction() throws Exception {

        //Gold Sell Transaction
        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/so");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            postRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            object.put("reference", "REF-0001");
            object.put("amount", 1);
            object.put("unit_price", 582330);
            object.put("currency", "IDR");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
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


    @Test
    public static void InsquiryInstallmentDetail() throws Exception {

        //Inquiry installment detaisl
        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/installment/transaction_number");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            postRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            object.put("reference", "REF-0001");
            object.put("amount", 1);
            object.put("unit_price", 582330);
            object.put("currency", "IDR");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
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


    @Test
    public static void inquiryInstallmentDetail() throws Exception {

        //Transaction Status
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/installment/123456");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void installmentPayment() throws Exception {

        //Installment payment
        try

        {
            httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/installment/1234");
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            postRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            object.put("reference", "REF-0001");
            object.put("amount", 1);
            object.put("unit_price", 582330);
            object.put("currency", "IDR");
            object.put("signature", "{{signature_local}}");
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
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


    @Test
    public static void totalGoldSell() throws Exception {

        //Cumulative Sell Transactions
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/account/739/transaction/gold/totalSell");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void termsAndConditions() throws Exception {

        //Display terms and conditions
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/termsandconditions");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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



    @Test
    public static void installmentGoldAmountOptions() throws Exception {

        //Installment Gold Amount Options
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/option/goldinstallment");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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



    @Test
    public static void installmentGoldTenumreOptions() throws Exception {

        //Display Gold tenure option
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/option/tenure");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void kycOption1() throws Exception {

        //Display KYC option 1
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/option/kyc1");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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


    @Test
    public static void kycOption2() throws Exception {

        //Display KYC option 2
        try

        {
            httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://staging-b2b.emasdigi.com/api/vendor/v1/option/kyc2");
            getRequest.addHeader("content-type", "application/json");
            getRequest.addHeader("api-key", "GaPWnbVwMKI5j7s7fEQtaF5S2Voe5Ix");
            getRequest.addHeader("User-Agent", "vendor-id:7");
            JSONObject object = new JSONObject();
            String message;
            message = object.toString();
            //getRequest.setEntity(new StringEntity(message, "UTF8"));
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
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
