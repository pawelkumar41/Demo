package com.util;

import com.Database.MongoConnection;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class VerifyRateCard {

    @Test
    public static void ddwNCR() throws FileNotFoundException {
        MongoConnection.doorStepNCR();
    }

}
