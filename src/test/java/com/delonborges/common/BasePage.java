package com.delonborges.common;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.delonborges.common.DriverFactory.getDriver;

public class BasePage {

    // Variables
    public WebDriverWait wait;

    // Constructor
    public BasePage() {
        getDriver().get("https://seubarriga.wcaquino.me");
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), 10);
    }
}
