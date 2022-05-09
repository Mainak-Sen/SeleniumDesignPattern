package com.udemy.seleniumdesign.srp.main;

import com.udemy.seleniumdesign.srp.common.SearchSuggestions;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestions searchSuggestions;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestions = PageFactory.initElements(driver, SearchSuggestions.class);
    }

    public SearchSuggestions getSearchSuggestions() {
        return searchSuggestions;
    }

    public void goTo() {
        this.driver.get("http://www.google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }
}
