package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import com.utils.DriverHelper;

public class LoginPage extends DriverHelper {

    @FindBy(id = "input_1")
    private WebElement usernameTxt;

    @FindBy(id = "input_2")
    private WebElement passowrdTxt;

    @FindBy(className = "credentials_input_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='shortcuts']/map[2]/a")
    private WebElement AccountIcon;

    //div[@class='shortcuts']//a/span[@data-value='Mein Account']
    //div[@class='shortcuts']/map[2]/a
    //a/span[contains(text(),'Mein Account')]
    @FindBy(xpath = "//button[contains(text(),'Anmelden')]")
    private WebElement RegisterButton;

    @FindBy(xpath = "//div/input[@type='email' and @placeholder='E-Mail-Adresse']")
    private WebElement EmailAddress;

    @FindBy(xpath = "//div/input[@type='password' and @placeholder='Passwort']")
    private WebElement Passoword;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Anmelden')]")
    private WebElement SubmitButton;

    @FindBy(className = "logout")
    private WebElement LogoutLink;

    @FindBy(xpath = "//h1[contains(text(),'Mein Konto')]")
    private WebElement MyAccount;

    @FindBy(xpath = "//div[@class='m-login']")
    private WebElement LoginForm;

    @FindBy(xpath = "//h1[contains(text(),'Anmelden')]")
    private WebElement RegisterTextAtLoginForm;

    @FindBy(xpath = "//button[@data-key='core.component.cookieConsent.button']")
    private WebElement CookiesOkButton;


    protected WebDriverWait wait;



/*    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }*/

    public LoginPage(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }



    public LoginPage mouseHoverOnRegisterIcon() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", AccountIcon);
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }


    public LoginPage clickOnRegisterButton() {
        RegisterButton.click();
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public LoginPage enterEmailAddress(String emailAddress) {
        EmailAddress.clear();
        EmailAddress.sendKeys(emailAddress);
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public LoginPage enterPassword(String password) {
        Passoword.clear();
        Passoword.sendKeys(password);
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public LoginPage clickOnLoginButton() {
        SubmitButton.click();
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public LoginPage loginIntoApplication(String emailAddress, String password) throws InterruptedException {

        mouseHoverOnRegisterIcon();
        //clickOnRegisterButton();
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickOnLoginButton();
        waitForInvisibility(LoginForm, 5);
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }




    public void waitForInvisibility(WebElement webElement, int maxSeconds) {
        Long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {}
        } catch (Exception e) {
            return;
        }
    }



    public LoginPage verifyMyAccountIsDisplayed()
    {
        AccountIcon.click();
        boolean result = MyAccount.isDisplayed();
        System.out.println("Result is: " + result);
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }


    public boolean WaitUntilWebElementIsInvisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is NOT visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void signOutFromApplication() throws InterruptedException
    {
        mouseHoverOnRegisterIcon2();
        LogoutLink.click();
    }



    public LoginPage mouseHoverOnRegisterIcon2() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(AccountIcon).build().perform();

        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public void clickOnCookiesOkayButton()
    {
        CookiesOkButton.click();
    }

}
