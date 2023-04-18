package com.it_academy.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.it_academy.utils.ScreenshotUtils.takeFullPageScreenshot;
import static com.it_academy.utils.ScreenshotUtils.takeScreenshot;

public class TestNgListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
        takeFullPageScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenshot(result);
    }
}
