
package com.revv.Database;

import com.mongodb.*;
import com.sun.deploy.net.URLEncoder;
import com.sun.deploy.util.URLUtil;
import org.testng.*;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;


/**
 * Created by pawelkumar on 07/04/16.
 */
public class Connection {
    public static void main(String args[]) {


        try {
                //String dbURL = "mongodb://manish:B@tm@n04@52.36.18.53:27017";
            String dbURL = "mongodb://" + "manish%3AB%40tm%40n04%4052.36.18.53%3A27017%2Fdrive_car";
            MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURL));
            //MongoClient mongoClient = new MongoClient(dbURL);


            List<String> databases = mongoClient.getDatabaseNames();
            System.out.println(databases);

            for (String dbName : databases) {
                System.out.println("- Database: " + dbName);

                DB db = mongoClient.getDB(dbName);

                Set<String> collections = db.getCollectionNames();
                for (String colName : collections) {
                    System.out.println("\t + Collection: " + colName);
                }
            }

            mongoClient.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}