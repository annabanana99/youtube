package com.youtube.testing.page.base;

import com.youtube.testing.VideoPage;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import others.BrowserFactory;
import others.WebBrowser;

import java.io.IOException;

public class TestBase {

    public WebDriver driver;
    protected VideoPage videoPage;// = new VideoPage(driver);




    @Before()
    @Parameters({"browser",})
    public void setUp(@Optional("CHROME") WebBrowser browser) throws Exception {
        BrowserFactory factory = new BrowserFactory(browser);
        driver = factory.getDriver();
        driver.manage().window().maximize();
        videoPage = new VideoPage(driver);
        videoPage.pageLoad();
    }

    @After()
    public void tearDown() throws IOException {
        driver.close();
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f"); //and if not chrome?
    }


}
