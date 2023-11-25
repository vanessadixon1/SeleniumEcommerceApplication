package com.amcsoftware.actions;

import com.amcsoftware.data.LoginPageObject;
import com.amcsoftware.data.RegisterPageObject;
import com.amcsoftware.data.SharedPageObject;
import com.amcsoftware.message.MessagesAndLabels;
import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginActions extends TestNgBase {
    public MessagesAndLabels messagesAndLabels = new MessagesAndLabels();
    private ActionHolder actions;

    public LoginActions(ActionHolder actions) {
        this.actions = actions;
    }

    public void validateBlinkingLoginHeader(String header) throws Exception {
        try {
            String head = engine().findElement(LoginPageObject.blinkHeader).getText();
            actions.softAssert.assertEquals(head, header, messagesAndLabels.headerNotMatching());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateLoginFormLabels() {
        List<String> fomLabel = new ArrayList<>(List.of(MessagesAndLabels.email,MessagesAndLabels.password));
        actions.getSharedActions().validateLabels(fomLabel, SharedPageObject.formLabels);
    }

    public void validateInputErrorMessages(String invalidEmail, String email, String password) throws Exception {
        WebDriverWait wait = new WebDriverWait(engine(), Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SharedPageObject.labelRequiredMessages));
        List<String> requiredMessages = new ArrayList<>(List.of(messagesAndLabels.emailRequiredMessage(),
                messagesAndLabels.passwordRequiredMessage()));

        actions.getSharedActions().validateLabels(requiredMessages, SharedPageObject.labelRequiredMessages);

        List<WebElement> inputs =  engine().findElements(SharedPageObject.loginAndRegisterFormInputs);
        List<WebElement> errors = engine().findElements(SharedPageObject.labelRequiredMessages);

        for(int i = 0; i < inputs.size(); i++) {
            if(inputs.get(i).getAttribute("type").equalsIgnoreCase(MessagesAndLabels.email)) {
                inputs.get(i).sendKeys(invalidEmail);
                actions.softAssert.assertTrue(inputs.get(i).getAttribute("class").contains(MessagesAndLabels.is_invalid), messagesAndLabels.expectNoError());
                actions.softAssert.assertEquals(errors.get(i).getText(), messagesAndLabels.emailErrorMessage());
                inputs.get(i).clear();
                inputs.get(i).sendKeys(email);
            } else {
                inputs.get(i).sendKeys(password);
            }
            actions.softAssert.assertTrue(!inputs.get(i).getAttribute("class").contains(MessagesAndLabels.is_invalid), messagesAndLabels.expectNoError());
        }
    }

    public void clickLoginButton() throws Exception {
        try {
            engine().findElement(LoginPageObject.loginButton).click();
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void enterLoginInfo(String username, String password) {
        List<WebElement> inputs =  engine().findElements(SharedPageObject.loginAndRegisterFormInputs);
        for(WebElement input : inputs) {
           if(input.getAttribute("type").equalsIgnoreCase(MessagesAndLabels.email)) {
               input.sendKeys(username);
               continue;
           }
           input.sendKeys(password);
        }
    }

    public void validateHomepageIsDisplayed() throws Exception {
        try {
            WebElement header = engine().findElement(LoginPageObject.homepageHeader);
            WebElement signOutBtn = engine().findElement(LoginPageObject.signOutButton);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObject.homepageHeader));
            actions.softAssert.assertTrue(header.isDisplayed(), messagesAndLabels.headerNotDisplayed());
            actions.softAssert.assertTrue(signOutBtn.isDisplayed(), messagesAndLabels.signOutBtnNotDisplayed());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateForgotLink() throws Exception {
        try {
            WebElement forgotLink = engine().findElement(LoginPageObject.forgotLink);
            actions.softAssert.assertEquals(forgotLink.getText(), messagesAndLabels.forgotLink());
            actions.softAssert.assertTrue(forgotLink.isDisplayed());
            forgotLink.click();
            actions.softAssert.assertTrue(engine().getCurrentUrl().contains(MessagesAndLabels.newPasswordEndpoint));
            WebElement actualEnterPasswordText = engine().findElement(LoginPageObject.newPassword);
            actions.softAssert.assertEquals(actualEnterPasswordText.getText(), messagesAndLabels.enterNewPassword());
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateRegisterLink() throws Exception {
        try {
            WebElement registerLink = engine().findElement(LoginPageObject.alreadyHaveAccountLink);
            actions.softAssert.assertTrue(registerLink.isDisplayed());
            actions.softAssert.assertEquals(registerLink.getText(), messagesAndLabels.registerLinkText());
            registerLink.click();
            String currentUrl = engine().getCurrentUrl();
            actions.softAssert.assertTrue(currentUrl.contains(messagesAndLabels.registerEndpoint()));
            WebElement registerHeader = engine().findElement(RegisterPageObject.formTitle);
            actions.softAssert.assertEquals(registerHeader.getText(), MessagesAndLabels.register);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void login(String username, String password) throws Exception {
        List<WebElement> inputs = engine().findElements(SharedPageObject.loginAndRegisterFormInputs);
        for(WebElement input : inputs) {
            if(input.getAttribute("type").equalsIgnoreCase(MessagesAndLabels.email)) {
                input.sendKeys(username);
            }else{
                input.sendKeys(password);
            }
        }
        clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObject.homepageHeader));
    }
}
