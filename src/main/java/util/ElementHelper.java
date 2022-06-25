package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
    }

    /**
     * find the element
     *
     * @param selector By
     * @return element
     */
    public WebElement findElement(By selector) {
        WebElement element = presenceElement(selector);
        scrollToElement(element);
        return element;
    }

    /**
     * find the elements of same type and return them in a list
     *
     * @param selector By
     * @return elements
     */
    public List<WebElement> findElements(By selector) {
        List<WebElement> elements = presenceElements(selector);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * find the element and click it
     *
     * @param selector By
     */
    public void click(By selector) {
        findElement(selector).click();
    }

    /**
     * find the element and clicks it
     *
     * @param element WebElement
     */
    public void click(WebElement element) {
        scrollToElement(element);
        element.click();
    }

    /**
     * find the element(e.g. input container) and input the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public void sendKey(By selector, String text) {
        findElement(selector).sendKeys(text);
    }

    /**
     * find the element and get the visible text of this element
     *
     * @param selector By
     */
    public String getText(By selector) {
        return findElement(selector).getText();
    }

    /**
     * compare the visible text of the element with the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public boolean checkElementText(By selector, String text) {
        return wait.until(ExpectedConditions.textToBe(selector, text));
    }

    /**
     * check if the visible text of the element contains the given text parameter
     *
     * @param selector By
     * @param text     String
     * @return boolean
     */
    public boolean checkElementTextContains(By selector, String text) {
        boolean isFound = false;
        WebElement element = findElement(selector);
        if (element.getText().contains(text)) {
            isFound = true;
        }
        Assert.assertTrue(isFound);
        return isFound;
    }

    /**
     * check if the element is visible on screen
     *
     * @param selector By
     */
    public void checkElementVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOf(findElement(selector)));
    }

    /**
     * check if the element is present on the DOM of a page
     * does not throw an exception
     * @param selector By
     * @return boolean
     */
    public boolean checkElementPresenceBool(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * check if the element is present on the DOM of a page
     *
     * @param selector By
     */
    public void checkElementPresence(By selector) {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    /**
     * check if the title of a page is equals to the given text parameter
     *
     * @param text String
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * Get the value of the given attribute of the element.
     *
     * @param selector By
     * @param attr     String
     * @return WebElement
     */
    public String getAttribute(By selector, String attr) {
        return findElement(selector).getAttribute(attr);
    }

    /**
     * Get the value of the given attribute of the element.
     *
     * @param element  WebElement
     * @param attr     String
     * @return WebElement
     */
    public String getAttribute(WebElement element, String attr) {
        return element.getAttribute(attr);
    }

    /**
     * Get the value of the given attribute of the element and check
     * if it is equal to the given parameter text
     *
     * @param selector By
     * @param attr     String
     * @param text     String
     */
    public void checkAttribute(By selector, String attr, String text) {
        Assert.assertEquals(getAttribute(selector, attr), text);
    }

    /**
     * find the elements of same type and click the element with
     * the text matching the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public void clickElementWithText(By selector, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * find the elements of same type and hover over the element with
     * the text matching the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public void hoverOverElementWithText(By selector, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            System.out.println(element.getText());
            if (element.getText().contains(text)) {
                action.moveToElement(element).perform();
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * find the element and hover over the element
     *
     * @param selector By
     */
    public void hoverOverElement(By selector) {
        WebElement element = findElement(selector);
        action.moveToElement(element).perform();
    }

    /**
     * find the elements of same type and check if an element with
     * the text containing the given text parameter exists
     *
     * @param selector By
     * @param text     String
     */
    public WebElement checkElementWithText(By selector, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(selector);
        WebElement desElement = null;
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                desElement = element;
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound);
        return desElement;
    }

    /**
     * find the elements of same type and check if an element with
     * the text containing the given text parameter exists
     * this method does not throw an exception if an element is not found
     * but simply returns a boolean false
     *
     * @param selector By
     * @param text     String
     * @return boolean
     */
    public boolean checkElementWithTextBool(By selector, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * list the elements of same type and find the element with
     * the text matching the given text parameter, then input the text
     * given with the parameter text2
     *
     * @param selector By
     * @param text     String
     * @param text2    String
     */
    public void sendKeyElementWithText(By selector, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * check if the element is present on the DOM of a page
     *
     * @param selector By
     * @return WebElement
     */
    public WebElement presenceElement(By selector) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    /**
     * check if the element list is present on the DOM of a page
     *
     * @param selector By
     * @return WebElement list
     */
    public List<WebElement> presenceElements(By selector) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    /**
     * scroll to the element and place it in the middle of the screen
     *
     * @param element WebElement
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
        wait.withTimeout(1000, TimeUnit.MILLISECONDS);
    }
}
