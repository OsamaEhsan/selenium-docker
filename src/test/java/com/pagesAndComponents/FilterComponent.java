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

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement bestellen;

    @FindBy(xpath = "(//input[@name='gender'])[1]/following-sibling::label")
    private WebElement rbgender;

    @FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement btnFilter;

    @FindBy(xpath = "//input[@id='relevance']/parent::summary")
    private WebElement dpRelevance;

    @FindBy(xpath = "(//label[contains(text(),' Preis (aufsteigend) ')])[2]")
    private WebElement valueRelevance;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement btnsize;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-17.0']/parent::li")
    private WebElement chkSize;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[1]")
    private WebElement backarrowsize;

    @FindBy(xpath = "//input[@id='max-price']")
    private WebElement txtmaxprice;

    @FindBy(xpath = "//label[@for='Schwarz']")
    private WebElement color1;

    @FindBy(xpath = "//label[@for='Grau']")
    private WebElement color2;

    @FindBy(xpath = "//span[contains(text(),' Marke ')]")
    private WebElement btnBrand;

    @FindBy(xpath = "//p[contains(text(),' Nike ')]")
    private WebElement optionBrand;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[2]")
    private WebElement btnSave;

    @FindBy(xpath = "//span[contains(text(),' Geschlecht ')]")
    private WebElement btntype;

    @FindBy(xpath = "//p[contains(text(),' männlich ')]")
    private WebElement optiontype;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[3]")
    private WebElement backarrowtype;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement bntshowResult;


    public FilterComponent(WebDriver driver) {
        super(driver);
    }

    public void setBestellen()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.bestellen));
        this.bestellen.click();

    }

    public FilterComponent FilterSearches() throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(btnFilter));
        btnFilter.click();
        this.wait.until(ExpectedConditions.visibilityOf(dpRelevance));
        dpRelevance.click();
        this.wait.until(ExpectedConditions.visibilityOf(valueRelevance));
        valueRelevance.click();
        System.out.println("Sort by Price selected");
        this.wait.until(ExpectedConditions.visibilityOf(btnsize));
        btnsize.click();
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.visibilityOf(chkSize));
        chkSize.click();
        Thread.sleep(5000);
        this.wait.until(ExpectedConditions.visibilityOf(backarrowsize));
        backarrowsize.click();
        System.out.println("Filter by Size ");
        this.wait.until(ExpectedConditions.visibilityOf(txtmaxprice));
        txtmaxprice.clear();
        txtmaxprice.sendKeys("50"+ Keys.TAB);
        System.out.println("Filter by max price ");
        this.wait.until(ExpectedConditions.visibilityOf(color1));
        Thread.sleep(3000);
        color1.click();
        Thread.sleep(3000);
        color2.click();
        System.out.println("Filter by color : Schwarz and Weiß");
        btnBrand.click();
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.visibilityOf(optionBrand));
        optionBrand.click();
        System.out.println("Filter by Brand ");
        btnSave.click();
        this.wait.until(ExpectedConditions.visibilityOf(btntype));
        btntype.click();
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.visibilityOf(optiontype));
        optiontype.click();
        backarrowtype.click();
        System.out.println("Filter by type");
        this.wait.until(ExpectedConditions.visibilityOf(bntshowResult));
        bntshowResult.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);


    }

    @FindBy(xpath = "(//span[contains(text(),'Farben: Schwarz')])")
    private WebElement clr1;

    @FindBy(xpath = "(//span[contains(text(),'Farben: Grau')])")
    private WebElement clr2;

    @FindBy(xpath = "(//span[contains(text(),'Marke: Nike')])")
    private WebElement brand;

    @FindBy(xpath = "(//span[contains(text(),'Geschlecht: männlich')])")
    private WebElement type;

    public boolean isAllFilterdDisplayed() {

        if(clr1.isDisplayed() && clr2.isDisplayed() && brand.isDisplayed() && type.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }

    }








}
