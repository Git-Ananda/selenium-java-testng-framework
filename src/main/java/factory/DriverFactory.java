package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) {

        if (browser == null || browser.isBlank()) {

            throw new RuntimeException("Browser is missing in config.properties");

        }

        return switch (browser.toLowerCase()) {

            case "chrome" -> {

                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("--headless=new");

                chromeOptions.addArguments("--disable-gpu");

                chromeOptions.addArguments("--window-size=1920,1080");

                chromeOptions.addArguments("--remote-allow-origins=*");

                chromeOptions.addArguments("--no-sandbox");

                yield new ChromeDriver(chromeOptions);

            }

            case "edge" -> {

                EdgeOptions edgeOptions = new EdgeOptions();

                edgeOptions.addArguments("--headless");

                edgeOptions.addArguments("--disable-gpu");

                edgeOptions.addArguments("--disable-dev-shm-usage");

                edgeOptions.addArguments("--window-size=1920,1080");

                edgeOptions.addArguments("--remote-debugging-port=9222");

                edgeOptions.addArguments("--no-sandbox");

                yield new EdgeDriver(edgeOptions);

            }

            case "firefox" -> new FirefoxDriver();

            default -> throw new RuntimeException("Invalid browser: " + browser);

        };

    }

}