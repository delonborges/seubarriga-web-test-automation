package com.delonborges.common;

import com.delonborges.pages.HomePage;
import com.delonborges.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.delonborges.common.DriverFactory.getDriver;
import static com.delonborges.common.DriverFactory.stopDriver;

public class BaseTest {

    // Variables
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Rule
    public TestName testName = new TestName();

    // Setup
    @Before
    public void setUp() {
        getDriver();
        this.loginPage.efetuaLogin("delon@borges.com", "delonborges");
        this.homePage.clicaLinkReset();
    }

    // Teardown
    @After
    public void tearDown() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(
                file,
                new File("target" + File.separator + "test-screenshots" + File.separator + testName.getMethodName() + ".jpg")
        );
        stopDriver();
    }
}
