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
            MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
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
            }

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
        DBCursor cursor1 = coll2.find(query1);
        System.out.println(query1);
        //System.out.println(coll1.find(query).count());
        int delivery_chk = coll2.find(query1).count();
        System.out.println(delivery_chk);
        Assert.assertTrue(total_count==delivery_chk);
    }

}
