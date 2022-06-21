package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;

public class signUpPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Sign Up Form Element Selectors
    By formTitle = By.cssSelector("div .register__title");
    By emailContainer = By.cssSelector("div .input-container");
    By passwordContainer = By.cssSelector("div .input-container:nth-child(2)");
    By showPasswordIcon = By.cssSelector("div .register__show-password-icon  ");
    By phoneNumberContainer = By.cssSelector("div .input-container:nth-child(3)");
    By emailCheckBox = By.cssSelector("div .register__optin-checkboxes input:nth-child(1)");
    By callCheckBox = By.cssSelector("div .register__optin-checkboxes input:nth-child(2)");
    By smsCheckBox = By.cssSelector("div .register__optin-checkboxes input:nth-child(3)");
    By registerInfoContainer = By.cssSelector("div .register__information-container");
    By termsOfUseCheckBox = By.cssSelector("div #member-privacy-approve-container");
    By clarificationText = By.cssSelector("div .aydinlatma-metni");
    By signUpButton = By.cssSelector("div .register__button--blue");
    By loginButton = By.cssSelector("div .register__link");


    public signUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkPageTitle(String pageTitle) {
        elementHelper.checkTitle(pageTitle);
    }


    public void checkSignUpFormElement(String signUpFormElement) {
        switch(signUpFormElement) {
            case "SignUp Form Title":
                elementHelper.checkElementPresence(formTitle);
                break;
            case "Email Input Container":
                elementHelper.checkElementPresence(emailContainer);
                break;
            case "Password Input Container":
                elementHelper.checkElementPresence(passwordContainer);
                break;
            case "Show Password Icon":
                elementHelper.checkElementPresence(showPasswordIcon);
                break;
            case "Phone Number input container":
                elementHelper.checkElementPresence(phoneNumberContainer);
                break;
            case "Email CheckBox":
                elementHelper.checkElementPresence(emailCheckBox);
                break;
            case "Call CheckBox":
                elementHelper.checkElementPresence(callCheckBox);
                break;
            case "SMS CheckBox":
                elementHelper.checkElementPresence(smsCheckBox);
                break;
            case "Register Info Container":
                elementHelper.checkElementPresence(registerInfoContainer);
                break;
            case "Terms of Use CheckBox":
                elementHelper.checkElementPresence(termsOfUseCheckBox);
                break;
            case "Clarification Text":
                elementHelper.checkElementPresence(clarificationText);
                break;
            case "Sign Up Button":
                elementHelper.checkElementPresence(signUpButton);
                break;
            case "Login Button":
                elementHelper.checkElementPresence(loginButton);
                break;
            default:
        }

    }


}
