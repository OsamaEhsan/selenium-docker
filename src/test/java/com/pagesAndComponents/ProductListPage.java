package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.DriverHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "(//article/a)[2]")
    private WebElement SecondShoes;

    @FindBy(xpath = "(//button[@type='submit' and text()='In den Warenkorb'])[1]")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//span[@data-key='productDetailPage.component.productPageTemplate.setSize']")
    private WebElement btnSelectSize;

    @FindBy(xpath = "//span[text()=' 17 ']")
    private WebElement ShoesSize;

    @FindBy(xpath = "(//m-button[@data-key='core.component.miniCart.showCart'])[2]")
    private WebElement btnShowCart;




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

    public ProductListPage AddSecondShoesInCart()
    {
        SecondShoes.click();
       // this.wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnSelectSize.click();
        ShoesSize.click();
        btnAddToCart.click();
        System.out.println("Second Shoes added to Cart");
        this.wait.until(ExpectedConditions.visibilityOf(btnShowCart));
        btnShowCart.click();
        return PageFactory.initElements(getWebDriver(),ProductListPage.class);
    }



}
