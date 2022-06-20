package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.productListPage;
import util.DriverFactory;

public class productListPageSteps {


    pages.productListPage productListPage = new productListPage(DriverFactory.getDriver());


    @Then("User should see {string} page")
    public void shouldSeeHeader(String header) {
        productListPage.checkHeader(header);
    }
}
