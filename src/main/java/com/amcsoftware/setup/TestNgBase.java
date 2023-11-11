package com.amcsoftware.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestNgBase extends Engine {
    public static String loggingFilePath;
    public ExtentSparkReporter report;
    public ExtentTest test;
    ExtentReports extentReports;
    public ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();//means if you are running concurrently each thread will have it's own Thread
    final static String  PROPERTIESFILE = "testparameters.properties";

    public void defaultOnExecutionStart() {
        this.setLogPath();
        this.loadProperties();
    }

    public void loadProperties() {
        try {
            Path pathname = Paths.get("src/main/resources/"+PROPERTIESFILE);
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir" ) + File.separator + pathname);
            props = new Properties();
            props.load(fs);
        } catch (Exception e) {
            LogUtility.logException("loadProperties", "There was a problem loading properties file", e, Enums.LoggingLevel.ERROR, true);
        }
    }

    public void setLogPath() {
        loggingFilePath = System.getProperty("user.dir") + File.separator + "logs" + File.separator;
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method method) throws Throwable {
        this.driverTearDown(result, method);
    }

    public void driverTearDown(ITestResult result, Method method) {
        onExecutionFinish();
        if(result.isSuccess()) {
            testPass(result);
        }else {
            testFail(result);
        }
        destroyDriver(method);
    }

    public void onExecutionFinish() {
        extentReports.flush();
        System.out.println("Finished at " + (new SimpleDateFormat("yy_MM-dd HH:mm:ss")).format(new Date()));
    }

    public void testPass(ITestResult result ) {
        extentTest.get().log(Status.PASS, "Test PASSED!");
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + "()--Passed");
        LogUtility.logInfo(methodName, "passed");
    }

    public void testFail(ITestResult result)  {
        try {
            extentTest.get().log(Status.FAIL, result.getThrowable());
            String path = getScreenshot(result);
            extentTest.get().addScreenCaptureFromPath(path);
            String methodName = result.getMethod().getMethodName();
            System.out.println(methodName + "()--Failed");
            LogUtility.logInfo("Test Failed: ", methodName);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getScreenshot(ITestResult result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(result.getName());
        File file = new File("src/screenshot/" + result.getName() + ".png");
        FileUtils.copyFile(src, file);
        return file.getAbsolutePath();
    }

    @BeforeTest
    public void getReport() {
        report = new ExtentSparkReporter("src/report");
        report.config().setReportName("Ecommerce Web Automation");
        report.config().setDocumentTitle("Test Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(report);
        extentReports.setSystemInfo("QETester", "Vanessa");
    }
}
