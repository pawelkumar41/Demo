package com.Database;
import com.mongodb.*;
import org.testng.Assert;

public class MongoConnection {
    public static String dbresponse="";
    public static String carInfoID="";
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
}
