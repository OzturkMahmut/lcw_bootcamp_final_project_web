package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.cartPage;
import util.DriverFactory;

public class cartPageSteps {


    pages.cartPage cartPage = new cartPage(DriverFactory.getDriver());



    @Then("User should see {string}")
    public void shouldSee(String elementName) {
        cartPage.checkElement(elementName);
    }
}
