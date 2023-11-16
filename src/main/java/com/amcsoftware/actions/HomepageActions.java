package com.amcsoftware.actions;

import com.amcsoftware.data.HomePageObject;
import com.amcsoftware.message.MessagesAndLabels;
import com.amcsoftware.setup.TestNgBase;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomepageActions extends TestNgBase {
    public MessagesAndLabels messagesAndLabels = new MessagesAndLabels();
    private ActionHolder actions;

    public HomepageActions(ActionHolder actions) {
        this.actions = actions;
    }

    public void validateFooterCardTitles() throws Exception {
        try {
            List<WebElement> cardTitles = engine().findElements(HomePageObject.footerCardTitles);
            List<String> expectedTitles = new ArrayList<>(List.of(MessagesAndLabels.successfulOrder,
                    MessagesAndLabels.customers, MessagesAndLabels.sellers, MessagesAndLabels.dailyOrders,
                    MessagesAndLabels.dailyNewCustomers));
            actions.softAssert.assertTrue(!cardTitles.isEmpty());
            int count = 0;
            for(WebElement cardTitle : cardTitles) {
                actions.softAssert.assertEquals(cardTitle.getText(), expectedTitles.get(count++));
            }
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateFooterHeader() throws Exception {
        try {
            WebElement footerHeader = engine().findElement(HomePageObject.footerMessage);
            actions.softAssert.assertEquals(footerHeader.getText(), messagesAndLabels.footerHeader());
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void validateHeaderIcons() throws Exception {
        int count = 0;
        try {
            List<WebElement> headerIcons = engine().findElements(HomePageObject.headerIcons);
            List<String> expectedIcons = new ArrayList<>(List.of(MessagesAndLabels.envelope,
                    MessagesAndLabels.facebook, MessagesAndLabels.instagram,
                    MessagesAndLabels.twitter, MessagesAndLabels.youtube));
            for(WebElement headerIcon : headerIcons) {
                actions.softAssert.assertTrue(headerIcon.getAttribute("class").contains(expectedIcons.get(count++)));
            }
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
}
