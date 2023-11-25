package com.amcsoftware.message;

 interface IMessages {

  String firstNameRequiredMessage();

  String emailRequiredMessage();

  String phoneNumberRequiredMessage();
    
  String passwordRequiredMessage();

  String passwordConfirmRequiredMessage();

  String firstNameErrorMessage();

  String lastNameErrorMessage();

  String passwordLengthErrorMessage();

  String phoneNumberErrorMessage();

  String onlyNumbersErrorMessage();

  String confirmPasswordErrorMessage();

  String emailErrorMessage();

  String checkboxErrorMessage();

  String bannerMessage();

  String pageFooterTitle();

  String expectNoError();

  String headerNotMatching();

  String headerNotDisplayed();

  String signOutBtnNotDisplayed();

  String forgotLink();

  String enterNewPassword();

  String registerLinkText();

  String registerEndpoint();

  String footerHeader();

  String inStock();

  String incorrectTotal();
    
  String emptyList();

  String incorrectCartLabel();

  String noItemsInCart();
}
