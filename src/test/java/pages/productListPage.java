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

    public productListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkHeader(String headerText) {
        elementHelper.checkElementTextContains(header,headerText);
    }

}
