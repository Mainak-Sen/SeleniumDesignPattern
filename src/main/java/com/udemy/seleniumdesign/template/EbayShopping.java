package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Collectors;

public class EbayShopping extends ShoppingTemplate {

    private final WebDriver driver;
    private String product;
    private WebDriverWait wait;

    @FindBy(id = "gh-ac")
    private WebElement searchTextBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBy(css = ".s-item__title span")
    private WebElement firstItemInSearchResult;

    @FindBy(css = ".mainPrice")
    private WebElement itemPrice;

    public EbayShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.product = product;
        PageFactory.initElements(driver, this);
    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com");
    }

    @Override
    public void searchForProduct() {
        this.wait.until((d) -> this.searchTextBox.isDisplayed());
        this.searchTextBox.sendKeys(this.product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.firstItemInSearchResult.isDisplayed());
        this.firstItemInSearchResult.click();
    }

    @Override
    public void buy() {
        //switch to new tab where the selected product got opened
        this.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        this.driver.switchTo().window(this.driver.getWindowHandles().stream().collect(Collectors.toList()).get(1));
        this.wait.until((d) -> this.itemPrice.isDisplayed());
        System.out.println(this.itemPrice.getText());
    }
}
