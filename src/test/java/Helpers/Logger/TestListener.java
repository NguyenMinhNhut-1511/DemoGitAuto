package Helpers.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("[ERR] - " + result.getName() +"\n"+ result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult iTest) {
        Log.info("Start Testing ... "+ iTest.getName().toUpperCase() );

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Testcase: " + iTestResult.getName().toUpperCase() + " successfully!");

    }
}