package com.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.DriverTestCase;

public class SearchTest extends DriverTestCase {
    String loginUserName;
    String loginPassword;

    String searchKeyword = "Shirt";
    String shirtSearchMessage = "Suche: \"Shirt\"";
    String shirtSearchResult = "Ergebnisse";

    @Test
    public void search() throws InterruptedException {

        // Login into application
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");

        // Provide email & pass, logged into application
        loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);

        // enter search keyword in search text bar
        homepage = homepage.enterSearchKeyword(searchKeyword);

        //click on search icon
        homepage = homepage.clickOnSearchIcon();

        String searchResultMeg = homepage.getSearchShirtMessage();

        String searchResult = homepage.getSearchShirtResult();

        //after searching shirt keyword, in result Search shirt should be shown at top of PLP
        Assert.assertTrue(searchResultMeg.contains(shirtSearchMessage),"Searching shirt should be displayed message at top");

        //after searching shirt keyword, result keyword should be shown at top of PLP
        Assert.assertTrue(searchResult.contains(shirtSearchResult),"Searching shirt should be displayed result at top");

        // Logout from application
        loginPage.signOutFromApplication();

    }

}