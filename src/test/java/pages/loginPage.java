package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;

public class loginPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Login Form Element Selectors
    By emailRadioButton = By.cssSelector(".login-form__radio-buttons .login-form__radio-buttons--first-label");
    By phoneRadioButton = By.cssSelector(".login-form__radio-buttons .login-form__radio-buttons--second-label");
    By loginFormTitle = By.cssSelector("div .login-form__title");
    By emailInputContainer = By.cssSelector("div .text-input[name=email]");
    By passwordInputContainer = By.cssSelector("div .text-input[name=password]");
    By showPasswordIcon = By.cssSelector("div .login-form__show-password-icon--img");
    By rememberMeCheckBox = By.cssSelector(".checkbox-label .checkbox-span");
    By forgotPasswordLink = By.cssSelector("div .login-form__forgot-password-link");
    By loginFormLoginButton = By.cssSelector(".login-form__button.login-form__button--bg-blue");
    By loginFormSignUpButton = By.cssSelector("div .login-form__link");
    By phoneInputContainer = By.cssSelector("div .login-form__phone.text-input");

    By emailError = By.cssSelector(".login-form > form:nth-child(2) > div:nth-child(2) > div:nth-child(2)");
    By passwordError = By.cssSelector(".login-form__password .error");
    By loginError = By.cssSelector("div .login-form__header-errors--p ");

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void clickElement(String elementName) {
        switch (elementName) {
            case "Email Radio Button":
                elementHelper.click(emailRadioButton);
                break;
            case "Phone Radio Button":
                elementHelper.click(phoneRadioButton);
                break;
            case "Login Button":
                elementHelper.click(loginFormLoginButton);
                break;
            case "Sign Up Button":
                elementHelper.click(loginFormSignUpButton);
                break;
        }
    }

    public void checkElement(String elementName) {
        switch (elementName) {
            case "Email Radio Button":
                elementHelper.checkElementPresence(emailRadioButton);
                break;
            case "Phone Radio Button":
                elementHelper.checkElementPresence(phoneRadioButton);
                break;
            case "Email Input Container":
                elementHelper.checkElementPresence(emailInputContainer);
                break;
            case "Password Input Container":
                elementHelper.checkElementPresence(passwordInputContainer);
                break;
            case "Show Password Icon":
                elementHelper.checkElementPresence(showPasswordIcon);
                break;
            case "Forgot Password Link":
                elementHelper.checkElementPresence(forgotPasswordLink);
                break;
            case "Login Button":
                elementHelper.checkElementPresence(loginFormLoginButton);
                break;
            case "Sign Up Button":
                elementHelper.checkElementPresence(loginFormSignUpButton);
                break;
            case "Phone Input Container":
                elementHelper.checkElementPresence(phoneInputContainer);
                break;

        }

    }

    public void checkElementText(String text, String elementName) {
        switch (elementName) {
            case "Form Title":
                elementHelper.checkElementWithText(loginFormTitle,text);
                break;
            case "Email Input Container":
                elementHelper.checkElementWithText(emailInputContainer,text);
                break;
            case "Password Input Container":
                elementHelper.checkElementWithText(passwordInputContainer,text);
                break;
            case "Remember Me":
                elementHelper.checkElementWithText(rememberMeCheckBox,text);
                break;
        }
    }
}