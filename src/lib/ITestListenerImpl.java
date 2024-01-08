package lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl implements ITestListener {
    public void onTestStart(ITestResult result) {

    }
    public void onTestSuccess(ITestResult result) {

    }
    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShorts.takeScreenShorts();
    }
    public void onTestSkipped(ITestResult result) {

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    public void onStart(ITestContext context) {

    }
    public void onFinish(ITestContext context) {

    }
}
