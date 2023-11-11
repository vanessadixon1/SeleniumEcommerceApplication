package com.amcsoftware.actions;

import com.amcsoftware.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public void select_date(boolean isDeparture, String date) throws Exception {
        try {
            Calendar cal = Calendar.getInstance();

            String targetDate = date;
            int targetedDay;
            int targetMonth;
            int targetYear;
            SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

            Date formattedTargetDate;
            //shift days into the next month if you set it to true false will not shift into next monthth if the day is invalid
            targetDateFormat.setLenient(false);
            //tell java convert my date using this format for targetDateFormat creates a date instance because java doesn't know about string for cal
            formattedTargetDate = targetDateFormat.parse(targetDate);
            //set time to the date instance
            cal.setTime(formattedTargetDate);
            //select the date in the current year and current month
            targetedDay =  cal.get(Calendar.DAY_OF_MONTH);
            targetMonth = cal.get(Calendar.MONTH)+1;
            targetYear = cal.get(Calendar.YEAR);

            String month = select_calender_Month(targetMonth);

            String monthAndYear = null;

            Thread.sleep(4000);
            if(isDeparture) {
                Thread.sleep(5000);
//                pageObject.clickDepartureDateDropdown();
                monthAndYear = month + " " + targetYear;
                selectDate(monthAndYear, Integer.toString(targetedDay));
            }else {
//                pageObject.clickReturnDateDropdown();
                monthAndYear = month+targetYear;
                selectDate(monthAndYear, Integer.toString(targetedDay));
            }
            Thread.sleep(3000);
        } catch (ParseException e) {
            throw new Exception("Invalid date is provided, please check input date");
        }

    }
    
    private void selectDate(String monthAndYear, String day) throws InterruptedException {
        
        System.out.println(monthAndYear);
//        String selectedMonth = pageObject.getCurrentMonth();
        System.out.println("mons" + monthAndYear);

        Thread.sleep(3000);
       
//        while(!selectedMonth.equals(monthAndYear)) {
//            System.out.println(selectedMonth);
//            pageObject.clickNextMonthArrow();
//            selectedMonth = pageObject.getCurrentMonth();
//            Thread.sleep(1000);
//        }
//
//        List<WebElement> elements = pageObject.getCalendarDays();
        
//        for (WebElement element : elements) {
//            if (element.getText().equals(day)) {
//                element.click();
//                break;
//            }
//        }

        Thread.sleep(9000);
    }
    
    private String select_calender_Month(int calendar_month) {
        String month = null;
        switch (calendar_month) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month= "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                System.out.println("invalid");
                break;
        }
        return month;
    }
}
