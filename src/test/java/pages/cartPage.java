package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.Properties;

public class cartPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    static Properties properties;


    By title = By.cssSelector(".col-md-12.cart-header.mb-20 span:nth-child(1)");
    By productNumber = By.cssSelector(".item-quantity-input.ignored");
    By productName = By.cssSelector(".rd-cart-item-code ");
    By productSize = By.cssSelector(".rd-cart-item-size strong ");

    public cartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkElement(String elementName) {
        if (elementName.equals("Title")) {
            elementHelper.checkElementPresence(title);
        }else if (elementName.equals("ProductCode")) {
            elementHelper.checkElementPresence(productName);
        }else if (elementName.equals("ProductNumber")) {
            elementHelper.checkElementPresence(productNumber);
        }else if (elementName.equals("ProductSize")) {
            properties = ConfigReader.getProperties();
            elementHelper.checkElementText(productSize,properties.getProperty("selectedProductSize"));

        }
    }
}

