package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test

    public void verifyValidLogin() {

        pages.getLoginPage().login(config.getProperty("username"), config.getProperty("password"));

        Assert.assertTrue(pages.getDashboardPage().isDashboardDisplayed(), "Dashboard was not displayed after login.");

    }

}