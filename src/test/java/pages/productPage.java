package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.Properties;

public class productPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;

    By productCode = By.cssSelector("div .col-xs-7.col-sm-9 .product-code");
    By productQuantity = By.cssSelector("div .item-quantity-input.ignored");

    By sizes = By.cssSelector("div .option-size a");
    By selectedSize = By.cssSelector("div .option-size .selected");
    By addToCartContainer = By.cssSelector(".add-to-cart-container");
    By myCartButton = By.cssSelector(".cart-dropdown  #shopping-cart");
    By toolTip = By.cssSelector("div #evamToolTipTop");

    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();
    }


    public void checkProductCodePresence() {
        if(elementHelper.checkElementPresence(toolTip)){ //if the tool tip is blocking any action
            elementHelper.click(toolTip);
      }
        elementHelper.checkElementPresence(productCode);
        properties.setProperty("selectedProductCode",elementHelper.findElement(productCode).getText());
        //TODO: sayı için ayrı bir fonksiyon veya birleşik bir fonksiyon yapılacak
        //properties.setProperty("selectedProductQuantity",elementHelper.findElement(productQuantity).getAttribute("value"));

    }

    public void chooseSize(String size) {
        //some products have a standard size so there won't be any other choice
        if (!elementHelper.findElements(sizes).get(0).getText().equals("Standart")){
            //some products has sizes in letters, some has in numbers, or maybe there is no product in preferred size
           if (!elementHelper.checkElementWithText(sizes,size)){
               elementHelper.findElements(sizes).get(0).click(); //choose the first for no interruption to process
               properties.setProperty("selectedProductSize",elementHelper.findElements(sizes).get(0).getText());
               System.out.println("Product has another type of size labeling, or preferred size is out of stock");
           }else{ //finally if product has
               elementHelper.clickElementWithText(sizes,size);
               properties.setProperty("selectedProductSize",size);
           }
        }else{
            System.out.println("Product has a standard size. Therefore can not choose size: "+ size);
        }
    }

    public void isSizeSelected(String size) {
        /*We are just checking if any size is chosen,not the preferred one,
         due to the possibility of it not being available as suggested in chooseSize method
         We will check if chosen size is registered correctly in cart page */
        elementHelper.checkElementPresence(selectedSize);
    }

    public void addToCart() {
        elementHelper.click(addToCartContainer);
    }

    public void clickElement(String buttonName) {
        if (buttonName.equals("MyCart Button")){
            elementHelper.click(myCartButton);
        }
    }
}

