package com.youtube.testing.page.stepdefs;

import com.youtube.testing.VideoPage;
import com.youtube.testing.base.Base;
import com.youtube.testing.page.base.TestBase;
import cucumber.api.java.AfterStep;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import others.BrowserFactory;
import others.WebBrowser;
import cucumber.api.testng.TestNGCucumberRunner;
import java.io.IOException;


public class YoutubeVideoPageTestOLD extends TestBase {

   protected WebDriver driver;

    @BeforeTest()
    @Parameters({"browser",})
    public void setUp(@Optional("CHROME") WebBrowser browser) throws Exception {
        BrowserFactory factory = new BrowserFactory(browser);
        driver = factory.getDriver();
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void loadPageTest() {
        VideoPage vpage = new VideoPage(driver);
        vpage.pageLoad();
       // vpage.playVideo();
    }


    @Test()
    public void commentScrollTest() throws InterruptedException {
        VideoPage vpage = new VideoPage(driver);
        vpage.pageLoad();
        int commentCount = vpage.scrolledCommentCount();
        System.out.println(commentCount);
   /*     int beforeScroll = vpage.initalCommentCount();
        int afterScroll = vpage.scrolledCommentCount();
        assert afterScroll > beforeScroll;*/
    }





    @AfterTest()
    public void tearDown() throws IOException {
        driver.close();
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
    }
}
