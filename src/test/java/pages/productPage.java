package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;

public class productPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    By productCode = By.cssSelector("div .product-code");


    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkProductCodePresence() {
        elementHelper.checkElementPresence(productCode);
    }
}

