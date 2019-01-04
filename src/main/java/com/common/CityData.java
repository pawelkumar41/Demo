package com.common;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by pawelkumar on 19/04/16.
 */

public class CityData {
    public static HashMap<String, String> getHashmapfromtxt1(String filename) throws FileNotFoundException {
        HashMap<String, String> hash = new HashMap<String, String>();
        BufferedReader br = new BufferedReader(new FileReader("./src/main/java/CitiesData/" + filename));

        try {

            String line = br.readLine();
            String[] dataArray = line.substring(0, line.length() - 1).split("\\|");


            for (int i = 0; i < dataArray.length; i++) {
                String record = dataArray[i];
                if (record != null) {
                    System.out.println(record);
                    String[] pair = record.split("\\=");
                    hash.put(pair[0], pair[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static Date getDateFromString(String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = df.parse(dateString);
        return date;
    }

}
