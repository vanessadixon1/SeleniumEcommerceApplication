package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;

public class HomePageObject extends TestNgBase {
    public static By footerMessage = By.cssSelector("div[class='section1'] div h1");
    public static By footerCardTitles = By.cssSelector("div[class='section1'] section div[class*='card'] p");
    public static By headerIcons = By.cssSelector("div[class='header'] div[class='top-tab'] span a i");
}
