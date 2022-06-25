package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;
import java.util.Properties;

public class checkoutPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;

    By newAddressForm  = By.cssSelector("div .customerAddressModel.v--modal-overlay.scrollable .v--modal-box.v--modal");
    By fullNameInput  = By.cssSelector("#FullNameInput");
    By withoutLoginForm = By.cssSelector("div .login-form.without-login-form");

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    /**
     * check if an element exist with the given elementName.
     *
     * @param elementName String
     */
    public void checkElement(String elementName) {
        switch (elementName) {
            case "New Address Form":
                elementHelper.checkElementPresence(newAddressForm);
                break;
            case "Full Name Input":
                elementHelper.checkElementPresence(fullNameInput);
                break;
            case "Order without Login Form":
                elementHelper.checkElementPresence(withoutLoginForm);
                break;
        }
    }
}



