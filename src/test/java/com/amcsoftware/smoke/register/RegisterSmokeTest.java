package com.amcsoftware.smoke.register;

import com.amcsoftware.message.MessagesAndLabels;
import com.amcsoftware.parameters.jsonDataItem.RegisterDataItem;
import com.amcsoftware.setup.TestBase;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterSmokeTest extends TestBase {

    @Test
    public void verifyPageTitle()  {
        actions.getRegistrationActions().verifyPageTitle();
        actions.softAssert.assertAll();
    }

    @Test(dataProvider ="getRegisterData")
    public void verifyRegisterFormOpens(RegisterDataItem testData) throws Exception {
        actions.getRegistrationActions().clickRegisterButtonAndVerifyFormName(testData.getFormTitle());
        actions.softAssert.assertAll();
    }

    @Test
    public void verifyRegisterFormLabelsAndRequiredField() throws InterruptedException {
       actions.getRegistrationActions().clickRegisterButton();
        actions.getRegistrationActions().validateRegisterFormLabels();
        actions.getRegistrationActions().validateRequiredField();
        actions.softAssert.assertAll();
    }

    public void verifyRegisteredFormRequiredFields() {

    }





}
