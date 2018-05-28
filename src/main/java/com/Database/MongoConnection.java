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
            DBCollection coll1=db.getCollection("maintblock");
            DBCollection coll2=db.getCollection("hubnumbers");
            DBObject myDoc=coll.findOne();
            System.out.println(coll.getCount());
            BasicDBObject query=new BasicDBObject(bookingIDForCustomer,realbookingIDForCustomer);
            BasicDBObject query1 = new BasicDBObject();
            BasicDBObject query2 = new BasicDBObject();
            query1.append("active", 1);
            query2.append("mobileNumber","9642235588");
            DBCursor cursor = coll.find(query);
            coll1.remove(query1);
            coll2.remove(query2);
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
