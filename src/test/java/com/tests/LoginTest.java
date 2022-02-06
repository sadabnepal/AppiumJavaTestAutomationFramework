package com.tests;

import com.pages.LoginPage;
import org.testng.annotations.Test;

import static com.constants.DataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
public class LoginTest extends BaseTest {

    @Test
    public void loginPageLogoTest() {
        assertThat(new LoginPage().isAppLogoDisplayed()).isTrue();
    }

    @Test(priority = 1)
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(LOCKED_OUT_USER).setPassword(LOGIN_PASSWORD).clickOnLoginBtn();
        assertThat(loginPage.getErrorText()).isEqualTo(USER_LOCKED_OUT_ERROR);
    }

    @Test(priority = 2)
    public void validLoginTest() {
        boolean isProductPageDisplayed = new LoginPage()
                .setUsername(VALID_USER)
                .setPassword(LOGIN_PASSWORD)
                .clickAndNavigateToProduct().isProductHeaderDisplayed();
        assertThat(isProductPageDisplayed).isTrue();
    }
}
