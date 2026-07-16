package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getExtent() {

        if (extent == null) {

            createInstance();

        }

        return extent;

    }

    private static void createInstance() {

        ExtentSparkReporter spark = new ExtentSparkReporter("reports/AutomationReport.html");

        spark.config().setReportName("Automation Execution Report");

        spark.config().setDocumentTitle("Selenium Framework");

        spark.config().setReportName("Automation Execution Report");

        spark.config().setDocumentTitle("Selenium Framework");

        extent = new ExtentReports();

        extent.attachReporter(spark);

        extent.setSystemInfo("Framework", "Selenium Java");

        extent.setSystemInfo("Java", System.getProperty("java.version"));

        extent.setSystemInfo("OS", System.getProperty("os.name"));

        extent.setSystemInfo("Tester", "Anandaroop Maitra");

    }

}