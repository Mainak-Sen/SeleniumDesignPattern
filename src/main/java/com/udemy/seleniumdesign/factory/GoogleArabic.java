package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

    @FindBy(linkText = "العربية")
    private WebElement language;

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardButton;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((driver) -> this.keyboardButton.isDisplayed());
        this.keyboardButton.click();
        this.wait.until((driver) -> this.keyboard.isDisplayed());
        super.search(keyword); //user super keyword to access parent class methods
    }
}
