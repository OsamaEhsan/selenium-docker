package com.portal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutNewAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

   @FindBy(xpath = "//*[@placeholder='Vorname']")
    private WebElement vorname;

   @FindBy(xpath = "//*[@placeholder='Nachname']")
    private WebElement nachname;

    @FindBy(xpath = "//*[@placeholder='E-Mail']")
    private WebElement email;

    @FindBy(xpath = "//*[@placeholder='Straße']")
    private WebElement strasse;

    @FindBy(xpath = "//*[@placeholder='Hausnummer']")
    private WebElement hausnummer;

    @FindBy(xpath = "//*[@placeholder='Postleitzahl']")
    private WebElement postleizahl;

    @FindBy(xpath = "//*[@placeholder='Stadt']")
    private WebElement stadt;

    @FindBy(xpath = "//*[@data-value='Wunschadresse']")
    private WebElement wunschadresse;

    @FindBy(xpath = "//*[@class='checkmark']")
    private WebElement datenschutzbestimmung;

    @FindBy(xpath = "//*[@data-key='myAccount.component.formRegistration.continueToDelivery']")
    private WebElement continuetodelivery;

    @FindBy(xpath = "//*[@for='create-account']")
    private WebElement kundenKontoAnlegen;


    public CheckoutNewAddressPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void setWunschadresse()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.wunschadresse));
        this.wunschadresse.click();

    }

    public void setVorname()
    {
       this.wait.until(ExpectedConditions.visibilityOf(this.vorname));
        this.vorname.click();
        this.vorname.sendKeys("Vorname");

    }

    public void setNachname()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.nachname));
        this.nachname.sendKeys("Nachname");

    }

    public void setEmail()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.email));
        this.email.sendKeys("mail@mail.com");

    }

    public void setStrasse()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.strasse));
        this.strasse.sendKeys("Dahler Str.");

    }

    public void setHausnummer()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.hausnummer));
        this.hausnummer.sendKeys("54");

    }

    public void setPostleitzahl()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.postleizahl));
        this.postleizahl.sendKeys("42389");

    }

    public void setStadt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.stadt));
        this.stadt.sendKeys("Wuppertal");

    }

    public void setDatenschutzbestimmung()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.datenschutzbestimmung));
        this.datenschutzbestimmung.click();

    }

    public void setKundenKontoAnlegen()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.kundenKontoAnlegen));
        this.kundenKontoAnlegen.click();

    }

    public void setContinuetodelivery()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.continuetodelivery));
        this.continuetodelivery.click();

    }

}
