package com.amcsoftware.data;

import org.openqa.selenium.By;

public class OrderPageObject {
    public static By cards = By.className("card");
    public static By cardCartButton = By.cssSelector("button:nth-of-type(2)");
    public static By cardProductName = By.cssSelector("div[class='card-body'] h5");
    public static By dashboardCart = By.cssSelector("ul li button[routerlink*='cart']");
    public static By dashboardCartLabel = By.tagName("label");
    public static By cartItems = By.cssSelector("div[class='cart'] ul li");
    public static By cartHead = By.cssSelector("h3");
    public static By stockStatus = By.cssSelector("p[class='stockStatus']");
    public static By mrp = By.cssSelector("p:nth-of-type(2)");
    public static By totalAmount = By.cssSelector("ul li[class='totalRow']:nth-of-type(2) span[class='value']");
    public static By checkoutButton = By.cssSelector("div[class*='subtotal'] button");
    public static By cvvInput = By.cssSelector("div[class='field small']:nth-of-type(2) input");
    public static By nameInput = By.cssSelector("div[class='row']:nth-of-type(3) input");
    public static By countryInput = By.cssSelector("input[placeholder*='Country']");
    public static By placeOrderButton = By.cssSelector("div[class='actions'] a");
    public static By orderEmailInput = By.cssSelector("div[class*='user__name'] input[type='text']");
    public static By noItemHeader = By.cssSelector("div:nth-of-type(2) h1");
}
