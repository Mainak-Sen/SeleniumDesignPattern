package com.udemy.seleniumdesign.template;

import com.udemy.seleniumdesign.template.pages.AmazonProductDescriptionPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping extends ShoppingTemplate {

    private final WebDriver driver;
    private String product;
    private WebDriverWait wait;

    //pageComponents
    private AmazonSearchPage amazonSearchPage;
    private AmazonSearchResultsPage amazonSearchResultsPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;


    public AmazonShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonSearchResultsPage = PageFactory.initElements(driver, AmazonSearchResultsPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
    }


    @Override
    public void launchSite() {
        this.amazonSearchPage.launchSite();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.searchForProduct(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonSearchResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductDescriptionPage.buy();
    }
}
