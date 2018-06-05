package com.util;

import com.Database.MongoConnection;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class VerifyRateCard {

    @Test
    public static void ddwNCR() throws FileNotFoundException {
        MongoConnection.doorStepNCR();
    }

    @Test
    public static void ddwJaipur() throws FileNotFoundException {
        MongoConnection.doorStepJaipur();
    }

    @Test
    public static void ddwChandigarh() throws FileNotFoundException {
        MongoConnection.doorStepChandigarh();
    }

    @Test
    public static void ddwHyderabad() throws FileNotFoundException {
        MongoConnection.doorStepHyderabad();
    }

    @Test
    public static void ddwChennai() throws FileNotFoundException {
        MongoConnection.doorStepChennai();
    }

    @Test
    public static void ddwBangalore() throws FileNotFoundException {
        MongoConnection.doorStepBangalore();
    }

    @Test
    public static void ddwMumbai() throws FileNotFoundException {
        MongoConnection.doorStepMumbai();
    }

    @Test
    public static void ddwPune() throws FileNotFoundException {
        MongoConnection.doorStepPune();
    }

    @Test
    public static void ddwCoimbatore() throws FileNotFoundException {
        MongoConnection.doorStepCoimbatore();
    }

    @Test
    public static void ddwVizag() throws FileNotFoundException {
        MongoConnection.doorStepVizag();
    }

    @Test
    public static void ddwMysore() throws FileNotFoundException {
        MongoConnection.doorStepMysore();
    }

}
