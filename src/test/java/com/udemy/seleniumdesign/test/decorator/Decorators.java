package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decoratorPattern.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //check whether individual component is present/absent

    private static final Consumer<DashboardPage> adminComponentIsPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentIsNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> guestComponentIsPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentIsNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> suComponentIsPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> suComponentIsNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());

    //roleSelection
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> superUserSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    //Page validations
    public static final Consumer<DashboardPage> guestPageValidate = guestSelection.andThen(guestComponentIsPresent).andThen(adminComponentIsNotPresent).andThen(suComponentIsNotPresent);
    public static final Consumer<DashboardPage> adminPageValidate = adminSelection.andThen(guestComponentIsPresent).andThen(adminComponentIsPresent).andThen(suComponentIsPresent);
    public static final Consumer<DashboardPage> superUserPageValidate = superUserSelection.andThen(guestComponentIsPresent).andThen(adminComponentIsNotPresent).andThen(suComponentIsPresent);
}
