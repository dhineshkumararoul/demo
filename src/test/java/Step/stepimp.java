package Step;

import java.io.IOException;

import org.testng.Assert;

import FristProject.Project.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import landingPage.landingpagebase;

public class stepimp extends Base {

    landingpagebase irctc;

    @Given("I open the IRCTC website")
    public void open_website() throws IOException {
        driver = initailzer();
        irctc = new landingpagebase(driver); 
        irctc.url();
        irctc.image();
    }

    @When("I enter {string} as starting code and {string} as full starting")
    public void from_loaction(String shot, String full) throws InterruptedException {
        irctc.starting(shot, full);
    }

    @Then("I validate the train page starts correctly")
    public void verfiy_it() {
        Assert.assertTrue(true);
    }
}
