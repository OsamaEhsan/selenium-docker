package com.pagesAndComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.DriverHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends DriverHelper {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@id,'search') and @type='search']")
    private WebElement SearchTextField;

    @FindBy(id = "icon-search")
    private WebElement SearchIcon;

    @FindBy(xpath = "//h1[@class='message-pipe']")
    private WebElement SearchShirtMessage;

    @FindBy(xpath = "//div/p[@class='message-pipe' and @data-value='Ergebnisse']")
    private WebElement SearchShirtResult;

    @FindBy(xpath = "//label[@title='Schuhe']")
    private WebElement SubMenuShoesLink;
    //label[@for='submenu-women-shoesLink']/a

    @FindBy(xpath = "//label[@title='Schnürboots']/a")
    private WebElement TieBootLink;

    @FindBy(xpath = "//section/article[1]/a")
    private WebElement firstBoot;

    @FindBy(xpath = "//span[@class='link-name' and text()='Damen']")
    private WebElement DamenMainMenu;

    @FindBy(xpath = "//span[@data-value='Wähle deine Größe']")
    private WebElement ChooseSize;

    @FindBy(xpath = "//div[@class='m-size-selection']/ul[2]/li[1]")
    private WebElement SelectFirstSize;

    @FindBy(xpath = "(//form[contains(@class,'m-add-to-cart')])[1]")
    private WebElement AddToCartButton;

    @FindBy(xpath = "(//button/span[contains(text(),' Jetzt sicher zur Kasse ')])[2]")
    private WebElement SafelyCheckoutButton;

    @FindBy(xpath = "//input[@id='search0']")
    private WebElement textSearch;

    @FindBy(xpath = "//span[text()='Schwarze lauf']/strong[text()='lernschuhe']")
    private WebElement searchOption;

    @FindBy(xpath = "//span[text()='Stiefel']")
    private WebElement searchOption1;

    @FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement btnFilter;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement btnsize;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-39.0']/parent::li")
    private WebElement chkSize1;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[1]")
    private WebElement backarrowsize;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement bntshowResult;


    public HomePage mouseHoverOnShoesSubMenu() {

        Actions actions = new Actions(driver);
        actions.moveToElement(SubMenuShoesLink).build().perform();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }



    public HomePage clickOnTieBootLink() throws InterruptedException {
        TieBootLink.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(DamenMainMenu).build().perform();
        Thread.sleep(2000);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnFirstShoeImage() throws InterruptedException {
        firstBoot.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnChooseSize() throws InterruptedException {
        ChooseSize.click();
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage selectFirstShoeSize() throws InterruptedException {
        SelectFirstSize.click();
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }



    public HomePage clickOnAddToCart() throws InterruptedException {
        AddToCartButton.click();
        Thread.sleep(1000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnSafelyCheckoutButton() throws InterruptedException {
        SafelyCheckoutButton.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }




    public HomePage enterSearchKeyword(String searchKey) throws InterruptedException {
        SearchTextField.clear();
        SearchTextField.sendKeys(searchKey);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnSearchIcon() throws InterruptedException {
        //SearchIcon.click();
        Thread.sleep(2000);
        SearchTextField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WaitUntilWebElementIsVisible(SearchShirtMessage);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage enterSearchCriteriaAndChooseResult(String Criteria) {

        this.wait.until(ExpectedConditions.visibilityOf(textSearch));
        textSearch.click();
        textSearch.sendKeys(Criteria);
        System.out.println("Search text entered");
        this.wait.until(ExpectedConditions.visibilityOf(searchOption));
        searchOption.click();
        if(driver.findElement(By.xpath("//h1[text()=' Suche: \"Schwarze lauflernschuhe\" ']")).isDisplayed())
        {
            System.out.println("Searching applied");
        }
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage enterSearchCriteria1(String Criteria) throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(textSearch));
        textSearch.click();
        textSearch.sendKeys(Criteria);
        System.out.println("Search text entered");
        this.wait.until(ExpectedConditions.visibilityOf(searchOption1));
        searchOption1.click();

        btnFilter.click();
        this.wait.until(ExpectedConditions.visibilityOf(btnsize));
        btnsize.click();
        chkSize1.click();
        Thread.sleep(5000);
        this.wait.until(ExpectedConditions.visibilityOf(backarrowsize));
        backarrowsize.click();
        this.wait.until(ExpectedConditions.visibilityOf(bntshowResult));
        bntshowResult.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public String getSearchShirtMessage() {
        return SearchShirtMessage.getText();
    }

    public String getSearchShirtResult() {
        return SearchShirtResult.getText();
    }



}
