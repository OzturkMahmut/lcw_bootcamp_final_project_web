package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.util.List;


public class homePage {

    By brandLogo = By.cssSelector(".main-header-logo");
    By categories = By.cssSelector("div .menu-nav__lists .menu-header-item .menu-header-item__title");
    By subCategories = By.cssSelector("div .menu-nav__lists .menu-header-item .mega-menu .zone-item a");
    By cookiesAcceptButton = By.cssSelector("div .cookieseal-banner-body button:nth-of-type(2) ");
    By loginButton = By.cssSelector("div .cart-dropdown:nth-child(1)");
    By signUpButton = By.cssSelector(" .cart-action__btn--bg-white");
    By couponCloseButton = By.cssSelector("div #wrap-close-button-1454703513202 .editable.ins-element-editable.editable-text");
    By myAccountButton = By.cssSelector("div .header-dropdown-toggle.striped-button span");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkHomePage() {
        elementHelper.checkElementPresence(brandLogo);
        elementHelper.click(cookiesAcceptButton); //Accepts the cookies in case cookies banner blocks any future action
        if (elementHelper.checkElementPresence(couponCloseButton)){
            elementHelper.click(couponCloseButton);   //Closes the coupon pop-up in case it blocks any future action
        }

    }

    public void checkBanner() {
        elementHelper.checkElementPresence(brandLogo);
    }

    public void checkCategory(String categoryName) {
        elementHelper.checkElementWithText(categories, categoryName);
    }


    public void hoverOverCategory(String category) {
        elementHelper.hoverOverElementWithText(categories, category);
    }

    public void hoverOverLoginClickSignUp() {
        elementHelper.hoverOverElement(loginButton);
        elementHelper.click(signUpButton);
    }

    public void clickSubCategory(String subCategory) {
        elementHelper.clickElementWithText(subCategories, subCategory);
    }

    public void clickElement(String elementName) {
        switch (elementName) {
            case "Login Button":
                elementHelper.click(loginButton);
                break;
            default:
        }
    }

    public void checkElementText(String text, String elementName) {
        switch (elementName) {
            case "My Account Button":
                elementHelper.checkElementWithText(myAccountButton,text);
                break;
            case "Login Button":
                elementHelper.checkElementWithText(loginButton,text);
                break;
            default:
        }
    }
}
