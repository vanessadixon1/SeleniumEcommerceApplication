package com.amcsoftware.regression.order;

import com.amcsoftware.parameters.jsonDataItem.OrderDataItem;
import com.amcsoftware.setup.TestBase;
import org.testng.annotations.Test;

import java.util.List;

public class Order extends TestBase {
    @Test(dataProvider = "getOrderData")
    public void loginAndPurchaseItems(OrderDataItem testData) throws Exception {
        List<String> items = List.of(testData.getItem1(),testData.getItem3());
        actions.getLoginActions().login(testData.getUsername(), testData.getPassword());
        actions.getOrderActions().addToCart(testData.getItem1(), testData.getItem3());
        actions.getOrderActions().verifySelectedItemsAreInCart(items);
        actions.getOrderActions().clickCheckout();
        actions.getOrderActions().placeOrder(testData.getCvv(), testData.getName(),
                testData.getUsername(), testData.getCountry());
        actions.softAssert.assertAll();
    }

    @Test(dataProvider = "getOrderData")
    public void verifyItemsLeftInCartAreRemoved(OrderDataItem testData) throws Exception {
        List<String> items = List.of(testData.getItem1(),testData.getItem3());
        actions.getLoginActions().login(testData.getUsername(), testData.getPassword());
        actions.getOrderActions().addToCart(testData.getItem1(), testData.getItem3());
        actions.getOrderActions().verifySelectedItemsAreInCart(items);
        actions.getOrderActions().signOut();
        actions.getLoginActions().login(testData.getUsername(), testData.getPassword());
        actions.getOrderActions().verifyNoItemsInCart();
        actions.softAssert.assertAll();
    }

}
