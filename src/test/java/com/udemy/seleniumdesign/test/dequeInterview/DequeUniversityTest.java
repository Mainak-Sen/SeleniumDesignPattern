package com.udemy.seleniumdesign.test.dequeInterview;

import com.udemy.seleniumdesign.dequePages.DequeMainPage;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DequeUniversityTest extends BaseTest {

    private DequeMainPage dequeMainPage;

    @BeforeTest
    public void setUpPagesAndOpenDequeHomePage() {
        this.dequeMainPage = new DequeMainPage(driver);
        this.driver.get("https://dequeuniversity.com/demo/mars");
    }

    @Test
    public void testIfNavigationBarIsDisplayed() {
        Assert.assertTrue(this.dequeMainPage.isNavigationBarDisplayed());
    }

    @Test
    public void testNumberOfRadioButtonsUnderLetTheAdventureBegin() {
        Assert.assertEquals(this.dequeMainPage.getAdventureRadioButtons().size(), 5);
    }

    @Test
    public void testIfClickingOnAddTravellerAddsAnotherSelectToThePage() {

        this.dequeMainPage.clickAddTravellerButton();

        Assert.assertTrue(this.dequeMainPage.isSecondTravellerDisplayed());
    }

    @Test
    public void testIfVideoTextChangesIfNextButtonIsClicked() {

        String firstText = this.dequeMainPage.getVideoText();
        Assert.assertEquals(firstText, "Life was possible on Mars");

        this.dequeMainPage.clickVideoNext();
        Assert.assertEquals(this.dequeMainPage.getVideoText(), "Why Mars died");
    }


}
