package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;

public class RegisterPageObject extends TestNgBase {
    public static By registerButton = By.cssSelector("[class='btn1']");
    public static By formTitle = By.cssSelector("[class='login-title']");
    public static By phoneInput = By.cssSelector("[id='userMobile']");

    public static By registerFormButton = By.cssSelector("input[id='login']");
    public static By registerFormRadioButtons = By.cssSelector("input[type = 'radio']");
    public static By registerFormDropdown = By.tagName("select");

}
