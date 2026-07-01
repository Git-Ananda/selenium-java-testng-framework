package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By dashboardHeading = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {

        super(driver);

    }

    public boolean isDashboardDisplayed() {

        return waitUtility.waitForVisibility(dashboardHeading).isDisplayed();

    }

}