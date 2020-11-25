package com.portal.tests;


import com.portal.pages.*;
import com.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.lang.Thread;

import java.util.concurrent.TimeUnit;

public class BuyProcessTest extends BaseTest

{

    private String urlInput;
    private String usernameInput;
    private String passwordInput;

    @BeforeTest
    @Parameters({"urlInput", "usernameInput", "passwordInput"})
    public void setupParameters(String urlInput, String usernameInput, String passwordInput)
    {
        this.urlInput = urlInput;
        this.usernameInput = usernameInput;
        this.passwordInput = passwordInput;
    }

    @Test
    public void loginPageTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo(urlInput);

        Thread.sleep(2000);

        loginPage.enterCredentials(usernameInput, passwordInput);
        loginPage.submit();

        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "loginPageTest")
    public void herrenArtikelPageTest() throws InterruptedException {
        HerrenArticlePage herrenArticlePage = new HerrenArticlePage(driver);
        Thread.sleep(2000);
        herrenArticlePage.acceptCookies();
        herrenArticlePage.selectArtikel();
    }

    @Test(dependsOnMethods = "herrenArtikelPageTest")
    public void selectedArticlePageTest() throws InterruptedException {
        SelectedArticlePage selectedArticlePage = new SelectedArticlePage(driver);
        Thread.sleep(2000);

        selectedArticlePage.selectOpenSizeSelector();
//      selectedArticlePage.selectSizeSystem();
        selectedArticlePage.selectSize();
        selectedArticlePage.selectaddToWarenkorb();
        selectedArticlePage.jetztSicherZurKasse();

    }

    @Test(dependsOnMethods = "selectedArticlePageTest")
    public void checkOutLoginPageTest() throws InterruptedException {
        CheckOutLoginPage checkOutLoginPage = new CheckOutLoginPage(driver);
        Thread.sleep(2000);

        checkOutLoginPage.selectAlsGastFortfahren();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test(dependsOnMethods = "checkOutLoginPageTest")
    public void checkOutNewAdressPageTest() throws InterruptedException {
        CheckoutNewAddressPage checkoutNewAddressPage = new CheckoutNewAddressPage(driver);
        Thread.sleep(20000);
        checkoutNewAddressPage.setVorname();


    }








}
