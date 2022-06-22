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

    By productCode = By.cssSelector("div .product-code");
    By sizes = By.cssSelector("div .option-size a");
    By selectedSize = By.cssSelector("div .option-size .selected");
    By addToCartContainer = By.cssSelector(".add-to-cart-container");
    By myCartButton = By.cssSelector(".cart-dropdown  #shopping-cart");
    By toolTip = By.cssSelector("div #evamToolTipTop");

    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkProductCodePresence() {
        elementHelper.checkElementPresence(productCode);
        if(elementHelper.checkElementPresence(toolTip)){ //if the tool tip is blocking any action
            elementHelper.click(productCode); //click anywhere else in the page
            //I chose product code because its By locator is already found and click won't trigger any action
        }
    }

    public void chooseSize(String size) {
        properties = ConfigReader.getProperties();
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
        if (buttonName.equals("Sepetim")){
            elementHelper.click(myCartButton);
        }
    }
}

