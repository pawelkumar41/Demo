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
import java.util.Arrays;

public class MongoConnection {

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
            try {
                while(cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            } finally {
                cursor.close();
            }

        }
    }
}
