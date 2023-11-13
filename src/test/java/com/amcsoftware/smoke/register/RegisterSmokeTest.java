package com.amcsoftware.smoke.register;

import com.amcsoftware.parameters.init.jsonDataItem.RegisterDataItem;
import com.amcsoftware.setup.TestBase;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "getRegisterData")
    public void verifyRegisterFormLabelsAndRequiredMessages(RegisterDataItem testData) throws Exception {
        actions.getRegistrationActions().clickRegisterButton();
        actions.getRegistrationActions().validateRegisterFormLabels();
        actions.getRegistrationActions().validateRequiredField();
        actions.getRegistrationActions().validateAddingAndRemovingData(testData.getFirstName(), testData.getLastName(), testData.getEmail(),
                testData.getPhoneNumber(), testData.getPassword(), testData.getWrongConfirmPassword());
        actions.softAssert.assertAll();
    }

    @Test(dataProvider = "getRegisterData")
    public void verifyRegisteredFormButtonsAndDropdown(RegisterDataItem testData) throws Exception {
        actions.getRegistrationActions().clickRegisterButton();
        actions.getRegistrationActions().validateRadioButton();
        actions.getRegistrationActions().validateDropdownValues(testData.getOptions());
        actions.softAssert.assertAll();
    }


}
