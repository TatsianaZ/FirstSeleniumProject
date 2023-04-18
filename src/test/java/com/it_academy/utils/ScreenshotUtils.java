package com.it_academy.utils;

import com.it_academy.onliner.framework.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotUtils {

    public static void takeScreenshot(ITestResult result) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Calendar calendar = Calendar.getInstance();
        String methodName = result.getName();
        if (!result.isSuccess()) {
            File screenshot = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                        + "/target/reports";
                File destFile = new File((reportDirectory + "/failure_screenshots/" + methodName + "_"
                        + formatter.format(calendar.getTime()) + ".png"));
                FileUtils.copyFile(screenshot, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void takeScreenshotOfSpecificElement(WebElement element) {
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                    + "/target/reports";
            File destFile = new File((reportDirectory + "/failure_screenshots/element_screenshot.png"));
            FileUtils.copyFile(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeFullPageScreenshot(ITestResult result) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Calendar calendar = Calendar.getInstance();
        String methodName = result.getName();
        if (!result.isSuccess()) {
            File screenshot = ((FirefoxDriver) DriverManager.getWebDriver()).getFullPageScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                        + "/target/reports";
                File destFile = new File((reportDirectory + "/failure_screenshots_full_page/" + methodName + "_"
                        + formatter.format(calendar.getTime()) + ".png"));
                FileUtils.copyFile(screenshot, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
