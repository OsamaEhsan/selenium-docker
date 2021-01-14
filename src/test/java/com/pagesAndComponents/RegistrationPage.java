package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.DriverHelper;

public class RegistrationPage extends DriverHelper{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement bestellen;

    @FindBy(xpath = "(//input[@name='gender'])[1]/following-sibling::label")
    private WebElement rbgender;

    @FindBy(xpath = "(//input[@name='firstName'])[1]")
    private WebElement txtfirstname;

    @FindBy(xpath = "(//input[@name='lastName'])[1]")
    private WebElement txtlastname;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    private WebElement txtemail;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    private WebElement txtpassword;

    @FindBy(xpath = "(//input[@name='line1'])[1]")
    private WebElement txtline1;

    @FindBy(xpath = "(//input[@name='line2'])[1]")
    private WebElement txtline2;

    @FindBy(xpath = "(//input[@name='postalCode'])[1]")
    private WebElement txtpostalcode;

    @FindBy(xpath = "(//input[@name='town'])[1]")
    private WebElement txtcity;

    @FindBy(xpath = "(//input[@name='privacyPolicyConfirmed'])[1]/parent::label")
    private WebElement txtppolicy;

    @FindBy(xpath = "//button[@data-value='Registrieren']")
    private WebElement btnRegister;

    @FindBy(xpath = "//a[contains(@data-key,'hasNoAccount')]")
    private WebElement btnNewAcount;

    @FindBy(xpath = "//button[@class='message-pipe button']")
    private WebElement btnOK;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void setBestellen()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.bestellen));
        this.bestellen.click();

    }

    public RegistrationPage clickONOK() {

        btnOK.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage clickOnNewAccount() {

        btnNewAcount.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage selectGender() {

        rbgender.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterFirstname(String firstname) {

        txtfirstname.click();
        txtfirstname.sendKeys(firstname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterLastName(String lastname) {

        txtlastname.click();
        txtlastname.sendKeys(lastname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }
    public RegistrationPage enterEmail(String email) {

        txtemail.click();
        txtemail.sendKeys(email);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterPwd(String pwd) {

        txtpassword.click();
        txtpassword.sendKeys(pwd);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterStreet(String Street) {

        txtline1.click();
        txtline1.sendKeys(Street);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterHouseNumber(String Housenumber) {

        txtline2.click();
        txtline2.sendKeys(Housenumber);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterPostalCode(String Postcode) {

        txtpostalcode.click();
        txtpostalcode.sendKeys(Postcode);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }
    public RegistrationPage enterCity(String City) {

        txtcity.click();
        txtcity.sendKeys(City);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage selectPolicy() {

        txtppolicy.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }
    public RegistrationPage ClickOnRegister() throws InterruptedException {

        btnRegister.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }







}
