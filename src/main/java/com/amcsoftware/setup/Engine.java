package com.amcsoftware.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.Method;

import java.util.Properties;

public class Engine extends CustomTestDataProviders {
    public Properties props;
    public static WebDriver driver;

    public void startEngine() {
        try{
            setUpWebDriver(Enums.Browser.valueOf(props.getProperty("browser")));
        } catch (Exception e) {
            LogUtility.logException("startEngine", "There was a configuration issue", e, Enums.LoggingLevel.ERROR, true);
            throw e;
        }
    }

    public static void setUpWebDriver(Enums.Browser browserType)  {
        selectDriverType(browserType);
    }

    private static void selectDriverType(Enums.Browser browser)  {
        setUpLocalWebDriver(browser);
    }

    public void logDividerSetup(Method method) {
        LogUtility.startTestCase(method.getName());
    }

    public static void setUpLocalWebDriver(Enums.Browser browserType) {
        //setup a condition for headless mode
        ChromeOptions co = new ChromeOptions();
//        co.addArguments("headless");
        switch (browserType) {
            case Chrome -> driver = new ChromeDriver(co);
            case Firefox -> driver = new FirefoxDriver();
            case Safari -> driver = new SafariDriver();
            case Edge -> driver = new EdgeDriver();
            default -> throw new IllegalArgumentException(browserType + " not currently supported");
        }
    }

    public static WebDriver engine() {
        return driver;
    }

    public static void destroyDriver(Method method) {
        LogUtility.endTestCase(method.getName());
        driver.quit();
    }

}
