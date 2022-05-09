package com.udemy.seleniumdesign.executeAroundMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameC {

    @FindBy(name = "fn")
    private WebElement firstName;

    @FindBy(name = "ln")
    private WebElement lastName;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(id = "area")
    private WebElement textArea;

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setTextArea(String textArea) {
        this.textArea.sendKeys(textArea);
    }
}
