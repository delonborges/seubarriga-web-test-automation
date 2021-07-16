package com.delonborges.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // Variables
    private static WebDriver driver;

    // Constructor
    private DriverFactory() {
    }

    // Initialization
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (Properties.browser) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().setSize(new Dimension(1366, 768));
        }
        return driver;
    }

    // Finalization
    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
