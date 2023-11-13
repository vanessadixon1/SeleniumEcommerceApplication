package com.amcsoftware.actions;

import com.amcsoftware.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SharedActions extends TestBase {
    public ActionHolder actions;

    public SharedActions(ActionHolder actions) {
        this.actions = actions;
    }

    private static List<String> getFormLabels(By labels) {
        List<String> formLabels = new ArrayList<>();
        for(WebElement label : engine().findElements(labels)) {
            formLabels.add(label.getText());
        }
        return formLabels;
    }

    public void validateLabels(List<String> formLabels, By labels) {
        try {
            List<String> registerFormLabels = SharedActions.getFormLabels(labels);
            for(String label : formLabels) {
                boolean isTrue = registerFormLabels.contains(label);
                actions.softAssert.assertTrue(isTrue, label + " is not a label");
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("The data was not found " + e);
        }
    }

    public void addAndRemoveInputValues(List<String> inputValues, List<String> placeholderValues,  By input ) throws Exception {
        try {
            List<WebElement> inputs = engine().findElements(input);
            actions.softAssert.assertTrue(!inputValues.isEmpty(), "The inputValues list is empty");
            actions.softAssert.assertTrue(!inputs.isEmpty(), "The input list is empty");

            for (int i = 0; i < inputs.size(); i++) {
                inputs.get(i).sendKeys(inputValues.get(i));
                actions.softAssert.assertTrue(!inputs.get(i).getAttribute("value").isEmpty(), "The " + inputs.get(i).getAttribute("formcontrolname") + " is Empty and should have data");
                inputs.get(i).clear();
                actions.softAssert.assertTrue(inputs.get(i).getAttribute("value").isEmpty(), "The " + inputs.get(i).getAttribute("formcontrolname") + " is not Empty and should be empty");
                validatePlaceHolder(inputs.get(i), placeholderValues.get(i));
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void validatePlaceHolder(WebElement placeholder, String value) throws Exception {
        try {
            actions.softAssert.assertTrue(placeholder.getAttribute("placeholder").equals(value), "The placeholder " + value + " doesn't exist");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
