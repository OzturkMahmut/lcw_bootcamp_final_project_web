package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.List;
import java.util.Properties;

public class productPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;

    By productCode = By.cssSelector("div .col-xs-7.col-sm-9 .product-code");
    By sizes = By.cssSelector("div .option-size a");
    By selectedSize = By.cssSelector("div .option-size .selected");
    By addToCartContainer = By.cssSelector(".add-to-cart-container");
    By myCartButton = By.cssSelector(".cart-dropdown  #shopping-cart");
    By toolTip = By.cssSelector("div #evamToolTipTop");
    By myCartProductQuantity = By.cssSelector("div .badge-circle");


    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();
    }

    /**
     * check if the product code is present
     */
    public void checkProductCodePresence() {
        if (elementHelper.checkElementPresenceBool(toolTip)) { //if the tool tip is blocking any action
            elementHelper.click(toolTip);
        }
        elementHelper.checkElementPresence(productCode);
        properties.setProperty("selectedProductCode", elementHelper.findElement(productCode).getText());
    }

    /**
     * click the desired size and also store it in config file to check later on.
     * if desired size is not available choose any size to continue the case
     *
     * @param size String
     */
    public void chooseSize(String size) {
        //some products have a standard size so there won't be any other choice
        if (!elementHelper.findElements(sizes).get(0).getText().equals("Standart")) {
            //some products has sizes in letters, some has in numbers, or maybe product in desired size is out of stock
            if (!elementHelper.checkElementWithTextBool(sizes, size) || elementHelper.getAttribute(elementHelper.checkElementWithText(sizes, size), "class").equals("disabled")) {
                List<WebElement> elements = elementHelper.findElements(sizes);
                for (WebElement element : elements) {
                    if (!elementHelper.getAttribute(element, "class").equals("disabled")) {
                        element.click(); //choose any size with available stock for no interruption to process
                        properties.setProperty("selectedProductSize", element.getText());
                        break;
                    }
                }
                System.out.println("Product has another type of size labeling, or preferred size is out of stock");
            } else { //finally if product is available in desired size
                elementHelper.clickElementWithText(sizes, size);
                properties.setProperty("selectedProductSize", size);
            }
        } else {
            System.out.println("Product has a standard size. Therefore can not choose size: " + size);
        }
    }

    /**
     * check if the chosen size is indicated on the screen
     *
     * @param size String
     */
    public void isSizeSelected(String size) {
        /*We are just checking if any size is chosen,not the preferred one,
         due to the possibility of it not being available as suggested in chooseSize method
         We will check if chosen size is registered correctly in cart page */
        elementHelper.checkElementPresence(selectedSize);
    }

    /**
     * click add-to-cart button
     */
    public void addToCart() {
        elementHelper.click(addToCartContainer);
        properties.setProperty("selectedProductQuantity", elementHelper.findElement(myCartProductQuantity).getText());
    }

    /**
     * click the button given by its intuitive name
     *
     * @param buttonName String
     */
    public void clickElement(String buttonName) {
        if (buttonName.equals("MyCart Button")) {
            elementHelper.click(myCartButton);
        }
    }
}

