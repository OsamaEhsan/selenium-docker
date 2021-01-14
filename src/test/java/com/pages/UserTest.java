package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UserTest {

	static WebDriver driver;
	public UserTest() {
		
	}
	public static void addWait(int msec) {
		try {
			driver.wait(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.deichmann.com/de-de/");
		
		driver.findElements(By.className("link-name")).get(1).click();
		driver.findElement(By.xpath("//*[@id=\"NavigationBarSlot\"]/nav/div/ul[2]/li[3]/label/a")).click();
		driver.findElement(By.xpath("//*[@id=\"NavigationBarSlot\"]/nav/div/ul[2]/li[3]/ul/li[3]/div[6]/ul/li[3]/div[3]/label/a")).click();
		addWait(2000);
		new Actions(driver).moveByOffset(10,600).click().build().perform(); 
		driver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/h2/label/span[2]/span[1]")).click();
		//price
		driver.findElement(By.id("max-price")).sendKeys("50");
		//sort by price
		driver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/summary"));
		driver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/ul/li[4]/label"));
		//price check last element
		List<WebElement> products = driver.findElements(By.className("prices m-price-list"));
		String str_price = products.get(products.size()-1).getText();
		int price = Integer.parseInt(str_price.split(",")[0].replace(" ", ""));
		if (price < 50) {
			System.out.println("price filter is correct");
		}
		else{
			System.out.println("price filter is incorrect");
		}
		//sorting filter check last and 2nd last element
		String str_price2 = products.get(products.size()-2).getText();
		int price2 = Integer.parseInt(str_price.split(",")[0].replace(" ", ""));
		if (price2 <= price) {
			System.out.println("sorting filter is correct");
		}
		else{
			System.out.println("sorting filter is incorrect");
		}
		//adding to wishlist
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000)");
		
		
	}
	

}
