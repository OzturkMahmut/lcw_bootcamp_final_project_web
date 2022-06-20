package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;
import util.DriverFactory;

public class productPageSteps {


    pages.productPage productPage = new productPage(DriverFactory.getDriver());

    @Then("User should see product code info")
    public void shouldSeeProductCodeInfo() {
        productPage.checkProductCodePresence();

    }

}
