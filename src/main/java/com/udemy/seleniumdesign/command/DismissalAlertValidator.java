package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {


    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }


    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed();//expected true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2;
        try {
            result2 = this.dismissalAlert.isDisplayed();//expected false
        } catch (Exception e) {//expected to catch NoSuchElementException
            result2 = false;
        }
        return result1 && (!result2);
    }
}
