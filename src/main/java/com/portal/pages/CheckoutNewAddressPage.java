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

    public CheckoutNewAddressPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void setVorname()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.vorname));
        this.vorname.sendKeys("ABC");


    }

}
