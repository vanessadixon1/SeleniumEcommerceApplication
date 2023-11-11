package com.amcsoftware.message;

public class MessagesAndLabels implements IMessages {

    public static String firstName = "First Name";
    public static String lastName = "Last Name";
    public static String email = "Email";
    public static String occupation = "Occupation";
    public static String password = "Password";
    public static String phoneNumber = "Phone Number";
    public static String confirmPassword = "Confirm Password";
    public static String gender = "Gender";
    public static String register = "Register";
    public static String successfulOrder = "Successful Orders";
    public static String customers = "Customers";
    public static String sellers = "Sellers";
    public static String dailyOrders = "Daily Orders";
    public static String dailyNewCustomers = "Daily New Customer Joining";
    public static String facebook = "facebook";
    public static String instagram = "instagram";
    public static String twitter = "twitter";
    public static String youtube = "youtube";
    public static String appTitle = "Let's Shop";
    public static String male = "Male";
    public static String female = "Female";

    private String firstNameRequired = "*First Name is required";
    private String emailRequired = "*Email is required";
    private String phoneNumberRequired = "*Phone Number is required";
    private String passwordRequired  = "*Password is required";
    private String confirmPasswordRequired = "Confirm Password is required";

    @Override
    public String firstNameRequiredMessage() {
        return firstNameRequired;
    }

    @Override
    public String emailRequiredMessage() {
        return emailRequired;
    }

    @Override
    public String phoneNumberRequiredMessage() {
        return phoneNumberRequired;
    }

    @Override
    public String passwordRequiredMessage() {
        return passwordRequired;
    }

    @Override
    public String passwordConfirmRequiredMessage() {
        return confirmPasswordRequired;
    }

    @Override
    public String bannerMessage() {
        return null;
    }

    @Override
    public String pageFooterTitle() {
        return null;
    }
}
