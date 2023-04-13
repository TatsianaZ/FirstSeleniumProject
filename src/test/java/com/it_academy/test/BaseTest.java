package com.it_academy.test;

import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    @AfterSuite
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
