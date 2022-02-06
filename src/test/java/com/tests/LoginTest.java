package com.tests;

import com.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    String validUsername = "standard_user";
    String lockedOutUser = "locked_out_user";
    String password = "secret_sauce";

    @Test
    public void loginPageLogoTest() {
        assertTrue(new LoginPage().isAppLogoDisplayed());
    }

    @Test (priority = 1)
    public void invalidLoginTest() {
        new LoginPage()
                .setUsername(lockedOutUser)
                .setPassword(password)
                .clickOnLoginBtn();
        assertEquals(new LoginPage().getErrorText(), "Sorry, this user has been locked out.");
    }

    @Test
    public void validLoginTest() {
        boolean isProductPageDisplayed = new LoginPage()
                .setUsername(validUsername)
                .setPassword(password)
                .clickAndNavigateToProduct().isProductHeaderDisplayed();
        assertTrue(isProductPageDisplayed);
    }
}
