package pages;

import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class BasePage {

    protected WebDriver driver;

    protected WaitUtility waitUtility;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        waitUtility = new WaitUtility(driver);

    }

}