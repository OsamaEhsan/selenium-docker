package com.pagesAndComponents;

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

    @FindBy(xpath = "(//span[contains(text(),'Farben: Schwarz')])")
    private WebElement filterFarbeSetSchwarz;

    @FindBy(xpath = "(//span[contains(text(),'Farben: Grau')])")
    private WebElement filterFarbeSetGrau;

    @FindBy(xpath = "(//span[contains(text(),'Marke: Nike')])")
    private WebElement filterMarkeSetNike;

    @FindBy(xpath = "(//span[contains(text(),'Geschlecht: männlich')])")
    private WebElement filterGeschleschtSetMaennlich;

    @FindBy(xpath = "(//article//section[@class='prices m-price-list']/strong)[1]")
    private WebElement firstArticlePreis;

    @FindBy(xpath = "(//article//section[@class='prices m-price-list']/strong)[2]")
    private WebElement secondArticlePrice;

    @FindBy(xpath = "(//input[@name='addToWhishlist']/following-sibling::button)[1]")
    private WebElement wunschListForFirstArtikel;

    @FindBy(xpath = "(//input[@name='addToWhishlist']/following-sibling::button)[1]")
    private WebElement wunschListForSecondArtikel;


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

    public boolean isAllFilterdDisplayed() {

        if(filterFarbeSetSchwarz.isDisplayed() && filterFarbeSetGrau.isDisplayed() && filterMarkeSetNike.isDisplayed() && filterGeschleschtSetMaennlich.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    public boolean isFirstpriceIsLessorThenSecond() {

        String fp= firstArticlePreis.getText();
        String sp= secondArticlePrice.getText();
        String[] fp1= fp.split(" ");
        String[] sp1= sp.split(" ");

        String fp2=fp1[0].replace(",","");
        String sp2=sp1[0].replace(",","");

        if(Integer.valueOf(fp2)<Integer.valueOf(sp2))
        {
            return true;

        }
        else
        {
            return false;
        }
    }

    public ProductListPage addFirstArtikelToWunschList()
    {
        wunschListForFirstArtikel.click();
        System.out.println("First Shoes added to wishlist");
        return PageFactory.initElements(getWebDriver(),ProductListPage.class);
    }



}
