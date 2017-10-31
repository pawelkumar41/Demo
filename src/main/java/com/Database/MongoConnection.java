package com.Database;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.*;
import org.json.JSONObject.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MongoConnection {
    public static String dbresponse="";
    public static String DBResponse="";

    public static void dtdb (String bookingIDForCustomer, String realbookingIDForCustomer){

        {
            MongoClient mongoClient = new MongoClient("13.126.150.162", 27017);
            DB db = mongoClient.getDB("drive_car");
            System.out.println("Connect to database successfully");
            DBCollection coll=db.getCollection("bookingdetails");
            DBObject myDoc=coll.findOne();
            System.out.println(coll.getCount());
            BasicDBObject query=new BasicDBObject(bookingIDForCustomer,realbookingIDForCustomer);
            DBCursor cursor = coll.find(query);
            String dbresponse="";
            try {
                while(cursor.hasNext()) {
                    dbresponse=dbresponse.concat(cursor.next().toString());
                    System.out.println(dbresponse);
                    Assert.assertTrue(dbresponse.contains("bookingIDForCustomer"));
                    //JSONObject user = new JSONObject(dbresponse.concat(cursor.next().toString()));
                }
            } finally {
                cursor.close();
            }

        }
    }
}
