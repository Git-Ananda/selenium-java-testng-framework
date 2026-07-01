package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {

        if (browser == null || browser.isBlank()) {

            throw new RuntimeException("Browser is missing in config.properties");

        }

        return switch (browser.toLowerCase()) {

            case "chrome" -> new ChromeDriver();

            case "edge" -> new EdgeDriver();

            case "firefox" -> new FirefoxDriver();

            default -> throw new RuntimeException("Invalid browser: " + browser);

        };

    }

}