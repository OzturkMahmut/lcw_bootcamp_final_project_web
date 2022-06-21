package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import util.DriverFactory;

public class homePageSteps {

    homePage homePage = new homePage(DriverFactory.getDriver());


    @Given("User is on home page")
    public void isOnHomePage() {
        homePage.checkHomePage();
    }

    @Then("User should see Banner")
    public void shouldSeeBanner() {
        homePage.checkBanner();
    }

    @Then("User should see {string} category")
    public void shouldSeeCategory(String categoryName) {
        homePage.checkCategory(categoryName);
    }

    @When("User clicks {string} subcategory in {string} category")
    public void clickSubcategory(String subCategory, String category) {
        homePage.hoverOverCategory(category);
        homePage.clickElement(subCategory);
    }

    @When("User hovers over Login button and clicks Sign Up Button")
    public void clickSignUpButton() {
        homePage.hoverOverLoginClickSignUp();
    }
}
