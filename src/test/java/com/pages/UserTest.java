package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTest {

	static WebDriver driver;
	public UserTest() {
		
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.deichmann.com/de-de/");
		
		driver.findElements(By.className("link-name")).get(1).click();
	}

}
