package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtility {

    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver, int timeout) {

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public boolean waitForInvisibility(By locator) {

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public boolean waitForText(By locator, String text) {

        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

    }

}