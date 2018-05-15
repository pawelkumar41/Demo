package com.Database;
import com.mongodb.*;
import org.testng.Assert;

public class MongoConnection {
    public static String dbresponse="";
    public static String carInfoID="";

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
}
