package com.amcsoftware.setup;

import com.amcsoftware.parameters.init.LoginInit;
import com.amcsoftware.parameters.init.RegisterInit;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class CustomTestDataProviders {

    @DataProvider(name = "getRegisterData")
//  ITestContext is used to store and share data across the tests
    public final Object[][] getRegisterData(ITestContext context) {
        //send the path of the json
        return Arrays.stream(new RegisterInit().initialize("data/Register.json")
                .stream().map(dataObject -> new Object[] {dataObject})
                .toArray()).toArray(Object[][]::new);
    }

    @DataProvider(name = "getLoginData")
//  ITestContext is used to store and share data across the tests
    public final Object[][] getLoginData(ITestContext context) {
        //send the path of the json
        return Arrays.stream(new LoginInit().initialize("data/Login.json")
                .stream().map(dataObject -> new Object[] {dataObject})
                .toArray()).toArray(Object[][]::new);
    }

}
