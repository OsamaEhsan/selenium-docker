package com.scripts;

import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BussinessFlowWithAccountCreation extends DriverTestCase {
    String loginUserName;
    String loginPassword;
    String eduFirstName;
    String eduLastName;
    String eduUserName;
    String eduPassword;
    String eduRePassword;

    @Test
    public void loginIntoApplication() throws InterruptedException {

        // Login into application
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");

        // Provide email & pass, logged into application
        //loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);
        loginPage.mouseHoverOnRegisterIcon();


/*

        //HerrenArticlePage
        bussinessflowpage.FilterSearches();
        boolean filterddone=bussinessflowpage.isAllFilterdDisplayed();
        Assert.assertTrue(filterddone, "All filterd not displayed successfully");
        System.out.println("All Filterd are displayed successfully after applied");
        boolean ispriceSorted = bussinessflowpage.isFirstpriceIsLessorThenSecond();
        Assert.assertTrue(ispriceSorted, "product not Sorted by price in ascending order");
        System.out.println("Product Sorted by Price in ascending oder");
        bussinessflowpage.ClickonfirstShoesWishlist();
        bussinessflowpage.AddSecondShoesInCart();
        bussinessflowpage.enterSearchCriteria1("Stiefel");
        System.out.println("Searched for Stiefel");
        bussinessflowpage.AddThirdShoesInCart();
        System.out.println("Third Shoes added to cart of Stiefel");


        bussinessflowpage.enterSearchCriteria1("Stiefel");
        System.out.println("Searched for Stiefel");
        bussinessflowpage.AddFourthShoesInCart();
        System.out.println("Fourth Shoes added to cart of Stiefel");
        boolean numberofitem=bussinessflowpage.numberofitemInCart();
        Assert.assertTrue(numberofitem, "3 items not displayed in cart");
        System.out.println("3 items displayed in cart");
        bussinessflowpage.AddtoWishlistandRemovefromCart();
        System.out.println("Item added to wishlist and removed from cart");
        loginPage.mouseHoverOnRegisterIcon();
        bussinessflowpage.logoutUser();
        loginPage.mouseHoverOnRegisterIcon();
        loginPage = loginPage.loginIntoApplication(name+"@gmail.com", "Test@123");
        System.out.println("Login Again with New User");
        boolean propercount=bussinessflowpage.verifywishlistcountandCartcountisProper();
        Assert.assertTrue(propercount, "2-2 items not displayed in wishlist and Cart");
        System.out.println("2-2 items displayed in wishlist and cart");*/

    }

    @Test(dependsOnMethods = "loginIntoApplication")
    public void createAccountTest() throws InterruptedException {

        registrationPage.clickONOK();
        registrationPage.clickOnNewAccount();
        registrationPage.selectGender();
        String name=randomString(10);
        System.out.println("Login with email : " +name+"@gmail.com");
        registrationPage.enterFirstname(name);
        registrationPage.enterLastName("test");
        registrationPage.enterEmail(name+"@gmail.com");
        registrationPage.enterPwd("Test@123");
        registrationPage.enterStreet("Marienbader Str.");
        registrationPage.enterHouseNumber("44");
        registrationPage.enterPostalCode("44225");
        registrationPage.enterCity("Dortmund");
        registrationPage.selectPolicy();
        registrationPage.ClickOnRegister();
        System.out.println("New User Registered Successfully");

    }


    @Test(dependsOnMethods = "createAccountTest")
    public void searchTest() throws InterruptedException {

        homePage.enterSearchCriteriaAndChooseResult("Schwarze lauf");
        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "searchTest")
    public void checkFilters() throws InterruptedException {

        filterComponent.clickOnFilter();
        filterComponent.clickOnFilterSortierenBeiRelevanz();
        filterComponent.clickOnFilterSortierenBeiPreisAufsteigend();
        Thread.sleep(3000);
        filterComponent.clickOnFilterGroesse();
        filterComponent.chooseOnFilterGroesseSiebzhenEU();
        filterComponent.clickOnFilterGroesseBackArrow();
        filterComponent.clickOnFilterGroesseMaxPreisFuenfzig();
        filterComponent.clickOnFilterFarbeWeiss();
        filterComponent.clickOnFilterFarbeSchwarz();
        filterComponent.clickOnFilterBrand();
        filterComponent.chooseFilterBrandNike();
        filterComponent.saveFilterBrand();
        filterComponent.clickOnFilterGeschlescht();
        filterComponent.chooseOnFilterGeschleschtMaennlich();
        filterComponent.clickOnFilterGeschleschtBackarrow();
        filterComponent.clickOnFilterErgebnisseAnzeigen();


        boolean filterddone=productListPage.isAllFilterdDisplayed();
        Assert.assertTrue(filterddone, "All filterd not displayed successfully");
        System.out.println("All Filterd are displayed successfully after applied");

    }



}
