package com.listeners;

import org.testng.*;

import static com.reports.ExtentLogger.*;
import static com.reports.ExtentReport.*;

public class Listeners implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        createExtentTest(result.getName());
        pass(result.getName() + " started successfully !!!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        pass(result.getName() + "is passed !!!");
        endExtentTest(result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String error = result.getName() + " TEST is failed !!!<br>" + result.getThrowable();
        fail(error);
        endExtentTest(result.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skip(result.getName() + "is skipped !!!");
    }

}
