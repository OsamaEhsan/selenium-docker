package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerrenArticlePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "body > div.m-root > section > section > button")
    private WebElement cookies;

    @FindBy(css = "#product-list > article:nth-child(1) > a")
    private WebElement artikel;

    public HerrenArticlePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.cookies));
        this.cookies.click();
    }

    public void selectArtikel()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.artikel));
        this.artikel.click();
    }

}
