package com.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pagesAndComponents.UserCheckout;
import com.utils.DriverTestCase;


public class UserCheckoutTest extends DriverTestCase {


    @Test
    public void AddItems() throws InterruptedException {

     userCheckout = userCheckout.clickOnHerrenLink();
     userCheckout = userCheckout.SelectMenuItem();
     userCheckout = userCheckout.SelectFilterandSetPrice("50");
     userCheckout = userCheckout.SortFilterSelect();
     
     Assert.assertTrue(userCheckout.LastItemPriceCheck());
     Assert.assertTrue(userCheckout.LastTwoItemPriceCheck());
     
     userCheckout = userCheckout.AddToWishList();
     
     String loginUserName = propertyReader.readApplicationFile("QAUserName");
     String loginPassword = propertyReader.readApplicationFile("QAPassword");

     loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);
     
     userCheckout = userCheckout.SelectFilialeFinden();
     userCheckout = userCheckout.EnterSearchTerm("rucks");
     
     Assert.assertTrue(userCheckout.checkNumberOfStores());

    }

}
