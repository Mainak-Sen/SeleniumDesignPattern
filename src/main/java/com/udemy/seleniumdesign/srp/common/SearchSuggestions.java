package com.udemy.seleniumdesign.srp.common;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestions extends AbstractComponent {

    @FindBy(css = "li.sbct")
    private List<WebElement> searchSuggestions;

    public SearchSuggestions(final WebDriver driver) {
        super(driver);
    }

    public void clickSuggestionByIndex(int index) {
        this.searchSuggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((webDriver) -> this.searchSuggestions.size() >= 5);
    }
}
