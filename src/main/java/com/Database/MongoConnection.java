package com.Database;

import com.common.Commons;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.HashMap;



public class MongoConnection {
    public static String dbresponse="";
    public static String carInfoID="";
    public static String NCR = "";
    public static String rateCardVersion="";
    static HashMap<String, String> has = new HashMap<String, String>();
    //protected static String

    public static void dtdb (String bookingIDForCustomer, String realbookingIDForCustomer){

        {
            /*MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
            DB db = mongoClient.getDB("drive_car");
            System.out.println("Connect to database successfully");
            DBCollection coll=db.getCollection("bookingdetails");
            DBObject myDoc=coll.findOne();
            System.out.println(coll.getCount());
            BasicDBObject query=new BasicDBObject(bookingIDForCustomer,realbookingIDForCustomer);
            DBCursor cursor = coll.find(query);
            try {
                while(cursor.hasNext()) {
                    dbresponse=dbresponse.concat(cursor.next().toString());
                    carInfoID=cursor.curr().get("carInfoID").toString();
                    Assert.assertTrue(dbresponse.contains("bookingIDForCustomer"));
                }
            } finally {
                cursor.close();
            }*/

        }
    }

    public static void mblock(){
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        DBCollection coll1=db.getCollection("maintblock");
        BasicDBObject query1 = new BasicDBObject();
        query1.append("regn_no", "KA03AE0376");
        coll1.remove(query1);
    }

    public static void deleteAttachNo(){
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        DBCollection coll1=db.getCollection("hubnumbers");
        BasicDBObject query1 = new BasicDBObject();
        query1.append("mobileNumber","9642235588");
        coll1.remove(query1);
    }

    public static void deletecar(){
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        DBCollection coll1=db.getCollection("carinfos");
        BasicDBObject query1 = new BasicDBObject();
        query1.append("registrationNumber","AutomationTest");
        coll1.remove(query1);
    }

    //Verify door step for NCR in current version
    public static void doorStepNCR() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("5614f2caed142d0983f9124d"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String NCR = bookingdetails.get("NCR");
        int NCR1=Integer.parseInt(NCR);
        query1.put("serviceCityID",new ObjectId("5614f2caed142d0983f9124d"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",NCR1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Jaipur in current version
    public static void doorStepJaipur() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("5876295db034386fbe3ac236"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Jaipur = bookingdetails.get("Jaipur");
        int Jaipur1=Integer.parseInt(Jaipur);
        query1.put("serviceCityID",new ObjectId("5876295db034386fbe3ac236"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Jaipur1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Chandigarh in current version
    public static void doorStepChandigarh() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("57725862e61f902b24096191"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Chandigarh = bookingdetails.get("Chandigarh");
        int Chandigarh1=Integer.parseInt(Chandigarh);
        query1.put("serviceCityID",new ObjectId("57725862e61f902b24096191"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Chandigarh1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Hyderabad in current version
    public static void doorStepHyderabad() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("5657235b7dd9cd5d0c006cdf"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Hyderabad = bookingdetails.get("Hyderabad");
        int Hyderabad1=Integer.parseInt(Hyderabad);
        query1.put("serviceCityID",new ObjectId("5657235b7dd9cd5d0c006cdf"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Hyderabad1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Chennai in current version
    public static void doorStepChennai() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("58760f57ae36000b38c8dfdb"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Chennai = bookingdetails.get("Chennai");
        int Chennai1=Integer.parseInt(Chennai);
        query1.put("serviceCityID",new ObjectId("58760f57ae36000b38c8dfdb"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Chennai1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Bangalore in current version
    public static void doorStepBangalore() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("568e2bafe604ffb655acb74c"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Bangalore = bookingdetails.get("Bangalore");
        int Bangalore1=Integer.parseInt(Bangalore);
        query1.put("serviceCityID",new ObjectId("568e2bafe604ffb655acb74c"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Bangalore1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Mumbai in current version
    public static void doorStepMumbai() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("57066610c7cdb98d13ed382a"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Mumbai = bookingdetails.get("Mumbai");
        int Mumbai1=Integer.parseInt(Mumbai);
        query1.put("serviceCityID",new ObjectId("57066610c7cdb98d13ed382a"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Mumbai1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Pune in current version
    public static void doorStepPune() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("58d51d1415ae23c461c85adb"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Pune = bookingdetails.get("Pune");
        int Pune1=Integer.parseInt(Pune);
        query1.put("serviceCityID",new ObjectId("58d51d1415ae23c461c85adb"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Pune1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Coimbatore in current version
    public static void doorStepCoimbatore() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("59c178945a8641619e3ef17b"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Coimbatore = bookingdetails.get("Coimbatore");
        int Coimbatore1=Integer.parseInt(Coimbatore);
        query1.put("serviceCityID",new ObjectId("59c178945a8641619e3ef17b"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Coimbatore1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Vizag in current version
    public static void doorStepVizag() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("58e393e52267bd96537a2e9f"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Vizag = bookingdetails.get("Vizag");
        int Vizag1=Integer.parseInt(Vizag);
        query1.put("serviceCityID",new ObjectId("58e393e52267bd96537a2e9f"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Vizag1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

    //Verify door step for Mysore in current version
    public static void doorStepMysore() throws FileNotFoundException {
        HashMap<String, String> bookingdetails;
        bookingdetails = Commons.getHashmapfromtxt("rateCard.txt");
        MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1=db.getCollection("ratecards");
        BasicDBObject query = new BasicDBObject();
        String rateCardVersion=bookingdetails.get("rateCardVersion");
        int rateCardVersion1=Integer.parseInt(rateCardVersion);
        query.put("serviceCityID",new ObjectId("59c16f1d0dfb39078a1baa81"));
        query.put("rateCardVersion",rateCardVersion1);
        query.put("pricingType",new BasicDBObject("$ne", 5));
        System.out.println(query);
        DBCursor cursor = coll1.find(query);
        int total_count = coll1.find(query).count();
        System.out.println(total_count);

        DBCollection coll2=db.getCollection("ratecards");
        BasicDBObject query1 = new BasicDBObject();
        String Mysore = bookingdetails.get("Mysore");
        int Mysore1=Integer.parseInt(Mysore);
        query1.put("serviceCityID",new ObjectId("59c16f1d0dfb39078a1baa81"));
        query1.put("rateCardVersion",rateCardVersion1);
        query1.put("doorStepDeliveryCharges",Mysore1);
        query1.put("pricingType",new BasicDBObject("$ne", 5));
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }



}
