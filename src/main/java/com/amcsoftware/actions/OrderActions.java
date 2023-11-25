package com.amcsoftware.actions;

import com.amcsoftware.data.LoginPageObject;
import com.amcsoftware.data.OrderPageObject;
import com.amcsoftware.message.MessagesAndLabels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.amcsoftware.setup.Engine.driver;
import static com.amcsoftware.setup.Engine.engine;

public class OrderActions {
    private ActionHolder actions;
    public MessagesAndLabels messagesAndLabels = new MessagesAndLabels();

    public OrderActions(ActionHolder actions) {
        this.actions = actions;
    }

    public void addToCart(String item1, String item2) {
        List<WebElement> cards = engine().findElements(OrderPageObject.cards);
        for(WebElement card : cards) {
            String productName = card.findElement(OrderPageObject.cardProductName).getText();
            if(productName.equalsIgnoreCase(item1) || productName.equalsIgnoreCase(item2)) {
                WebElement button = card.findElement(OrderPageObject.cardCartButton);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
                wait.until(ExpectedConditions.elementToBeClickable(button));
                button.click();
            }
        }
    }

    public void verifySelectedItemsAreInCart(List<String> cartItems) throws Exception {
        try {
            actions.softAssert.assertTrue(!cartItems.isEmpty(), messagesAndLabels.emptyList());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(OrderPageObject.dashboardCart));
            WebElement cart = engine().findElement(OrderPageObject.dashboardCart);
            actions.softAssert.assertTrue(cart.findElement(OrderPageObject.dashboardCartLabel).getText().contains(String.valueOf(cartItems.size())), messagesAndLabels.incorrectCartLabel());
            cart.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            List<WebElement> actualCart = engine().findElements(OrderPageObject.cartItems);
            int actualTotal = 0;
            for(WebElement ac : actualCart) {
                WebElement h3 = ac.findElement(OrderPageObject.cartHead);
                actions.softAssert.assertTrue(cartItems.contains(h3.getText()));
                String stockStatus = engine().findElement(OrderPageObject.stockStatus).getText();
                actions.softAssert.assertEquals(stockStatus,messagesAndLabels.inStock());
                String price = ac.findElement(OrderPageObject.mrp).getText();
                String[] priceAmount = price.split(" ");
                actualTotal += Integer.parseInt(priceAmount[priceAmount.length-1].trim());
            }
            String[] extractTotal =  engine().findElement(OrderPageObject.totalAmount).getText().split("\\$");
            int total = Integer.parseInt(extractTotal[extractTotal.length-1].trim());
            actions.softAssert.assertEquals(total, actualTotal, messagesAndLabels.incorrectTotal());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void clickCheckout() throws Exception {
        try {
            engine().findElement(OrderPageObject.checkoutButton).click();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void placeOrder(String cvv, String nameOnCard, String email, String country) throws Exception {
        try {
            engine().findElement(OrderPageObject.cvvInput).sendKeys(cvv);
            engine().findElement(OrderPageObject.nameInput).sendKeys(nameOnCard);
            WebElement actualEmail = engine().findElement(OrderPageObject.orderEmailInput);
            actions.softAssert.assertEquals(actualEmail.getAttribute("value"), email);
            engine().findElement(OrderPageObject.countryInput).sendKeys(country);
            engine().findElement(OrderPageObject.placeOrderButton).click();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void signOut() throws Exception {
        try {
            engine().findElement(LoginPageObject.signOutButton).click();
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void verifyNoItemsInCart() throws Exception {
        try {
            engine().findElement(OrderPageObject.dashboardCart).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(OrderPageObject.noItemHeader));
            WebElement str = engine().findElement(OrderPageObject.noItemHeader);
            actions.softAssert.assertTrue(str.getText().equals(messagesAndLabels.noItemsInCart()));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

