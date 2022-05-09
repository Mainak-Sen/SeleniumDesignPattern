package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchResultsPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "span.a-size-medium")
    private WebElement firstItemInSearchResult;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        this.wait.until((d) -> this.firstItemInSearchResult.isDisplayed());
        this.firstItemInSearchResult.click();
    }
}
