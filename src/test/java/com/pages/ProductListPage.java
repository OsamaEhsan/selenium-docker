package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.DriverHelper;

public class ProductListPage extends DriverHelper {




    @FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement FilterButton;

    @FindBy(xpath = "//label[@for='Blau']")
    private WebElement BlueColorFilter;


    @FindBy(xpath = "//label[@data-value='Ergebnisse anzeigen']")
    private WebElement ShowResultBar;


    @FindBy(xpath = "//label[@for='delete-all-filters']")
    private WebElement ClearAllFilter;


    @FindBy(xpath = "//span[contains(text(),'Farben: Blau')]")
    private WebElement ColorBlueFilter;




    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public ProductListPage clickOnFilterButton()
    {
        FilterButton.click();
        return PageFactory.initElements(getWebDriver(),ProductListPage.class);
    }


    public ProductListPage clickOnBlueColorFilter()
    {
        BlueColorFilter.click();
        waitForJSandJQueryToLoad();
        return PageFactory.initElements(getWebDriver(),ProductListPage.class);
    }


    public ProductListPage clickOnShowResultBar()
    {
        ShowResultBar.click();
        return PageFactory.initElements(getWebDriver(),ProductListPage.class);
    }


    public boolean isAllClearFilterDisplayed()
    {
        boolean result = ClearAllFilter.isDisplayed();
        return result;
    }


    public boolean isBlueColorFilterDisplayed()
    {
        boolean result = ColorBlueFilter.isDisplayed();
        return result;
    }





}
