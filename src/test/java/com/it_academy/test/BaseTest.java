package com.it_academy.test;

import com.it_academy.listener.TestNgListener;
import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNgListener.class)
public class BaseTest {
    @AfterSuite
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
