package retry;

import constants.FrameworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import reports.ExtentLogger;
import utilities.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    private final int maxRetryCount = ConfigReader.getInstance().getIntProperty("retryCount");

    private int currentRetry = 0;

    @Override
    public boolean retry(ITestResult result) {

        if(currentRetry < maxRetryCount){

            currentRetry++;

            ExtentLogger.warning("Retry "
                            + currentRetry
                            + " of "
                            + maxRetryCount
            );

            logger.warn("Retry {}", currentRetry);

            return true;

        }

        return false;

    }
}