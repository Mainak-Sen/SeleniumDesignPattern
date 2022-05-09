package com.udemy.seleniumdesign.decoratorPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {

    private final WebDriver driver;

    @FindBy(css = "div.admin")
    private List<WebElement> adminComponents;

    @FindBy(id = "div.guest")
    private List<WebElement> guestComponents;

    @FindBy(id = "div.superuser")
    private List<WebElement> superUserComponents;

    @FindBy(id = "role")
    private WebElement role;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role) {
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getAdminComponents() {
        return this.adminComponents;
    }

    public List<WebElement> getGuestComponents() {
        return this.guestComponents;
    }

    public List<WebElement> getSuperUserComponents() {
        return this.superUserComponents;
    }
}
