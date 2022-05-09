package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    //buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoButton;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningButton;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successButton;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerButton;

    //notification alerts
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal Alert
    @FindBy(xpath = "//h4[text()='Dissmissal Alert']/parent::div//div[contains(@class,'alert-success')]")
    private WebElement dismissalSuccessAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']/parent::div//div[contains(@class,'alert-warning')]")
    private WebElement dismissalWarningAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']/parent::div//div[contains(@class,'alert-info')]")
    private WebElement dismissalInfoAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']/parent::div//div[contains(@class,'alert-danger')]")
    private WebElement dismissalDangerAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {

        return Arrays.asList(
                //notificationButtons
                new NotificationValidator(infoButton, infoAlert),
                new NotificationValidator(warningButton, warningAlert),
                new NotificationValidator(dangerButton, dangerAlert),
                new NotificationValidator(successButton, successAlert),

                //dismissalAlerts
                new DismissalAlertValidator(dismissalSuccessAlert),
                new DismissalAlertValidator(dismissalDangerAlert),
                new DismissalAlertValidator(dismissalInfoAlert),
                new DismissalAlertValidator(dismissalWarningAlert)
        );
    }
}
