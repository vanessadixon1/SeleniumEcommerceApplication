package com.amcsoftware.actions;

import com.amcsoftware.data.RegisterPageObject;
import com.amcsoftware.message.MessagesAndLabels;
import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RegistrationActions extends TestNgBase {
    MessagesAndLabels messagesAndLabels = new MessagesAndLabels();

    private ActionHolder actions;

    public RegistrationActions(ActionHolder actions) {
        this.actions = actions;
    }

    public void verifyPageTitle() {
         String title = engine().getTitle();
         actions.softAssert.assertTrue(title.equals(MessagesAndLabels.appTitle),"Page Title doesn't equal " + MessagesAndLabels.appTitle);
    }

    public void clickRegisterButtonAndVerifyFormName(String title) throws Exception {
        try {
            engine().findElement(RegisterPageObject.registerButton).click();
            WebDriverWait wait = new WebDriverWait(engine(), Duration.ofSeconds(5L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPageObject.phoneInput));
            String formTitle = engine().findElement(RegisterPageObject.formTitle).getText();
            actions.softAssert.assertEquals(formTitle, title , "Form Title is not " + "");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateRegisterFormLabels() {
        List<String> fomLabel = new ArrayList<>(List.of(MessagesAndLabels.firstName,MessagesAndLabels.lastName, MessagesAndLabels.email,
                MessagesAndLabels.phoneNumber, MessagesAndLabels.occupation, MessagesAndLabels.gender, MessagesAndLabels.male,
                MessagesAndLabels.female, MessagesAndLabels.password, MessagesAndLabels.confirmPassword));

        actions.getSharedActions().validateLabels(fomLabel, RegisterPageObject.registerFormLabels);
    }

    public void validateRequiredField() {
        engine().findElement(RegisterPageObject.registerFormButton).click();
        WebDriverWait wait = new WebDriverWait(engine(), Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPageObject.labelRequiredMessages));
        List<String> requiredMessages = new ArrayList<>(List.of(messagesAndLabels.firstNameRequiredMessage(),
                messagesAndLabels.emailRequiredMessage(), messagesAndLabels.phoneNumberRequiredMessage(),
                messagesAndLabels.passwordRequiredMessage(), messagesAndLabels.passwordConfirmRequiredMessage()));

        actions.getSharedActions().validateLabels(requiredMessages, RegisterPageObject.labelRequiredMessages);
    }

    public void clickRegisterButton() {
        try {
            engine().findElement(RegisterPageObject.registerButton).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The element was not found");
        }
    }

    public void validateRadioButton() throws Exception {
        try {
            List<WebElement> radioButtons = engine().findElements(RegisterPageObject.registerFormRadioButtons);
            actions.softAssert.assertTrue(!radioButtons.isEmpty(), "There radioButton list is empty");
            for(WebElement radioButton : radioButtons) {
                actions.softAssert.assertTrue(!radioButton.isSelected(), "The radio button is selected");
                radioButton.click();
                actions.softAssert.assertTrue(radioButton.isSelected(), "The radio button is not selected");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateDropdownValues(List<String> occupations) {
        WebElement selectDropdown = engine().findElement(RegisterPageObject.registerFormDropdown);
        selectDropdown.click();
        Select dropdown = new Select(selectDropdown);
        List<WebElement> options = dropdown.getOptions();
        for(int i = 0; i < options.size(); i++) {
            actions.softAssert.assertEquals(options.get(i).getText().toLowerCase(), occupations.get(i).toLowerCase(), "The occupation doesn't match");
        }
    }

    public void validateAddingAndRemovingData(String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassword) throws Exception {
        List<String> inputValues = new ArrayList<>(List.of(firstName, lastName, email, phoneNumber, password, confirmPassword));
        List<String> placeholders = new ArrayList<>(List.of(MessagesAndLabels.firstName, MessagesAndLabels.lastName, MessagesAndLabels.emailInputPlaceholder, MessagesAndLabels.phoneInputPlaceHolder,
                MessagesAndLabels.passwordInputPlaceholder, MessagesAndLabels.confirmPasswordInputPlaceholder ));
        actions.getSharedActions().addAndRemoveInputValues(inputValues, placeholders, RegisterPageObject.registerFormInputs);
    }

}
