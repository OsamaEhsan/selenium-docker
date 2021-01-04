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
        homepage = homepage.mouseHoverOnShoesSubMenu();

        // click on Tie boot under shoes sub menu
        homepage = homepage.clickOnTieBootLink();

        // click on first shoe at PLP page
        homepage = homepage.clickOnFirstShoeImage();

        // choose the boot size
        homepage = homepage.clickOnChooseSize();

        // select the size of product
        homepage = homepage.selectFirstShoeSize();

        // click on add to cart
        homepage = homepage.clickOnAddToCart();

        // click on checkout button
        homepage = homepage.clickOnSafelyCheckoutButton();

        // Logout from application
        //loginPage.signOutFromApplication();

    }

}