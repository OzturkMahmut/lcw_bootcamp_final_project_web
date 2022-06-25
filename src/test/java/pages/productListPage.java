package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;

public class productListPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    By header = By.cssSelector("div .product-list-banner h1");
    By filterOptions = By.cssSelector("div .color-filter-option__text");
    By appliedFilters = By.cssSelector("div .applied-filters__filter");
    By appliedFilterValues = By.cssSelector("div .applied-filters__value");
    By productList = By.cssSelector(".product-card.product-card--one-of-4");


    public productListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    /**
     * check if the page header contains the given text parameter
     *
     * @param headerText String
     */
    public void checkHeader(String headerText) {
        elementHelper.checkElementTextContains(header, headerText);
    }

    /**
     * filter the products by the desired filter value
     *
     * @param filterType  String
     * @param filterValue String
     */
    public void filterProductBy(String filterType, String filterValue) {
        elementHelper.clickElementWithText(filterOptions, filterValue);
    }

    /**
     * check if the desired filter value is applied correctly
     *
     * @param filterType  String
     * @param filterValue String
     */
    public void checkAppliedFilter(String filterType, String filterValue) {
        elementHelper.checkElementWithText(appliedFilters, filterType);
        elementHelper.checkElementWithText(appliedFilterValues, filterValue);

    }

    /**
     * click the nth element in the product list
     *
     * @param index int
     */
    public void clickElementWithIndex(int index) {
        elementHelper.findElements(productList).get(index + 1).click();
    }
}
