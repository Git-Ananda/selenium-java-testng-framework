package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDashboardTitle() {

        System.out.println("DashboardTest running on thread: " + Thread.currentThread().getId());

        pages.getLoginPage().login(config.getProperty("username"), config.getProperty("password"));

        Assert.assertTrue(pages.getDashboardPage().isDashboardDisplayed());
    }
}