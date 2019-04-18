package com.youtube.testing.page.stepdefs;

import com.youtube.testing.VideoPage;
import com.youtube.testing.page.base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class YoutubeVideoTest extends TestBase {


    @Given("The page is loaded")
    public void pageLad() {
        videoPage.pageLoad();
    }


    @When("^a \"([^\"]*)\" button is clicked$")
    public void aButtonButtonIsClicked(String button) {
        videoPage.clickButton(button);
    }

    @And("^the user waits \"([^\"]*)\" seconds$")
    public void theUserWaitsDurationSeconds(int duration) throws InterruptedException {
        videoPage.waitForVideoToPlay(duration);
    }


    @Then("^video time duration progress is \"([^\"]*)\" seconds$")
    public void videoTimeDurationProgress(int duration) {
    }

    @And("^\"([^\"]*)\" button will be enabled$")
    public void buttonWillBeEnabled(String enabledButton) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

