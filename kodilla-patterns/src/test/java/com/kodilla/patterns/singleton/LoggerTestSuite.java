package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void openLogging(){
        Logger.getInstance().log("blablabla");
    }

    @Test
    public void getLastLogTest(){
        //Given
        //When
        String lastlog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("blablabla",lastlog);
    }
}
