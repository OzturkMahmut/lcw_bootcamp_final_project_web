package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.checkoutPage;
import util.DriverFactory;

public class checkoutPageSteps {


    pages.checkoutPage checkoutPage = new checkoutPage(DriverFactory.getDriver());


    @Then("User should see {string} element in checkout page")
    public void shouldSee(String elementName) {
        checkoutPage.checkElement(elementName);
    }
}
