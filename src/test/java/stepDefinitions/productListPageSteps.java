package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productListPage;
import util.DriverFactory;

public class productListPageSteps {


    pages.productListPage productListPage = new productListPage(DriverFactory.getDriver());


    @Then("User should see {string} page")
    public void shouldSeeHeader(String header) {
        productListPage.checkHeader(header);
    }

    @When("User filters {string} of the products by {string}")
    public void filterProductBy(String filterType, String filterValue) {
        productListPage.filterProductBy(filterType,filterValue);
    }

    @Then("User should see {string} and {string} in chosen filters area")
    public void shouldSeeChosenFilter(String filterType, String filterValue) {
        productListPage.checkAppliedFilter(filterType,filterValue);

    }


    @When("User clicks on the {int}. item in the product list")
    public void clickNthElementInList(int index) {
        productListPage.clickElementWithIndex(index);
    }



}
