package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.DriverFactory;
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


    public void checkElementValue(String elementName) {
        boolean isTrue = false;
        switch (elementName) {
            case "ProductCode":
                System.out.println("1:" + properties.getProperty("selectedProductCode"));
                System.out.println("2:" +elementHelper.findElement(productCode).getText());
                isTrue = properties.getProperty("selectedProductCode").contains(elementHelper.findElement(productCode).getText());
                //isTrue = elementHelper.checkElementTextContains(productCode, properties.getProperty("selectedProductCode"));
                break;
            case "ProductQuantity":
                isTrue =elementHelper.findElement(productQuantity).getAttribute("value").equals( properties.getProperty("selectedProductQuantity"));
               // isTrue = elementHelper.checkElementText(productQuantity, properties.getProperty("selectedProductQuantity"));
                break;
            case "ProductSize":
                isTrue = elementHelper.checkElementText(productSize, properties.getProperty("selectedProductSize"));
                break;
            default:
        }
        Assert.assertEquals(true, isTrue);
    }

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
