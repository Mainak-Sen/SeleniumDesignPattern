package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.SearchSuggestions;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestions searchSuggestions;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver) {

        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestions = PageFactory.initElements(driver, SearchSuggestions.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);

    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

    public SearchSuggestions getSearchSuggestions() {
        return searchSuggestions;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
