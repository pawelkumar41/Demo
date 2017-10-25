/*

package com.Database;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;

public class MongoConnection {

    public static void String ( String args[] ) {

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "13.126.150.162" , 27017 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "drive_car" );
            System.out.println("Connect to database successfully");
            DBCollection table= db.getCollection("bookingdetails");
            BasicDBObject searchQuery = new BasicDBObject();
            String bookingID="11117885";
            searchQuery.put("bookingIDForCustomer",bookingID);
            DBCursor cursor = table.find(searchQuery);

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("pricingType", 4));
            BasicDBObject searchQuery = new BasicDBObject().append("hosting", "hostB");
            bookingdetails.update(searchQuery, newDocument);









            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
*/
