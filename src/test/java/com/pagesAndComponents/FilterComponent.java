package com.pagesAndComponents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.DriverHelper;

public class FilterComponent extends DriverHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement bestellen;

    @FindBy(xpath = "(//input[@name='gender'])[1]/following-sibling::label")
    private WebElement rbgender;

    @FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement btnFilter;

    @FindBy(xpath = "//input[@id='relevance']/parent::summary")
    private WebElement filterSortierenRelevanz;

    @FindBy(xpath = "(//label[contains(text(),' Preis (aufsteigend) ')])[2]")
    private WebElement filterSortierenPreisAufsteigend;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement filterGroesse;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-17.0']/parent::li")
    private WebElement groesseEUSiebzhen;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[1]")
    private WebElement filterGroesseBackArrow;

    @FindBy(xpath = "//input[@id='max-price']")
    private WebElement filterGroesseMaxPreis;

    @FindBy(xpath = "//label[@for='Schwarz']")
    private WebElement filterFarbe1;

    @FindBy(xpath = "//label[@for='Grau']")
    private WebElement filterFarbe2;

    @FindBy(xpath = "//span[contains(text(),' Marke ')]")
    private WebElement filterBrand;

    @FindBy(xpath = "//p[contains(text(),' Nike ')]")
    private WebElement filterBrandNike;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[2]")
    private WebElement saveFilterBrand;

    @FindBy(xpath = "//span[contains(text(),' Geschlecht ')]")
    private WebElement filterGeschlescht;

    @FindBy(xpath = "//p[contains(text(),' männlich ')]")
    private WebElement filterGeschleschtMaennlich;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[3]")
    private WebElement filterGeschleschtBackarrow;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement filterErgebnisseAnzeigen;



    //Set driver

    public FilterComponent(WebDriver driver) {
        super(driver);
    }


    //Methods

    public FilterComponent setBestellen()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.bestellen));
        this.bestellen.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilter()
    {
        btnFilter.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterSortierenBeiRelevanz()
    {
        filterSortierenRelevanz.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterSortierenBeiPreisAufsteigend() throws InterruptedException {
        filterSortierenPreisAufsteigend.click();
        System.out.println("Sort by Price Aufsteigend selected");
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGroesse() throws InterruptedException {
       // this.wait.until(ExpectedConditions.visibilityOf(filterGroesse));
        filterGroesse.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseOnFilterGroesseSiebzhenEU() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(groesseEUSiebzhen));
        groesseEUSiebzhen.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGroesseBackArrow()
    {
        //this.wait.until(ExpectedConditions.visibilityOf(filterGroesseBackArrow));
        filterGroesseBackArrow.click();
        System.out.println("Filtered by Size ");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGroesseMaxPreisFuenfzig()
    {
        //this.wait.until(ExpectedConditions.visibilityOf(filterGroesseMaxPreis));
        filterGroesseMaxPreis.clear();
        filterGroesseMaxPreis.sendKeys("50"+ Keys.TAB);
        System.out.println("Filter by max price ");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterFarbeWeiss() throws InterruptedException {
       // this.wait.until(ExpectedConditions.visibilityOf(filterFarbe1));
        Thread.sleep(3000);
        filterFarbe1.click();
        System.out.println("Filter by color : Weiß");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterFarbeSchwarz() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(filterFarbe2));
        Thread.sleep(3000);
        filterFarbe2.click();
        System.out.println("Filter by color : Schwarz");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterBrand() throws InterruptedException {
        filterBrand.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseFilterBrandNike() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(filterBrandNike));
        filterBrandNike.click();
        Thread.sleep(3000);
        System.out.println("Filter by Brand Nike");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent saveFilterBrand() throws InterruptedException {
        saveFilterBrand.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGeschlescht() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(filterGeschlescht));
        filterGeschlescht.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseOnFilterGeschleschtMaennlich() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(filterGeschleschtMaennlich));
        filterGeschleschtMaennlich.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGeschleschtBackarrow() throws InterruptedException {
        filterGeschleschtBackarrow.click();
        System.out.println("Filter by Geschlescht Männlich");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterErgebnisseAnzeigen() throws InterruptedException {
       // this.wait.until(ExpectedConditions.visibilityOf(filterErgebnisseAnzeigen));
        filterErgebnisseAnzeigen.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }












}
