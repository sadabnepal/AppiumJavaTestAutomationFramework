package com.facade;

import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.ProductPage;


public class LoginFacade extends BasePage {

    public ProductPage navigateToProductPage(String user, String password) {
        return new LoginPage()
                .setUsername(user)
                .setPassword(password)
                .clickAndNavigateToProduct();
    }

}
