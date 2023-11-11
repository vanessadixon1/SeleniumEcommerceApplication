package com.amcsoftware.actions;

import com.amcsoftware.data.RegisterPageObject;
import com.amcsoftware.message.MessagesAndLabels;
import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

//    private String getFormTitle() {
//        return engine().findElement(RegisterPageObject.registerButton).getText();
//    }

    public void validateRegisterFormLabels() {
        List<String> fomLabel = new ArrayList<>(List.of(MessagesAndLabels.firstName,MessagesAndLabels.lastName, MessagesAndLabels.email,
                MessagesAndLabels.phoneNumber, MessagesAndLabels.occupation, MessagesAndLabels.gender, MessagesAndLabels.male,
                MessagesAndLabels.female, MessagesAndLabels.password, MessagesAndLabels.confirmPassword));

        actions.getSharedActions().validateLabels(fomLabel, RegisterPageObject.registerFormLabels);
    }

    public void validateRequiredField() throws InterruptedException {
        engine().findElement(RegisterPageObject.registerFormButton).click();
        Thread.sleep(5000);
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




}
