package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZahlungsMethodePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@class='payment-details']")
    private WebElement paypal;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement zahlungsMethodeVerwenden;

    public ZahlungsMethodePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void setPaypal()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.paypal));
        this.paypal.click();

    }

    public void setZahlungsMethodeVerwenden()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.zahlungsMethodeVerwenden));
        this.zahlungsMethodeVerwenden.click();

    }





}
