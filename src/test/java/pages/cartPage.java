package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.ElementHelper;

import java.util.Properties;

public class cartPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;


    By title = By.cssSelector(".col-md-12.cart-header.mb-20 span:nth-child(1)");
    By productQuantity = By.cssSelector(".item-quantity-input.ignored");
    By productCode = By.cssSelector("div .rd-cart-item-code  ");
    By productSize = By.cssSelector(".rd-cart-item-size strong ");
    By completeOrderButton = By.cssSelector(".rd-cart-item-size strong ");
    By loginButton = By.cssSelector("div .cart-dropdown:nth-child(1)");

    public cartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();
    }

    /**
     * check if the product properties seen on page are equal to
     * the product properties that are stored in config file
     * when adding a product to the cart.
     *
     * @param elementName String
     */
    public void checkElementValue(String elementName) {
        boolean isTrue = false;
        switch (elementName) {
            case "ProductCode":
                isTrue = properties.getProperty("selectedProductCode").contains(elementHelper.findElement(productCode).getText());
                break;
            case "ProductQuantity":
                isTrue = elementHelper.findElement(productQuantity).getAttribute("value").equals(properties.getProperty("selectedProductQuantity"));
                break;
            case "ProductSize":
                isTrue = elementHelper.checkElementText(productSize, properties.getProperty("selectedProductSize"));
                break;
            default:
        }
        Assert.assertTrue(isTrue);
    }

    /**
     * click the element given by its intuitive name
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        switch (elementName) {
            case "Complete Order Button":
                elementHelper.click(completeOrderButton);
                break;
            case "Login Button":
                elementHelper.click(loginButton);
                break;
        }
    }
}
