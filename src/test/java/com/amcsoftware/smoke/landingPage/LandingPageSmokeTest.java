package com.amcsoftware.smoke.landingPage;

import com.amcsoftware.setup.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LandingPageSmokeTest extends TestBase {

    @Test
    public void verifyHeaderIconsExist() throws Exception {
        actions.getHomepageActions().validateHeaderIcons();
        actions.softAssert.assertAll();
    }

    @Test
    public void verifyLandingPageFooter() throws Exception {
        actions.getHomepageActions().validateFooterHeader();
        actions.getHomepageActions().validateFooterCardTitles();
        actions.softAssert.assertAll();
    }
}
