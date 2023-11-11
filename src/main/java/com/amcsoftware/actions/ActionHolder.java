package com.amcsoftware.actions;

import org.testng.asserts.SoftAssert;

public class ActionHolder {
    private SharedActions sharedActions;
    private RegistrationActions registrationActions;
    public SoftAssert softAssert;

    public ActionHolder() {
        sharedActions = null;
        registrationActions = null;
        softAssert = null;
    }

    public void Initialize() {
        softAssert = new SoftAssert();
        sharedActions = new SharedActions(this);
        registrationActions = new RegistrationActions(this);
    }

    public SharedActions getSharedActions() {
        return sharedActions;
    }

    public RegistrationActions getRegistrationActions() {
        return registrationActions;
    }
}
