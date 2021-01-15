package com.scripts;

import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BussinessFlowWithoutAccountCreation extends DriverTestCase {
    String loginUserName;
    String loginPassword;

    @Test
    public void loginIntoApplication() throws InterruptedException {
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");
        loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);
        loginPage.clickOnCookiesOkayButton();
        loginPage = loginPage.verifyMyAccountIsDisplayed();
    }


    @Test(dependsOnMethods = "loginIntoApplication")
    public void searchTest() throws InterruptedException {
        homePage.enterSearchCriteriaAndChooseResult("Schwarze lauf");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "searchTest")
    public void checkFilters() throws InterruptedException {
        filterComponent.clickOnFilter();
        filterComponent.clickOnFilterSortierenBeiRelevanz();
        filterComponent.clickOnFilterSortierenBeiPreisAufsteigend();
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

        boolean ispriceSorted = productListPage.isFirstpriceIsLessorThenSecond();
        Assert.assertTrue(ispriceSorted, "product not Sorted by price in ascending order");
        System.out.println("Product Sorted by Price in ascending oder");

    }

    @Test(dependsOnMethods = "checkFilters")
    public void addArtikelToWunschList() throws InterruptedException {
        productListPage.addFirstArtikelToWunschList();

    }

    @Test(dependsOnMethods = "checkFilters")
    public void AddSecondArtikelInCart() throws InterruptedException {
        productListPage.AddSecondShoesInCart();

    }



}
