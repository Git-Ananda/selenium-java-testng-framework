package reports;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void info(String message) {

        ExtentTestManager.getTest().info(message);

    }

    public static void pass(String message) {

        ExtentTestManager.getTest().pass(message);

    }

    public static void warning(String message) {

        ExtentTestManager.getTest().warning(message);

    }

    public static void skip(String message) {

        ExtentTestManager.getTest().skip(message);

    }

    public static void fail(Throwable throwable) {

        ExtentTestManager.getTest().fail(throwable);

    }

    public static void fail(String message) {

        ExtentTestManager.getTest().fail(message);

    }

    public static void attachScreenshot(String path) {

        try {

            ExtentTestManager.getTest().info(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build()
            );

        }

        catch (Exception e) {

            throw new RuntimeException("Unable to attach screenshot.", e);

        }

    }

}