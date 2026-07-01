package base;

import driver.DriverManager;
import factory.DriverFactory;
import manager.PageObjectManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected ConfigReader config;

    protected PageObjectManager pages;

    @BeforeMethod
    public void setup() {

        initializeConfiguration();

        initializeDriver();

        launchApplication();

        initializePages();

    }

    @AfterMethod
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

    private void initializeDriver() {

        logger.info("Launching {} browser.", config.getProperty("browser"));

        DriverManager.setDriver(DriverFactory.getDriver(config.getProperty("browser")));

        DriverManager.getDriver().manage().window().maximize();

    }

    private void launchApplication() {

        logger.info("Opening application: {}",
                config.getProperty("url"));

        DriverManager.getDriver()
                .get(config.getProperty("url"));

    }

    private void initializePages() {

        logger.info("Initializing Page Object Manager.");

        pages = new PageObjectManager();

    }

}