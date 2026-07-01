package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;

        ConfigReader config = ConfigReader.getInstance();

        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getIntProperty("explicitWait")));
    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}