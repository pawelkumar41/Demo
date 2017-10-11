/*
package com.revv.Database;

*/
/**
 * Created by pawelkumar on 02/05/16.
 *//*

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

    public static void main( String args[] ) {

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "52.36.18.53" , 27017 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "drive_car" );
            System.out.println("Connect to database successfully");
            DBCollection table= db.getCollection("bookingdetails");
            BasicDBObject searchQuery = new BasicDBObject();
            String bookingID="11112136";
            searchQuery.put("bookingIDForCustomer",bookingID);
            DBCursor cursor = table.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}*/
