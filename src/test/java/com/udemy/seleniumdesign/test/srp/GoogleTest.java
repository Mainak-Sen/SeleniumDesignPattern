package com.udemy.seleniumdesign.test.srp;

import com.udemy.seleniumdesign.srp.main.GoogleMainPage;
import com.udemy.seleniumdesign.srp.result.GoogleResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index) {

        //comment these out when using data provider
/*        String keyword = "Selenium Webdriver";
        int index = 3;*/

        this.googleMainPage.goTo();
        Assert.assertTrue(this.googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestions().isDisplayed());

        googleMainPage.getSearchSuggestions().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestions().isDisplayed());

        googleMainPage.getSearchSuggestions().clickSuggestionByIndex(index);
        googleResultPage.getNavigationBar().goToNews();
        System.out.println(googleResultPage.getResultStat().getStat());
    }

    //parameterize with data provider
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"Selenium", 2}, {"Docker", 3}};
    }
}
