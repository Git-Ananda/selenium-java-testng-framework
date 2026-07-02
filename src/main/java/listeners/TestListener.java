package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import constants.FrameworkConstants;
import driver.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    private final ExtentReports extent = ExtentManager.getExtent();




    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentTestManager.getTest();

        ExtentTest extentTest = extent.createTest(
                result.getTestClass().getRealClass().getSimpleName()
                        + " :: "
                        + result.getMethod().getMethodName()
        );

        ExtentTestManager.setTest(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentLogger.pass("Test Passed");

        ExtentTestManager.unload();

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshot =
                ScreenshotUtility.captureScreenshot(
                        DriverManager.getDriver(),
                        result.getMethod().getMethodName()
                );

        ExtentLogger.fail(result.getThrowable());

        ExtentLogger.attachScreenshot(screenshot);

        ExtentTestManager.unload();

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        if (result.getThrowable() != null) {

            ExtentLogger.skip(result.getThrowable().getMessage());

        }

        else {

            ExtentLogger.skip("Test Skipped.");

        }

        ExtentTestManager.unload();

    }


    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }

}

