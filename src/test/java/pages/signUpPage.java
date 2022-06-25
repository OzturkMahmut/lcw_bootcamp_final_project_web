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
    By emailContainer = By.cssSelector("div .input-container:nth-child(1) .text-input ");
    By passwordContainer = By.cssSelector("div .input-container:nth-child(2) .text-input ");
    By showPasswordIcon = By.cssSelector("div .register__show-password-icon");
    By phoneNumberContainer = By.cssSelector("div .input-container:nth-child(3) .text-input ");
    By emailCheckBox = By.cssSelector("div .register__optin-checkboxes input[name=isEmailChecked]");
    By callCheckBox = By.cssSelector("div .register__optin-checkboxes input[name=isCallChecked]");
    By smsCheckBox = By.cssSelector("div .register__optin-checkboxes input[name=isSmsChecked]");
    By registerInfoContainer = By.cssSelector("div .register__information-container");
    By termsOfUseCheckBox = By.cssSelector("div #member-privacy-approve-container .checkbox-input");
    By clarificationText = By.cssSelector("div .aydinlatma-metni");
    By signUpButton = By.cssSelector("div .register__button--blue");
    By loginButton = By.cssSelector("div .register__link");
    By phoneConfirmationPopUp = By.cssSelector("div .react-base-modal.confirmation-code-modal");



    public signUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    /**
     * check if the page title is the same as the given text parameter
     *
     * @param pageTitle String
     */
    public void checkPageTitle(String pageTitle) {
        elementHelper.checkTitle(pageTitle);
    }


    /**
     * check if a sign up form element exist with the given text parameter signUpFormElement.
     *
     * @param signUpFormElement String
     */
    public void checkSignUpFormElement(String signUpFormElement) {
        switch (signUpFormElement) {
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
            case "Phone Number Input Container":
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
            case "Phone Confirmation Pop Up":
                elementHelper.checkElementPresence(phoneConfirmationPopUp);
                break;
            default:
        }

    }

    /**
     * find the element(e.g. input container) and input the given text parameter
     *
     * @param container String
     * @param input     String
     */
    public void fillOutInputContainer(String container, String input) {
        switch (container) {
            case "Email":
                elementHelper.sendKey(emailContainer, input);
                break;
            case "Password":
                elementHelper.sendKey(passwordContainer, input);
                break;
            case "Phone Number":
                elementHelper.sendKey(phoneNumberContainer, input);
                break;
            default:
        }
    }

    /**
     * check if a checkbox element exist with the given text parameter checkboxName.
     *
     * @param checkboxName String
     */
    public void checkCheckbox(String checkboxName) {
        switch (checkboxName) {
            case "Email":
                elementHelper.click(emailCheckBox);
                break;
            case "Call":
                elementHelper.click(callCheckBox);
                break;
            case "Sms":
                elementHelper.click(smsCheckBox);
                break;
            case "Terms of Use":
                elementHelper.click(termsOfUseCheckBox);
                break;
            default:
        }
    }

    /**
     * click the element given by its intuitive name
     *
     * @param element String
     */
    public void clickElement(String element) {
        switch (element) {
            case "Sign Up Button":
                elementHelper.click(signUpButton);
                break;
            case "Login Button":
                elementHelper.click(loginButton);
                break;
        }
    }
}