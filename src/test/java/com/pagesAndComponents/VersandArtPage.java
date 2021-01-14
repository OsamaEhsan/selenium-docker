package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VersandArtPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@class='card']")
    private WebElement dhl;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement versandArtVerwenden;

    public VersandArtPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void setDhl()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.dhl));
        this.dhl.click();

    }

    public void setVersandArtVerwenden()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.versandArtVerwenden));
        this.versandArtVerwenden.click();

    }





}
