package tests;

import base.BaseTest;
import constants.ExcelColumns;
import dataproviders.LoginDataProvider;
import enums.ExpectedResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = LoginDataProvider.class
    )
    public void verifyLogin(Map<String, String> data) {

        String username = data.get(ExcelColumns.USERNAME);

        String password = data.get(ExcelColumns.PASSWORD);

        ExpectedResult expectedResult = ExpectedResult.valueOf(data.get(ExcelColumns.EXPECTED).toUpperCase());

        pages.getLoginPage().login(username, password);

        switch (expectedResult) {

            case PASS ->
                    Assert.assertTrue(pages.getDashboardPage().isDashboardDisplayed());

            case FAIL ->
                    Assert.assertTrue(pages.getLoginPage().isErrorMessageDisplayed());

        }

    }

}