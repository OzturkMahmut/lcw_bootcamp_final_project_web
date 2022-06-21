package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.signUpPage;
import util.DriverFactory;

public class signUpPageSteps {

    pages.signUpPage signUpPage = new signUpPage(DriverFactory.getDriver());

    @Then("User should see {string} pageTitle")
    public void shouldSeePageTitle(String pageTitle) {
        signUpPage.checkPageTitle(pageTitle);
    }

    @Then("User should see {string} element")
    public void shouldSeeElement(String signUpFormElement) {
        signUpPage.checkSignUpFormElement(signUpFormElement);
    }

}
