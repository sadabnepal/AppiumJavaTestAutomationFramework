package com.tests;

import com.pages.LoginPage;
import org.testng.annotations.Test;

import static com.constants.DataConstants.*;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginPageLogoTest() {
        assertTrue(new LoginPage().isAppLogoDisplayed());
    }

    @Test(priority = 1)
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(LOCKED_OUT_USER).setPassword(LOGIN_PASSWORD).clickOnLoginBtn();
        assertEquals(loginPage.getErrorText(), USER_LOCKED_OUT_ERROR);
    }

    @Test(priority = 2)
    public void validLoginTest() {
        boolean isProductPageDisplayed = new LoginPage()
                .setUsername(VALID_USER)
                .setPassword(LOGIN_PASSWORD)
                .clickAndNavigateToProduct().isProductHeaderDisplayed();
        assertTrue(isProductPageDisplayed);
    }
}
