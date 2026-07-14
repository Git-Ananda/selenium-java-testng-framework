package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);


    private final By dashboardHeading = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {

        super(driver);

    }

    public boolean isDashboardDisplayed() {

        logger.info("Checking dashboard visibility.");

        return waitUtility.waitForVisibility(dashboardHeading).isDisplayed();

    }

}