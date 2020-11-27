package com.portal.tests;


import com.portal.pages.*;
import com.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.lang.Thread;

import java.util.concurrent.TimeUnit;

public class BuyProcessTest2 extends BaseTest

{

    private String urlInput;
    private String usernameInput;
    private String passwordInput;

    @BeforeTest
    @Parameters({"urlInput"})
    public void setupParameters(String urlInput)
    {
        this.urlInput = urlInput;
    }

    @Test
    public void loginPageTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo(urlInput);

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
        checkoutNewAddressPage.setWunschadresse();
        checkoutNewAddressPage.setVorname();
        checkoutNewAddressPage.setNachname();
        checkoutNewAddressPage.setEmail();
        checkoutNewAddressPage.setStrasse();
        checkoutNewAddressPage.setHausnummer();
        checkoutNewAddressPage.setPostleitzahl();
        checkoutNewAddressPage.setStadt();
       // checkoutNewAddressPage.setDatenschutzbestimmung();
        checkoutNewAddressPage.setKundenKontoAnlegen();
        checkoutNewAddressPage.setContinuetodelivery();

    }

        @Test(dependsOnMethods = "checkOutNewAdressPageTest")
        public void versandArtPageTest() throws InterruptedException {
            VersandArtPage versandArtPage = new VersandArtPage(driver);
            Thread.sleep(2000);

            versandArtPage.setDhl();
            versandArtPage.setVersandArtVerwenden();

        }

        @Test(dependsOnMethods = "versandArtPageTest")
        public void zahlungsMethodePageTest() throws InterruptedException {
            ZahlungsMethodePage zahlungsMethodePage = new ZahlungsMethodePage(driver);
            Thread.sleep(2000);

            zahlungsMethodePage.setPaypal();
            zahlungsMethodePage.setZahlungsMethodeVerwenden();

        }

        @Test(dependsOnMethods = "zahlungsMethodePageTest")
        public void uebersichtPageTest() throws InterruptedException {
            UebersichtPage uebersichtPage = new UebersichtPage(driver);
            Thread.sleep(2000);

            uebersichtPage.setBestellen();

        }




    }







