package com.pricing;

import com.mongodb.*;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DBCrash
{
@Test
    public static void main(){
        for(int i=0;i<=100000;i++){
            serviceCityRead();
            DBCrash.serviceCityRead();
        }
    }
   @Test
    public static void ok(String args[]){
        DBCrash.serviceCityRead();

    }


    @Test
   public static void  serviceCityRead() {
        String dbresponse="";
        MongoClient mongoClient = new MongoClient("35.154.205.66", 27017);
        DB db = mongoClient.getDB("drive_car");
        System.out.println("Connect to database successfully");
        DBCollection coll = db.getCollection("servicecities");
        DBObject myDoc = coll.findOne();
        System.out.println(coll.getCount());
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", 1);
        fields.put("name",1);
        DBCursor cursor = coll.find(query,fields);
        HashMap<String, String> hMap1=new HashMap<String, String>();
        String serviceCityID = "";
        String serviceCity="";
        try {
            while (cursor.hasNext()) {
                dbresponse = dbresponse.concat(cursor.next().toString());
                serviceCityID = cursor.curr().get("_id").toString();
                serviceCity = cursor.curr().get("name").toString();
                hMap1.put(serviceCity,serviceCityID);
            }
            System.out.println(hMap1.get("ncr"))
            ;

        } finally {
            cursor.close();
            //return serviceCityID;
        }

    }

}
