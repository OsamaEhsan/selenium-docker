package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectedArticlePage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//*[@class='open-size-selector']")
    private WebElement openSizeSelector;

    @FindBy(css = ".size-system > li:nth-child(2)")
    private WebElement sizeSystem;

    @FindBy(css = "li.active-element:nth-child(9) > span:nth-child(1)")
    private WebElement size;

    @FindBy(css = "section.actions:nth-child(3) > div:nth-child(1) > form:nth-child(1) > button:nth-child(3)")
    private WebElement addToWarenkorb;

//    @FindBy(xpath = "/html/body/div[9]/div[2]/div/div/div[2]/m-button[1]")
//    @FindBy(xpath = "//*[@data-value='Jetzt sicher zur Kasse']")
//    @FindBy(xpath = "//*[@data-key='core.component.miniCart.toCheckout']")
//    @FindBy(xpath = "//*[@data-key='core.component.miniCart.toCheckout']")
//    @FindBy(xpath = "//text()[contains(.,'Jetzt sicher zur Kasse')]")



    @FindBy(xpath = "//body[@class='modal-open']/div[@id='added-modal_desktop']/div[@class='modal rightleft isScrollable']/div[@class='content']/div[@class='m-mini-cart']/div[@class='minicart_summary']/m-button[1]/button[1]")
    private WebElement jetztSicherZurKasse;

    @FindBy(xpath = ".dy-close-button > svg:nth-child(1)")
    private WebElement exitPasstDazu;

    public SelectedArticlePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectOpenSizeSelector()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.openSizeSelector));
        this.openSizeSelector.click();
    }

    public void selectSizeSystem()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.sizeSystem));
        this.sizeSystem.click();
    }

    public void selectSize()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.size));
        this.size.click();
    }

    public void selectaddToWarenkorb()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.addToWarenkorb));
        this.addToWarenkorb.click();
    }

    public void exitPasstDazu()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.exitPasstDazu));
        this.exitPasstDazu.click();
    }


    public void jetztSicherZurKasse()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.jetztSicherZurKasse));
        this.jetztSicherZurKasse.click();

    }

}
