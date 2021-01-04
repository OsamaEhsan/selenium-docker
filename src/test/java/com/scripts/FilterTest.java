package com.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.DriverTestCase;

public class FilterTest extends DriverTestCase {

    String loginUserName;
    String loginPassword;

    String searchKeyword = "Shirt";
    String shirtSearchMessage = "Suche: \"Shirt\"";
    String shirtSearchResult = "Ergebnisse";

    @Test
    public void filter() throws InterruptedException {

        // Login into application
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");

        // Provide email & pass, logged into application
        loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);

        loginPage.clickOnCookiesOkayButton();

        // enter search keyword in search text bar
        homepage = homepage.enterSearchKeyword(searchKeyword);

        // click on search icon
        homepage = homepage.clickOnSearchIcon();

        // click on filter button
        productListPage.clickOnFilterButton();

        // select the blue color from filter option
        productListPage.clickOnBlueColorFilter();

        // click on shown result bar
        productListPage.clickOnShowResultBar();

        boolean clearAllFilter = productListPage.isAllClearFilterDisplayed();

        boolean blueColorFilter = productListPage.isBlueColorFilterDisplayed();

        // verify that after applying filter, 'Clear all filter' should be displayed
        Assert.assertTrue(clearAllFilter, "Clear All filter should be displayed");

        // verify that after applying blue color filter, 'blue color filter' should be displayed
        Assert.assertTrue(blueColorFilter, "Blue color filter should be displayed");

        // Logout from application
        loginPage.signOutFromApplication();

    }

}
