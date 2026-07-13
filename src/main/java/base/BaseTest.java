package base;

import driver.DriverManager;
import factory.DriverFactory;
import manager.PageObjectManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ConfigReader;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected ConfigReader config;

    protected PageObjectManager pages;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional String browser) {

        initializeConfiguration();

        initializeDriver(browser);

        launchApplication();

        initializePages();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {

            logger.info("Closing browser.");

            driver.quit();

            DriverManager.unload();

        }

    }

    private void initializeConfiguration() {

        logger.info("Loading framework configuration.");

        config = ConfigReader.getInstance();

    }

    private void initializeDriver(String browser) {

        if (browser == null || browser.isBlank()) {

            browser = config.getProperty("browser");

        }

        logger.info("Launching {} browser.", browser);

        DriverManager.setDriver(DriverFactory.getDriver(browser));

        DriverManager.getDriver().manage().window().maximize();

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " | Browser: " + browser);

    }

    private void launchApplication() {

        logger.info(
                "Opening application: {}", config.getProperty("url"));

        DriverManager.getDriver().get(config.getProperty("url"));

    }

    private void initializePages() {

        logger.info("Initializing Page Object Manager.");

        pages = new PageObjectManager();

    }

}