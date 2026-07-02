package pages;

import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.WaitUtility;

public abstract class BasePage {

    protected final WebDriver driver;

    protected final WaitUtility waitUtility;

    protected BasePage(WebDriver driver) {

        this.driver = driver;

        this.waitUtility = new WaitUtility(
                driver,
                ConfigReader.getInstance().getIntProperty("explicitWait")
        );

    }

}