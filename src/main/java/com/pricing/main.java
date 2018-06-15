package com.pricing;

import com.mongodb.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.types.ObjectId;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class main {
    public static String dbresponse = "";
    public static String serviceCityID = "";
    public static int rateCardVersion = 47;
    public static String dbhourlyTariffWeekday = "";
    public static String dbhourlyTariffWeekend = "";
    public static String dbhourlyTariffPeak = "";
    public static String dbsKMC = "";
    public static String dbsExtraKmChargeFuel = "";
    public static String dbsSecurityDeposit = "";
    public static String dbsDoorstepDelivery = "";
    // public static ObjectId objId = null;
    static HashMap<String, String> hMap=null;
    static HashMap<String, String> hMap1=null;
    static HashMap<String,String> hMap2=null;
    static List<String> rateCardArray = new ArrayList<String>();
    static HashMap<String,List<String>> map= new HashMap<String, List<String>>();;
    public static void main(String args[]) {
        try {
            readXLSXFile();

        } catch (Exception e) {
            System.out.println("Exception !!!" + e.toString() + e);
        }
    }

    public static String readXLSXFile() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream("./src/main/java/com/testdata/test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();
        //String sModel="i10";
        //String sCity="chandigarh";
        //String col1="5wd";
        //String data1="";
        int ColNum = 0;
        int iExtraKmNum = 0;
        int iSDNum = 0;
        int iDDNum = 0;
        String finalVal = "";
        int pricingtype = 0;
        String pricing = "";
        carModelRead();
        serviceCityRead();

        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            try {
                System.out.println("readxls starts"+row.getCell(1)+"    "+row.getCell(0));
                System.out.println("readxls starts1"+hMap1.get(row.getCell(1))+"    "+hMap.get(row.getCell(0)));
                List<String> values = databaseRead(hMap1.get(row.getCell(1)), hMap.get(row.getCell(0)), rateCardVersion);
            }catch(Exception e){
                e.printStackTrace();
            }

            //while (cells.hasNext()) {
            for (int i = 0; i <= row.getLastCellNum() - 1; i++) {
                cell = (XSSFCell) cells.next();

                try {
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        String sKMC = "";
                        String sExtraKmChargeFuel = "";
                        String sSecurityDeposit = "";
                        String sDoorstepDelivery = "";
                        /***********  kmc  ***********/
                        if (cell.getSheet().getRow(0).getCell(i)
                                .getRichStringCellValue().toString().equalsIgnoreCase("kmc")) {
                            ColNum = cell.getColumnIndex();
                        }
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            sKMC = String.valueOf(row.getCell(ColNum).getStringCellValue());
                        } else if ((cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)) {
                            sKMC = String.valueOf(row.getCell(ColNum).getNumericCellValue());
                        } else {

                        }
                        /***********  sExtraKmChargeFuel  ***********/
                        if (cell.getSheet().getRow(0).getCell(i)
                                .getRichStringCellValue().toString().equalsIgnoreCase("extraKmChargeFuel")) {
                            iExtraKmNum = cell.getColumnIndex();
                        }
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            sExtraKmChargeFuel = String.valueOf(row.getCell(iExtraKmNum).getStringCellValue());
                        } else if ((cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)) {
                            sExtraKmChargeFuel = String.valueOf(row.getCell(iExtraKmNum).getNumericCellValue());
                        } else {

                        }
                        /***********  sSecurityDeposit  ***********/
                        if (cell.getSheet().getRow(0).getCell(i)
                                .getRichStringCellValue().toString().equalsIgnoreCase("securityDeposit")) {
                            iSDNum = cell.getColumnIndex();
                        }
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            sSecurityDeposit = String.valueOf(row.getCell(iSDNum).getStringCellValue());
                        } else if ((cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)) {
                            sSecurityDeposit = String.valueOf(row.getCell(iSDNum).getNumericCellValue());
                        } else {

                        }
                        /***********  sDoorstepDelivery  ***********/
                        if (cell.getSheet().getRow(0).getCell(i)
                                .getRichStringCellValue().toString().equalsIgnoreCase("doorstepDelivery")) {
                            iDDNum = cell.getColumnIndex();
                        }
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            sDoorstepDelivery = String.valueOf(row.getCell(iDDNum).getStringCellValue());
                        } else if ((cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)) {
                            sDoorstepDelivery = String.valueOf(row.getCell(iDDNum).getNumericCellValue());
                        } else {

                        }

                        /***************/

                        if (cell.getSheet().getRow(0).getCell(i)
                                .getRichStringCellValue().toString().contains("km")) {
                            System.out.println("111111:::" + row.getCell(0) + "  " + row.getCell(1) + "  " + cell.getSheet().getRow(0).getCell(i)
                                    .getRichStringCellValue().toString() + "  " + row.getCell(i).getNumericCellValue() + "  " + "sExtraKmChargeFuel  " + sExtraKmChargeFuel + "  sSecurityDeposit "
                                    + sSecurityDeposit + "   sDoorstepDelivery  " + sDoorstepDelivery
                            );
                            finalVal = "1;"+row.getCell(0) + ";" + row.getCell(1) + ";" + cell.getSheet().getRow(0).getCell(i)
                                    .getRichStringCellValue().toString() + ";" + row.getCell(i).getNumericCellValue() + ";" + sExtraKmChargeFuel + ";"
                                    + sSecurityDeposit + ";" + sDoorstepDelivery;

                        } else {
                            System.out.println("222222:::" + row.getCell(0) + "  " + row.getCell(1) + "  " + cell.getSheet().getRow(0).getCell(i)
                                    .getRichStringCellValue().toString() + "  " + row.getCell(i).getNumericCellValue() + "  " + "sKMC" + sKMC + "  sSecurityDeposit "
                                    + sSecurityDeposit + "   sDoorstepDelivery  " + sDoorstepDelivery
                            );
                            finalVal = "2;"+row.getCell(0) + ";" + row.getCell(1) + ";" + cell.getSheet().getRow(0).getCell(i)
                                    .getRichStringCellValue().toString() + ";" + row.getCell(i).getNumericCellValue() + ";" + sKMC + ";"
                                    + sSecurityDeposit + ";" + sDoorstepDelivery;
                        }
                        System.out.println("ddd"+finalVal);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String s = cell.getSheet().getRow(0).getCell(i)
                        .getRichStringCellValue().toString();

                if ("5wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 2;
                } else if ("5we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 2;
                } else if ("5pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 2;
                } else if ("10wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 3;
                } else if ("10we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 3;
                } else if ("10pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 3;
                } else if ("15wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 4;
                } else if ("15we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 4;
                } else if ("15pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 4;
                } else if ("uwd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 1;
                } else if ("uwe".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 1;
                } else if ("upk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 1;
                } else if ("rtw".equals(s)) {
                    pricing = "minimumBaseFare";
                    pricingtype = 5;
                } else if ("5km fuel wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 6;
                } else if ("5km fuel we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 6;
                } else if ("5km fuel pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 6;
                } else if ("10km fuel wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 7;
                } else if ("10km fuel we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 7;
                } else if ("10km fuel pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 7;
                } else if ("15km fuel wd".equals(s)) {
                    pricing = "hourlyTariffWeekday";
                    pricingtype = 8;
                } else if ("15km fuel we".equals(s)) {
                    pricing = "hourlyTariffWeekend";
                    pricingtype = 8;
                } else if ("15km fuel pk".equals(s)) {
                    pricing = "hourlyTariffPeak";
                    pricingtype = 8;
                }
                System.out.println("finalVal     "+finalVal);
                //System.out.println("ssval[]"+ssval);
                try {
                    String  val[] = finalVal.split(";");
                    // System.out.println("1111111     " +  val[0] + "  " +  hMap1.get( val[2]) + "  " +  hMap.get( val[1]));


                    if("1".equalsIgnoreCase(val[0])){
                        System.out.println(Double.parseDouble( map.get(pricing).get(6))+"::"+Double.parseDouble(val[4])
                                +"  "+Double.parseDouble(val[6])+"::"+Double.parseDouble(map.get(pricing).get(8))
                                +"  "+Double.parseDouble(val[7])+"::"+Double.parseDouble(map.get(pricing).get(7)));
                        if(Double.parseDouble(map.get(pricing).get(6))==Double.parseDouble(val[4].toString()) && Double.parseDouble(val[6])==Double.parseDouble(map.get(pricing).get(8))
                                && Double.parseDouble(val[7])==Double.parseDouble(map.get(pricing).get(7))){
                            System.out.println("1 matcheddd");
                        }
                        else{
                            System.out.println("2 not matcheddd");
                        }
                    }else{
                        System.out.println("ff"+map.get(pricing));
                        System.out.println(Double.parseDouble( map.get(pricing).get(6))+"::"+Double.parseDouble(val[5])
                                +"  "+Double.parseDouble(val[6])+"::"+Double.parseDouble(map.get(pricing).get(8))
                                +"  "+Double.parseDouble(val[7])+"::"+Double.parseDouble(map.get(pricing).get(7)));

                        if(Double.parseDouble(map.get(pricing).get(6))==Double.parseDouble(val[5].toString()) && Double.parseDouble(val[6])==Double.parseDouble(map.get(pricing).get(8))
                                && Double.parseDouble(val[7])==Double.parseDouble(map.get(pricing).get(7))){
                            System.out.println("3 matcheddd");
                        }else {
                            System.out.println("4 not matcheddd");
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        }


        return finalVal;
    }


        /*public static String carModelRead(String model, String model1) {
            MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
            DB db = mongoClient.getDB("drive_car");
            System.out.println("Connect to database successfully");
            DBCollection coll = db.getCollection("carmodels");
            DBObject myDoc = coll.findOne();
            System.out.println(coll.getCount());
            BasicDBObject query = new BasicDBObject(model, model1);
            DBCursor cursor = coll.find(query);
            try {
                while (cursor.hasNext()) {
                    dbresponse = dbresponse.concat(cursor.next().toString());
                    carModelID = cursor.curr().get("_id").toString();
                    System.out.println(carModelID + model1);
                }
            } finally {

                cursor.close();
                return carModelID;
            }

        }*/

    public static void carModelRead() {
        MongoClient mongoClient = new MongoClient("35.154.205.66", 27017);
        DB db = mongoClient.getDB("drive_car");
        System.out.println("Connect to database successfully");
        DBCollection coll = db.getCollection("carmodels");
        DBObject myDoc = coll.findOne();
        System.out.println(coll.getCount());
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", 1);
        fields.put("model","1");
        //BasicDBObject fields = new BasicDBObject("_id", "1");
        //BasicDBObject fields = new BasicDBObject("model","1");
        DBCursor cursor = coll.find(query,fields);
        hMap=new HashMap<String, String>();
        String carModelID = "";
        String sCarModel="";
        try {
            while (cursor.hasNext()) {
                dbresponse = dbresponse.concat(cursor.next().toString());
                System.out.println(dbresponse+"PAWELPAWEL");
                carModelID = cursor.curr().get("_id").toString();
                sCarModel = cursor.curr().get("model").toString();
                hMap.put(sCarModel,carModelID);
            }
            System.out.println("lklskalkslaks"+hMap.get("Amaze"));
        } finally {

            cursor.close();
            //return carModelID;
        }

    }


        /*public static String serviceCityRead(String name, String name1) {
            MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
            DB db = mongoClient.getDB("drive_car");
            System.out.println("Connect to database successfully");
            DBCollection coll = db.getCollection("servicecities");
            DBObject myDoc = coll.findOne();
            System.out.println(coll.getCount());
            BasicDBObject query = new BasicDBObject(name, name1);
            DBCursor cursor = coll.find(query);
            try {
                while (cursor.hasNext()) {
                    dbresponse = dbresponse.concat(cursor.next().toString());
                    serviceCityID = cursor.curr().get("_id").toString();
                    System.out.println(serviceCityID + name1);
                }
            } finally {
                cursor.close();
                return serviceCityID;
            }

        }*/

    public static void  serviceCityRead() {
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
        hMap1=new HashMap<String, String>();
        String serviceCityID = "";
        String serviceCity="";
        try {
            while (cursor.hasNext()) {
                dbresponse = dbresponse.concat(cursor.next().toString());
                serviceCityID = cursor.curr().get("_id").toString();
                serviceCity = cursor.curr().get("name").toString();
                hMap1.put(serviceCity,serviceCityID);
            }
            System.out.println(hMap1.get("ncr"));

        } finally {
            cursor.close();
            //return serviceCityID;
        }

    }

        /*public static void databaseRead(String serviceCityID, String carModelID, String pricingType) {
            MongoClient mongoClient = new MongoClient("13.126.78.55", 27017);
            DB db = mongoClient.getDB("drive_car");
            // query to get total count
            DBCollection coll1 = db.getCollection("ratecards");
            BasicDBObject query = new BasicDBObject();
            //query.put("serviceCityID", serviceCityID);
            query.put("serviceCityID", serviceCityID);
            query.put("carModelID", carModelID);
            //String rateCardVersion=bookingdetails.get("rateCardVersion");
            //int rateCardVersion1=Integer.parseInt(rateCardVersion);
            query.put("pricingType", Integer.parseInt(pricingType));
            query.put("rateCardVersion", rateCardVersion);

            System.out.println("query:" + query);
            DBCursor cursor = coll1.find(query);
            try {
                while (cursor.hasNext()) {
                    dbresponse = dbresponse.concat(cursor.next().toString());
                    dbhourlyTariffWeekday = cursor.curr().get("hourlyTariffWeekday").toString();
                    dbhourlyTariffWeekend = cursor.curr().get("hourlyTariffWeekend").toString();
                    dbhourlyTariffPeak = cursor.curr().get("hourlyTariffPeak").toString();
                    dbsDoorstepDelivery = cursor.curr().get("doorStepDeliveryCharges").toString();
                    dbsSecurityDeposit = cursor.curr().get("securityDeposit").toString();
                    dbsKMC = cursor.curr().get("kilometerTariffWeekday").toString();
                    dbsExtraKmChargeFuel = cursor.curr().get("kilometerTariffWeekday").toString();
                    System.out.println("dbhourlyTariffWeekday:" + dbhourlyTariffWeekday + "  dbhourlyTariffWeekend:" + dbhourlyTariffWeekend
                            + "  dbhourlyTariffPeak:" + dbhourlyTariffPeak + " dbsDoorstepDelivery:" + dbsDoorstepDelivery + " dbsSecurityDeposit:" + dbsSecurityDeposit
                            + " dbsKMC:" + dbsKMC + " dbsExtraKmChargeFuel:" + dbsExtraKmChargeFuel);
                }
            } finally {
                cursor.close();
            }

        }*/

    public static List<String>  databaseRead(String serviceCityID, String carModelID,  int rateCardVersion) {
        MongoClient mongoClient = new MongoClient("35.154.205.66", 27017);
        DB db = mongoClient.getDB("drive_car");
        // query to get total count
        DBCollection coll1 = db.getCollection("ratecards");
        System.out.println("databaseRead:carModelID"+carModelID);
        BasicDBObject query = new BasicDBObject();
        //query.append("carModelID",new ObjectId(carModelID));
        //query.append("serviceCityID", new ObjectId(serviceCityID));
        dbresponse="";
            /*String val1="ObjectId(\""+carModelID+"\")";
            String val2="ObjectId(\""+serviceCityID+"\")";*/
        //System.out.println(val1);
        query.put("carModelID",new ObjectId(carModelID));
        query.put("serviceCityID", new ObjectId(serviceCityID));
        query.put("rateCardVersion",rateCardVersion);
        //query.put("pricingType",pricingType);
        BasicDBObject fields = new BasicDBObject();
        fields.put("carModelID",1);
        fields.put("serviceCityID",1);
        fields.put("rateCardVersion",1);
        fields.put("hourlyTariffWeekday",1);
        fields.put("hourlyTariffWeekend",1);
        fields.put("hourlyTariffPeak",1);
        fields.put("kilometerTariffWeekday",1);
        fields.put("doorStepDeliveryCharges",1);
        fields.put("securityDeposit",1);
        fields.put("pricingType",1);
        //System.out.println("query:" + query);
        System.out.println(query+"Pawel+++Pawel");
        DBCursor cursor = coll1.find(query,fields);
        System.out.println(cursor+"Pawel Pawel");
        hMap2=new HashMap<String, String>();
        String sCarModelID = "";
        String sServiceCityID="";
        String sRateCardVersion = "";
        String hourlyTariffWeekday="";
        String hourlyTariffWeekend = "";
        String hourlyTariffPeak="";
        String kilometerTariffWeekday = "";
        String doorStepDeliveryCharges="";
        String securityDeposit = "";
        String sPricingType="";
        try {
            while (cursor.hasNext()) {
                dbresponse = dbresponse.concat(cursor.next().toString());

                sCarModelID = cursor.curr().get("carModelID").toString();
                sServiceCityID = cursor.curr().get("serviceCityID").toString();
                sRateCardVersion = cursor.curr().get("rateCardVersion").toString();
                hourlyTariffWeekday = cursor.curr().get("hourlyTariffWeekday").toString();
                hourlyTariffWeekend = cursor.curr().get("hourlyTariffWeekend").toString();
                hourlyTariffPeak = cursor.curr().get("hourlyTariffPeak").toString();
                kilometerTariffWeekday = cursor.curr().get("kilometerTariffWeekday").toString();
                doorStepDeliveryCharges = cursor.curr().get("doorStepDeliveryCharges").toString();
                securityDeposit = cursor.curr().get("securityDeposit").toString();
                sPricingType = cursor.curr().get("pricingType").toString();

            }

            rateCardArray.add(sCarModelID);
            rateCardArray.add(sServiceCityID);
            rateCardArray.add(sRateCardVersion);
            rateCardArray.add(hourlyTariffWeekday);
            rateCardArray.add(hourlyTariffWeekend);
            rateCardArray.add(hourlyTariffPeak);
            rateCardArray.add(kilometerTariffWeekday);
            rateCardArray.add(doorStepDeliveryCharges);
            rateCardArray.add(securityDeposit);
            // rateCardArray.add(sPricingType);
            map.put(sPricingType,rateCardArray);
            System.out.println(dbresponse+"Pawellllllawel");
            System.out.println("rateCard:::"+rateCardArray);
        } finally {

            cursor.close();
            return rateCardArray;
        }

    }
}






