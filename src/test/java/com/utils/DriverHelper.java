package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DriverHelper {


    protected WebDriver driver;

    public WebDriverWait wait;


    public DriverHelper(WebDriver webdriver) {
        driver = webdriver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getWebDriver(){
        return driver;
    }


    public void Log(String logMsg){
        System.out.println(logMsg);
    }

    public By ByLocator(String locator) {
        By result = null;

        if (locator.startsWith("//")) {
            result = By.xpath(locator);
        } else if (locator.startsWith("css=")) {
            result = By.cssSelector(locator.replace("css=", ""));
        } else if (locator.startsWith("#")) {
            result = By.name(locator.replace("#", ""));

        } else if (locator.startsWith("link=")) {
            result = By.linkText(locator.replace("link=", ""));
        }

        else if(locator.startsWith("class=")) {
            result=By.className(locator.replace("class=", ""));
        }
        else if(locator.startsWith("name=")) {
            result=By.name(locator.replace("name=", ""));
        }

        else if(locator.startsWith("id=")) {
            result=By.id(locator.replace("id=", ""));
        }
        else if(locator.startsWith("(")) {
            result = By.xpath(locator);
        }
        else {
            result = By.id(locator);
        }

        return result;
    }


    public Boolean isElementPresent(String locator) {
        Boolean result = false;
        try {
            getWebDriver().findElement(ByLocator(locator));
            result = true;
        } catch (Exception ex) {

        }

        return result;
    }


    public Boolean isElementDisplayed(String locator) {

        Boolean result = false;
        try {
            getWebDriver().findElement(ByLocator(locator)).isDisplayed();
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }


    public void WaitForElementPresent(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void WaitForElementNotPresent(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (!isElementPresent(locator)) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void WaitForElementEnabled(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                if (getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void WaitForElementNotEnabled(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                if (!getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void WaitForElementVisible(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                if (getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void WaitForElementNotVisible(String locator, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                if (!getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouseOver(WebElement el){
        //this.WaitForElementPresent(locator, 50);
        this.WaitForElementPresent1(el, 50);
        //WebElement el = getWebDriver().findElement(ByLocator(locator));

        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(el).build().perform();
    }



    public void WaitForElementPresent1(WebElement el, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (isElementPresent1(el)) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public Boolean isElementPresent1(WebElement el) {
        Boolean result = false;
        try {
            el.isDisplayed();
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }

    public void mouseDoubleClick(String locator){
        this.WaitForElementPresent(locator, 50);
        WebElement el = getWebDriver().findElement(ByLocator(locator));
        Actions builder = new Actions(getWebDriver());
        builder.doubleClick(el).perform();
    }

    public void dragAndDrop(String draggable, String to)
    {
        WebElement elDraggable = getWebDriver().findElement(ByLocator(draggable));
        WebElement todrag = getWebDriver().findElement(ByLocator(to));
        Actions builder = new Actions(getWebDriver());
        builder.dragAndDrop(elDraggable, todrag).perform();
    }





    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }


    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)getWebDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)getWebDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }



}
