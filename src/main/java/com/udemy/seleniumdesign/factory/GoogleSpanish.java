package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSpanish extends GoogleEnglish {

    @FindBy(linkText = "español")
    private WebElement language;

    public GoogleSpanish(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.es");
        this.language.click();
    }
}
