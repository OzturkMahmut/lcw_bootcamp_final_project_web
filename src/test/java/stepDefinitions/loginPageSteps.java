package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import util.DriverFactory;

public class loginPageSteps {

    pages.loginPage loginPage = new loginPage(DriverFactory.getDriver());

    @When("User clicks {string} element in login page")
    public void clickElement(String elementName) {
        loginPage.clickElement(elementName);
    }

    @Then("User should see {string} element in login page")
    public void shouldSeeElement(String elementName) {
        loginPage.checkElement(elementName);
    }

    @Then("User should see {string} text in {string} element in login page")
    public void shouldSeeTextInElement(String text, String elementName) {
        loginPage.checkElementText(text,elementName);
    }

    @When("User fills out the {string} input container with  {string} in login page")
    public void fillOutInputContainer(String container, String input) {
        loginPage.fillOutInputContainer(container,input);
    }
}
