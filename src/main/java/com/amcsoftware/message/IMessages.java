package com.amcsoftware.message;

public interface IMessages {

    public String firstNameRequiredMessage();

    public String emailRequiredMessage();

    public String phoneNumberRequiredMessage();

    public String passwordRequiredMessage();

    public String passwordConfirmRequiredMessage();

    public String firstNameErrorMessage();

    public String lastNameErrorMessage();

    public String passwordLengthErrorMessage();

    public String phoneNumberErrorMessage();

    public String onlyNumbersErrorMessage();

    public String confirmPasswordErrorMessage();

    public String emailErrorMessage();

    public String checkboxErrorMessage();

    public String bannerMessage();

    public String pageFooterTitle();

    public String expectNoError();

    public String headerNotMatching();

    public String headerNotDisplayed();

    public String signOutBtnNotDisplayed();

    public String forgotLink();

    public String enterNewPassword();

    public String registerLinkText();

    public String registerEndpoint();

    public String footerHeader();
}
