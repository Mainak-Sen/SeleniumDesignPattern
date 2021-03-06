package com.udemy.seleniumdesign.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        //simulating human behaviour to type character by character of the keyword
        for (char c : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((webDriver) -> this.searchBox.isDisplayed());
    }
}
