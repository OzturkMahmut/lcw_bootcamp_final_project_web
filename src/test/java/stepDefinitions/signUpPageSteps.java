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

    @Then("User should see {string} element in sign-up page")
    public void shouldSeeFormElement(String signUpFormElement) {
        signUpPage.checkSignUpFormElement(signUpFormElement);
    }

    @When("User fills out the {string} input container with  {string} in sign up page")
    public void fillOutInputContainer(String container, String input) {
        signUpPage.fillOutInputContainer(container,input);
    }

    @When("User checks {string} checkbox in sign-up page")
    public void checkCheckbox(String checkboxName) {
        signUpPage.checkCheckbox(checkboxName);
    }

    @When("User clicks  {string} element in sign-up page")
    public void clicksButton(String element) {
        signUpPage.clickElement(element);
    }


}
