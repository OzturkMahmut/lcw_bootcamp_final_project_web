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
    }

    public void checkBanner() {
        elementHelper.checkElementPresence(brandLogo);
    }

    public void checkCategory(String categoryName) {
        elementHelper.checkElementWithText(categories,categoryName);
    }


    public void hoverOverCategory(String category) {
        elementHelper.hoverOverElementWithText(categories,category);
    }

    public void hoverOverLoginClickSignUp() {
        elementHelper.hoverOverElement(loginButton);
        elementHelper.click(signUpButton);
    }

    public void clickElement(String subCategory) {
        elementHelper.clickElementWithText(subCategories,subCategory);
    }
}
