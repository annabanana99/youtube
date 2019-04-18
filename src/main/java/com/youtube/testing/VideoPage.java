package com.youtube.testing;

import com.google.common.annotations.VisibleForTesting;
import com.youtube.testing.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class VideoPage extends Base {

    //private WebDriver driver;

    //This is a link to 'Super Fluffy Bouncy Bois' video
    public final String PAGE_URL = "https://www.youtube.com/watch?v=vYHlNo9-Nl0&t=5s";
//private JavascriptExecutor js;

    @FindBy(css = "button.ytp-play-button.ytp-button[@title ='Play (k)']")
    private WebElement playButton;

    @FindBy(css = "button.ytp-play-button.ytp-button[@title ='Pause (k)']")
    private WebElement pauseButton;


    @FindBy(css = "ytd-comment-renderer#comment.style-scope.ytd-comment-thread-renderer")
    private List<WebElement> comments;

    private By videoComments = By.cssSelector("ytd-comment-renderer#comment.style-scope.ytd-comment-thread-renderer");
    private By videoTimeElapsed = By.xpath("//div[@class='ytp-time-display notranslate']//span[@class='ytp-time-current']");
    private By volumeButtom = By.xpath("//button[contains(@class,'ytp-mute-button')]");
    private By videoprogressBar = By.xpath("//div[@class='ytp-volume-panel']"); //aria-valuetext
    private By video = By.cssSelector("video.video-stream.html5-main-video"); //aria-valuetext
    private By sort = By.id("trigger");
    private By pageBody = By.tagName("body");


    public VideoPage(WebDriver driver) {
        super(driver);
       // this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //THIS WILL PROBABLY HAVE TO BE REMOVED
    public void pageLoad() {
        load(PAGE_URL);
    }




    public int initalCommentCount() {
        driver.findElement(pageBody).sendKeys(Keys.END);
        driver.findElement(pageBody).sendKeys(Keys.END);
        setExplicitPresenceWait(9, videoComments);
        return findMultiple(videoComments).size();
    }


    public int scrolledCommentCount() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {

            Long height = (Long) js.executeScript("return document.body.scrollHeight");
            //System.out.println(height);
            //Thread.sleep(1000);
            implicitWait(6);
            //setExplicitPresenceWait(10,pageBody);
            find(pageBody).sendKeys(Keys.END);
            find(pageBody).sendKeys(Keys.END);
            find(pageBody).sendKeys(Keys.END);

            int sizeInit = findMultiple(videoComments).size();
            System.out.println(sizeInit);

            driver.findElement(pageBody).sendKeys(Keys.END);
            driver.findElement(pageBody).sendKeys(Keys.END);
            driver.findElement(pageBody).sendKeys(Keys.END);
            Thread.sleep(5000);

            if (height == 0) {
                break;
            }

            setExplicitPresenceWait(5, videoComments);
        }

        return findMultiple(videoComments).size();
    }


//************************new methods here*************************************

    public void clickButton(String button) {
        switch (button) {
            case "play":
                if (pauseButton.isDisplayed()) {
                    //log info about video already playing. when the video is loaded, it's playiing automatically
                    System.out.println("Video already playing"); //replace this with a log?
                     }
                else {
                playButton.click(); }

            case "pause":
                pauseButton.click();
        }
    }

    public void waitForVideoToPlay(int durationSeconds) throws InterruptedException {
        //sleep?
        Thread.sleep(durationSeconds * 1000);
    }

    public String visibleButton() {
        String displayedButton = "something";
        return displayedButton;
    }


    public String videoDuration(int durationSeconds) throws InterruptedException {
        String videoDuration = "0";
        //check the timing
        waitForVideoToPlay(durationSeconds);
        //grab the string after the video's played
        return videoDuration;
        //play time and videoDuration should be the same
    }

    public void scrollPage() {
        //single scroll
    }






}
