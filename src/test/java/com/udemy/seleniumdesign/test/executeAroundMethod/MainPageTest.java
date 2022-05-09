package com.udemy.seleniumdesign.test.executeAroundMethod;

import com.udemy.seleniumdesign.executeAroundMethod.MainPage;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {

        this.mainPage.goTo();

        this.mainPage.onFrameA((fA) -> {
            fA.setFirstName("Mainak");
            fA.setLastName("Sen");
        });

        this.mainPage.onFrameB((fB) -> fB.setTextArea("I am going to fill in here"));

        this.mainPage.onFrameA((fA) -> fA.setTextArea("I am Mainak and I am going to fill in here"));

        this.mainPage.onFrameC((fC) -> fC.setLastName("Sengupta"));
    }

}
