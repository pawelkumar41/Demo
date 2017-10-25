package com.common;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.text.*;
import java.util.*;

/**
 * Created by pawelkumar on 19/04/16.
 */
public class commons {

    public static HashMap<String, String> getHashmapfromtxt(String filename) throws FileNotFoundException {
        HashMap<String, String> hash = new HashMap<String, String>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/pawelkumar/Documents/revvautomation/src/main/java/com/testdata/" + filename));

        try {

            String line = br.readLine();

            //  while (line != null) {

            // line = br.readLine();
            String[] dataArray = line.substring(0, line.length() - 1).split("\\|");


            for (int i = 0; i < dataArray.length; i++) {
                String record = dataArray[i];
                if (record != null) {
                    System.out.println(record);
                    String[] pair = record.split("\\=");
                    hash.put(pair[0], pair[1].trim());
                }
                //  }
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