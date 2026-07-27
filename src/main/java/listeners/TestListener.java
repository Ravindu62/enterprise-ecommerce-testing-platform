package listeners;

import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LoggerUtils.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {

        logger.info("Execution Started");

    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Execution Finished");

    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(
                "STARTED : {}",
                result.getMethod().getMethodName()
        );

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(
                "PASSED : {}",
                result.getMethod().getMethodName()
        );

    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
                "FAILED : {}",
                result.getMethod().getMethodName()
        );

        ScreenshotUtils.captureScreenshot(
                result.getMethod().getMethodName()
        );

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn(
                "SKIPPED : {}",
                result.getMethod().getMethodName()
        );

    }

}