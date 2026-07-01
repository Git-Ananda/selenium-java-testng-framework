package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private By usernameTextbox = By.name("username");

    private By passwordTextbox = By.name("password");

    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {

        super(driver);

    }

    public void enterUsername(String username) {

        logger.info("Entering username.");

        waitUtility.waitForVisibility(usernameTextbox).sendKeys(username);

    }

    public void enterPassword(String password) {

        logger.info("Entering password.");

        waitUtility.waitForVisibility(passwordTextbox).sendKeys(password);

    }

    public void clickLogin() {

        logger.info("Clicking Login button.");

        waitUtility.waitForVisibility(loginButton).click();

    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

}