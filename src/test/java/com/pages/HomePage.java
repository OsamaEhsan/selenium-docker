package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.DriverHelper;

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


    public String getSearchShirtMessage() {
        return SearchShirtMessage.getText();
    }

    public String getSearchShirtResult() {
        return SearchShirtResult.getText();
    }



}
