package com.udemy.seleniumdesign.test.factory;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    //extending base test because we want to use the driver instance created from there
    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {
/*        gives us the implementation of GooglePage as per the language and driver passed
        we have made the GoogleEnglish,GoogleFrench and GoogleArabic classes default or package private
        so that it cannot be accessed and created object in this different package,only Google factory holds that responsibility
        of returning us with the implementation of GooglePage as per the language we want
        we don't care how GoogleFactory creates it*/
        this.googlePage = GoogleFactory.getGooglePage(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        System.out.println("Results count is : " + this.googlePage.getResultsCount());

    }

    //data provider
    @DataProvider
    public Object[][] getData() {
        return new Object[][]
                {
                        {"ENG", "Selenium"},
                        {"FR", "SDET"},
                        {"SA", "Docker"},
                        {"ES", "Design Pattern"}
                };
    }

}
