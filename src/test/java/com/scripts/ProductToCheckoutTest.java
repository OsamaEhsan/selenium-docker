package com.scripts;

import org.testng.annotations.Test;

import com.utils.DriverTestCase;

public class ProductToCheckoutTest extends DriverTestCase {
    String loginUserName;
    String loginPassword;

    String searchKeyword = "Shirt";
    String shirtSearchMessage = "Suche: \"Shirt\"";
    String shirtSearchResult = "Ergebnisse";

    @Test
    public void moveToCheckout() throws InterruptedException {

        // Login into application
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");

        // Provide email & pass, logged into application
        loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);

        // accept the cookies
        loginPage.clickOnCookiesOkayButton();

        // mouse hover on shoes sub menu
        homePage = homePage.mouseHoverOnShoesSubMenu();

        // click on Tie boot under shoes sub menu
        homePage = homePage.clickOnTieBootLink();

        // click on first shoe at PLP page
        homePage = homePage.clickOnFirstShoeImage();

        // choose the boot size
        homePage = homePage.clickOnChooseSize();

        // select the size of product
        homePage = homePage.selectFirstShoeSize();

        // click on add to cart
        homePage = homePage.clickOnAddToCart();

        // click on checkout button
        homePage = homePage.clickOnSafelyCheckoutButton();

        // Logout from application
        //loginPage.signOutFromApplication();

    }

}