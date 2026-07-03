package dataproviders;

import org.testng.annotations.DataProvider;
import utilities.ConfigReader;
import utilities.ExcelUtility;

public class LoginDataProvider {

    private static final ConfigReader config = ConfigReader.getInstance();

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return ExcelUtility.getTestData(config.getProperty("loginExcelFile"), config.getProperty("loginSheet"));

    }

}