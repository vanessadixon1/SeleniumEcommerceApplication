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
    public static String emailInputPlaceholder = "email@example.com";
    public static String phoneInputPlaceHolder = "enter your number";
    public static String passwordInputPlaceholder = "Passsword";
    public static String confirmPasswordInputPlaceholder = "Confirm Passsword";
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

    private String firstNameErrorMessage = "*First Name must be 3 or more character long";
    private String lastNameErrorMessage = "last Name must be 3 to 20 characters long!";
    private String emailErrorMessage = "*Enter Valid Email";
    private String onlyNumbersErrorMessage = "*only numbers is allowed";
    private String phoneErrorMessage = "*Phone Number must be 10 digit";
    private String confirmPasswordErrorMessage = "Password and Confirm Password must match with each other.";
    private String passwordLengthErrorMessage = "Password must be 8 Character Long!";

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
    public String firstNameErrorMessage() {
        return firstNameErrorMessage;
    }

    @Override
    public String lastNameErrorMessage() {
        return lastNameErrorMessage;
    }

    @Override
    public String passwordLengthErrorMessage() {
        return passwordLengthErrorMessage;
    }

    @Override
    public String phoneNumberErrorMessage() {
        return phoneErrorMessage;
    }

    @Override
    public String onlyNumbersErrorMessage() {
        return onlyNumbersErrorMessage;
    }

    @Override
    public String confirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage;
    }

    @Override
    public String emailErrorMessage() {
        return emailErrorMessage;
    }

    @Override
    public String checkboxErrorMessage() {
        return null;
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
