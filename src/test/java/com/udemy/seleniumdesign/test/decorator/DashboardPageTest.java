package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decoratorPattern.DashboardPage;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage() {
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role) {
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Decorators.adminPageValidate,
                Decorators.guestPageValidate,
                Decorators.superUserPageValidate
        };
    }
}
