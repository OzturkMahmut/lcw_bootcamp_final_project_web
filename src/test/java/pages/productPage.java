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
    By sizes = By.cssSelector("div .option-size a");
    By selectedSize = By.cssSelector("div .option-size .selected");
    By addToCartContainer = By.cssSelector(".add-to-cart-container");
    By myCartButton = By.cssSelector(".cart-dropdown  #shopping-cart");


    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkProductCodePresence() {
        elementHelper.checkElementPresence(productCode);
    }

    public void chooseSize(String size) {
        elementHelper.clickElementWithText(sizes,size);
    }

    public void isSizeSelected(String size) {
        elementHelper.checkElementText(selectedSize,size);
    }

    public void addToCart() {
        elementHelper.click(addToCartContainer);
    }

    public void clickElement(String buttonName) {
        if (buttonName.equals("Sepetim")){
            elementHelper.click(myCartButton);
        }
    }
}
