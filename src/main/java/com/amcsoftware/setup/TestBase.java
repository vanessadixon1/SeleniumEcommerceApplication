package com.amcsoftware.setup;

import com.amcsoftware.actions.ActionHolder;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase extends TestNgBase {
    public ActionHolder actions;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        actions = new ActionHolder();
        actions.Initialize();
    }

    @BeforeMethod
    public void onExecutionStart(Method method) {
        test = extentReports.createTest(method.getName());
        extentTest.set(test);
        try {
            this.logDividerSetup(method);
            defaultOnExecutionStart();
            startEngine();
            methodSetup();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void methodSetup() {
        try {
            engine().get(props.getProperty("appUrl"));
            engine().manage().window().maximize();
            engine().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

