package com.it_academy.onliner.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<RemoteWebDriver> driver =
            new ThreadLocal();

    private static void setWebDriver() {
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            setWebDriver();
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }
}
