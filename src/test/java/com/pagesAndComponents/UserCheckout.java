package com.pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


import com.utils.DriverHelper;

public class UserCheckout extends DriverHelper {

    @FindBy(xpath = "/html/body/div[1]/header/div[2]")
    private WebElement herrenLink;

    
    @FindBy(xpath = "//*[@id=\\\"NavigationBarSlot\\\"]/nav/div/ul[2]/li[3]/label/a")
    private WebElement accesoriesLink;

    @FindBy(xpath = "//*[@id=\\\"NavigationBarSlot\\\"]/nav/div/ul[2]/li[3]/ul/li[3]/div[6]/ul/li[3]/div[3]/label/a")
    private WebElement kofferLink;
    
	 @FindBy(xpath = "//*[@id=\\\"anchor_productGrid\\\"]/div[1]/section[1]/h2/label/span[2]/span[1]")
	  private WebElement filterLink;
	 
	 @FindBy(id = "max-price")
	 private WebElement pricebox;
		
	@FindBy(xpath = "//*[@id=\\\"anchor_productGrid\\\"]/div[1]/section[1]/form/section[1]/details/summary")
	private WebElement sortFilter;
		 
	@FindBy(xpath = "//*[@id=\\\"anchor_productGrid\\\"]/div[1]/section[1]/form/section[1]/details/ul/li[4]/label")
	private WebElement aufsteigendSort;		
	 
	@FindBy(css="wish-list-button secondary icon small")
	private List<WebElement> wishlistIcons;
	
	@FindBy(xpath = "/html/body/div[1]/header/div[2]/div[3]/map[1]/a")
	private WebElement  filialeFinden;

	@FindBy(id = "searchTerm")
	 private WebElement searchBox;
	
	@FindBy(className = "m-store-card")
	 private List<WebElement> storeCards;
	
	
    protected WebDriverWait wait;

    public UserCheckout(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }



    public UserCheckout clickOnHerrenLink() throws InterruptedException {

        herrenLink.click();
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }


    public UserCheckout SelectMenuItem() throws InterruptedException{
        accesoriesLink.click();
        kofferLink.click();
        new WebDriverWait(driver, 10);
        new Actions(driver).moveByOffset(10,600).click().build().perform(); 
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }

    public UserCheckout SelectFilterandSetPrice(String price) throws InterruptedException{
        filterLink.click();
        pricebox.clear();
        pricebox.sendKeys(price);
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }
    
    public UserCheckout SortFilterSelect() throws InterruptedException{
        sortFilter.click();
        aufsteigendSort.click();
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }
    
    public boolean LastItemPriceCheck() {
    	List<WebElement> products = driver.findElements(By.className("prices m-price-list"));
		String str_price = products.get(products.size()-1).getText();
		int price = Integer.parseInt(str_price.split(",")[0].replace(" ", ""));
		if (price < 50) {
			return true;
		}
		return false;
    }
    
    public boolean LastTwoItemPriceCheck() {
    	List<WebElement> products = driver.findElements(By.className("prices m-price-list"));
		String str_price = products.get(products.size()-1).getText();
		int price = Integer.parseInt(str_price.split(",")[0].replace(" ", ""));
    	String str_price2 = products.get(products.size()-2).getText();
		int price2 = Integer.parseInt(str_price.split(",")[0].replace(" ", ""));
		if (price2 <= price) {
			return true;
		}
		return false;
    }
    
    public UserCheckout AddToWishList() throws InterruptedException{
    	
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000)");
		wishlistIcons.get(wishlistIcons.size()-1).click();
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }
    
    public UserCheckout SelectFilialeFinden() throws InterruptedException{
    	
    	filialeFinden.click();
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }

    public UserCheckout EnterSearchTerm(String term) throws InterruptedException{
    	
    	searchBox.clear();
    	searchBox.sendKeys(term);
        return PageFactory.initElements(getWebDriver(), UserCheckout.class);
    }
    public boolean checkNumberOfStores() {
    	if (storeCards.size() >= 4)
			return true;
    	return false;
    }
    


}
