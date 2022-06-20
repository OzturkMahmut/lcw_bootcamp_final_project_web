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

    @When("User choose size {string}")
    public void chooseSize(String size) {
        productPage.chooseSize(size);
    }

    @Then("User should see size {string} selected")
    public void shouldSeeSizeSelected(String size) {
        productPage.isSizeSelected(size);
    }

    @Then("User adds the product to the cart")
    public void addProductToCart() {
        productPage.addToCart();
    }

    @When("User clicks {string} button")
    public void clickButton(String buttonName) {
        productPage.clickElement(buttonName);
    }

}
