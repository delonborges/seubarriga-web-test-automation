package com.delonborges.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // Variables
    // private static WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    // Constructor
    private DriverFactory() {
    }

    // Initialization
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        switch (Properties.browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().setSize(new Dimension(1366, 768));
        return driver;
    }

    // Finalization
    public static void stopDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
        threadDriver.remove();
    }
}
