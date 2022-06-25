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

    public void checkHeader(String headerText) {
        elementHelper.checkElementTextContains(header,headerText);
    }

    public void filterProductBy(String filterType, String filterValue) {
        elementHelper.clickElementWithText(filterOptions,filterValue);
    }

    public void checkAppliedFilter(String filterType, String filterValue) {
        elementHelper.checkElementWithText(appliedFilters,filterType);
        elementHelper.checkElementWithText(appliedFilterValues,filterValue);

    }

    public void clickElementWithIndex(int index) {
        elementHelper.findElements(productList).get(index+1).click();
    }
}
