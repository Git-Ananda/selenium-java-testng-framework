package listeners;

import driver.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import reports.ExtentManager;

public class TestListener implements ITestListener {

    private final ExtentReports extent = ExtentManager.getExtent();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());

        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshot = ScreenshotUtility.captureScreenshot(DriverManager.getDriver(), result.getName());

        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(screenshot);

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip(result.getThrowable());

    }

    @Override

    public void onFinish(ITestContext context) {

        extent.flush();

    }

}