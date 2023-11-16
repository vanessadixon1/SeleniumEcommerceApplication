package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;

public class LoginPageObject extends TestNgBase {
    public static By signOutButton = By.cssSelector("li button i[class*='sign-out']");
    public static By homepageHeader = By.cssSelector("div[class*='left'] h3");
    public static By forgotLink = By.cssSelector("a[class='forgot-password-link']");
    public static By blinkHeader = By.className("blink_me");
    public static By loginButton = By.id("login");
    public static By newPassword = By.cssSelector("div h3[class='card-title text-center']");
}
