package manager;

import driver.DriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class PageObjectManager {

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    public LoginPage getLoginPage() {

        if(loginPage == null) {

            loginPage = new LoginPage(DriverManager.getDriver());

        }

        return loginPage;

    }

    public DashboardPage getDashboardPage() {

        if(dashboardPage == null) {

            dashboardPage = new DashboardPage(DriverManager.getDriver());

        }

        return dashboardPage;

    }

}