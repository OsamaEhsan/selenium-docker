package com.scripts;

import org.testng.annotations.Test;
import com.utils.DriverTestCase;

public class LoginTest extends DriverTestCase {
    String loginUserName;
    String loginPassword;
    String eduFirstName;
    String eduLastName;
    String eduUserName;
    String eduPassword;
    String eduRePassword;

    @Test
    public void LoginIntoApplication() throws InterruptedException {

        // Login into application
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");

        // Provide email & pass, logged into application
        loginPage = loginPage.loginIntoApplication(loginUserName, loginPassword);

        // loginPage = loginPage.verifyMyAccountIsDisplayed();

        // Logout from application
        loginPage.signOutFromApplication();

    }

}
