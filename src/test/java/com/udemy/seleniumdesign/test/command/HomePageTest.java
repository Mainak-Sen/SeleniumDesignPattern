package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.ElementValidator;
import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void homePageTest(ElementValidator elementValidator) {
        this.homePage.goTo();
        Assert.assertTrue(elementValidator.validate());


        //the below code is when we do not use data provider
/*        this.homePage.getElementValidators()
                .stream()
                .parallel() //for parallel validation to inprove the performance
                .map(elementValidator -> elementValidator.validate())
                .forEach(result -> Assert.assertTrue(result));*/
    }

    @DataProvider(parallel = true)
    public Object[] getData() {
        return this.homePage.getElementValidators().toArray();
    }
}
