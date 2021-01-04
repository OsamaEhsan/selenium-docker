//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.utils;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductListPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;



public abstract class DriverTestCase {
    public PropertyReader propertyReader;
    public LoginPage loginPage;
    public HomePage homepage;
    public ProductListPage productListPage;
    private WebDriver driver;



    public DriverTestCase() {
    }

    @BeforeClass
    public void setUp(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.1.3 / hostname

        propertyReader = new PropertyReader();

        String host = "localhost";
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        String applicationUrl = propertyReader.readApplicationFile("App_URL");
        getWebDriver().get(applicationUrl);
        //JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("return document.readyState").toString().equals("complete");


        loginPage = PageFactory.initElements(driver,LoginPage.class);
        homepage= PageFactory.initElements(driver,HomePage.class);
        productListPage= PageFactory.initElements(driver,ProductListPage.class);
    }

    @AfterClass
    public void tearDowm() {
        this.driver.close();
        this.driver.quit();
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public PropertyReader getProperty() {
        return this.propertyReader;
    }

    public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            long range = (long)aEnd - (long)aStart + 1L;
            long fraction = (long)((double)range * aRandom.nextDouble());
            int randomNumber = (int)(fraction + (long)aStart);
            return randomNumber;
        }
    }

    public String randomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);

        for(int i = 0; i < len; ++i) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }

        return sb.toString();
    }

    static enum DriverType {
        Firefox,
        IE,
        Chrome;

        private DriverType() {
        }
    }
}
