package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;
import util.DriverFactory;

public class cartPageSteps {


    pages.cartPage cartPage = new cartPage(DriverFactory.getDriver());


    @Then("User should see {string} in cart page")
    public void shouldSee(String elementName) {
        cartPage.checkElementValue(elementName);
    }


    @When("User clicks {string} element in cart page")
    public void clicksElement(String elementName) {
        cartPage.clickElement(elementName);
    }
}
