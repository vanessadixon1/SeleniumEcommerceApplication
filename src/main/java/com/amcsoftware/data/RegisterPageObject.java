package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;

import java.util.List;

public class RegisterPageObject extends TestNgBase {
    public static By registerButton = By.cssSelector("[class='btn1']");
    public static By formTitle = By.cssSelector("[class='login-title']");
    public static By phoneInput = By.cssSelector("[id='userMobile']");
    public static By registerFormLabels = By.cssSelector("div[class*='form-group'] label");
    public static By labelRequiredMessages = By.cssSelector("div[class='invalid-feedback']");
    public static By registerFormButton = By.cssSelector("input[id='login']");
}