package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;


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

    /**
     * check if the website is loaded,
     * then close cookies and coupon banner if the appear on the screen
     * to clear the screen to perform further actions without any problems.
     */
    public void checkHomePage() {
        elementHelper.checkElementPresence(brandLogo);
        elementHelper.click(cookiesAcceptButton); //Accepts the cookies in case cookies banner blocks any future action
        if (elementHelper.checkElementPresenceBool(couponCloseButton)) {
            elementHelper.click(couponCloseButton);   //Closes the coupon pop-up in case it blocks any future action
        }

    }

    /**
     * check if the brand logo is present on the DOM of a page
     */
    public void checkBanner() {
        elementHelper.checkElementPresence(brandLogo);
    }

    /**
     * check if a category exist in categories list
     *
     * @param categoryName String
     */
    public void checkCategory(String categoryName) {
        elementHelper.checkElementWithText(categories, categoryName);
    }

    /**
     * hover over a category
     *
     * @param category String
     */
    public void hoverOverCategory(String category) {
        elementHelper.hoverOverElementWithText(categories, category);
    }

    /**
     * a method to click sign up button in homepage
     */
    public void hoverOverLoginClickSignUp() {
        elementHelper.hoverOverElement(loginButton);
        elementHelper.click(signUpButton);
    }

    /**
     * click the sub-category with the given string parameter
     *
     * @param subCategory String
     */
    public void clickSubCategory(String subCategory) {
        elementHelper.clickElementWithText(subCategories, subCategory);
    }

    /**
     * click the element with the given string parameter
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        switch (elementName) {
            case "Login Button":
                elementHelper.click(loginButton);
                break;
            default:
        }
    }

    /**
     * check if the visible text of the element with the given string parameter
     * equals to the given parameter text
     *
     * @param text        String
     * @param elementName String
     */
    public void checkElementText(String text, String elementName) {
        switch (elementName) {
            case "My Account Button":
                elementHelper.checkElementWithText(myAccountButton, text);
                break;
            case "Login Button":
                elementHelper.checkElementWithText(loginButton, text);
                break;
            default:
        }
    }
}
