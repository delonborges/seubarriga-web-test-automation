package com.delonborges.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    // Variables
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
        if (Properties.execution == Properties.Executions.LOCAL) {
            switch (Properties.browser) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        if (Properties.execution == Properties.Executions.GRID) {
            DesiredCapabilities desiredCapabilities = null;
            switch (Properties.browser) {
                case CHROME:
                    desiredCapabilities = DesiredCapabilities.chrome();
                    break;
                case FIREFOX:
                    desiredCapabilities = DesiredCapabilities.firefox();
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.0.113:4444/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                System.err.println("Failed to connect to GRID!");
                e.printStackTrace();
            }
        }
        assert driver != null;
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
