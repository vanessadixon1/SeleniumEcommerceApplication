package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BPageObject extends TestNgBase {
    public By input = By.id("APjFqb");

    public WebElement getHouse() {

        return engine().findElement(input);
    }
}
