package com.amcsoftware.data;

import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.By;

public class SharedPageObject extends TestNgBase {
    public static By formLabels = By.cssSelector("div[class*='form-group'] label");
    public static By labelRequiredMessages = By.cssSelector("div[class*='invalid-feedback']");
}
