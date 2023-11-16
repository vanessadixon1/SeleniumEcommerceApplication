package com.amcsoftware.smoke.login;

import com.amcsoftware.parameters.jsonDataItem.LoginDataItem;
import com.amcsoftware.setup.TestBase;
import org.testng.annotations.Test;

public class LoginSmokeTest extends TestBase {

    @Test(dataProvider = "getLoginData")
    public void verifyBlinkFormBanner(LoginDataItem testData) throws Exception {
        actions.getLoginActions().validateBlinkingLoginHeader(testData.getHeader());
        actions.softAssert.assertAll();
    }

    @Test(dataProvider = "getLoginData")
    public void verifyLoginFormInputLabelsAndErrorMessages(LoginDataItem testData) throws Exception {
        actions.getLoginActions().clickLoginButton();
        actions.getLoginActions().validateLoginFormLabels();
        actions.getLoginActions().validateInputErrorMessages(testData.getIncorrectUsername(), testData.getUsername(), testData.getPassword());
        actions.softAssert.assertAll();
    }

    @Test(dataProvider = "getLoginData")
    public void verifyLoginFormButtonWorks(LoginDataItem testData) throws Exception {
        actions.getLoginActions().enterLoginInfo(testData.getUsername(), testData.getPassword());
        actions.getLoginActions().clickLoginButton();
        actions.getLoginActions().validateHomepageIsDisplayed();
        actions.softAssert.assertAll();
    }

    @Test
    public void verifyForgotPasswordLinkWorks() throws Exception {
        actions.getLoginActions().validateForgotLink();
        actions.softAssert.assertAll();
    }

    @Test
    public void verifyRegisterLinkWorks() throws Exception {
        actions.getLoginActions().validateRegisterLink();
        actions.softAssert.assertAll();
    }

}
