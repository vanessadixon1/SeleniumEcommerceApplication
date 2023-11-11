package com.amcsoftware.regression;

import com.amcsoftware.setup.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class claTest extends TestBase {

    @Test()
    public void run() throws InterruptedException {

        actions.getSharedActions().se("how i'm living");
//        Thread.sleep(3000);
    }

    @Test()
    public void yip() throws InterruptedException, SQLException {
        Connection conn = DriverManager.getConnection("");
        Statement  s = conn.createStatement();
        s.executeQuery("");
        Assert.assertEquals(s.toString(), "show");


        Thread.sleep(3000);
    }
}
