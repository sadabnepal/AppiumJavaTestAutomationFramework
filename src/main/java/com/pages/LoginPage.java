package com.pages;

import com.driver.DriverManager;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private static AndroidElement appLogo;

    @AndroidFindBy(accessibility = "test-Username")
    private static AndroidElement txtFieldUsername;

    @AndroidFindBy(accessibility = "test-Password")
    private static AndroidElement txtFieldPassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private static AndroidElement btnLogin;

    @AndroidFindBy(xpath = "//*[@content-desc='test-Error message']/android.widget.TextView")
    private static AndroidElement lockedErrorMessage;

    public boolean isAppLogoDisplayed() {
        return appLogo.isDisplayed();
    }

    public LoginPage setUsername(String username) {
        txtFieldUsername.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        txtFieldPassword.sendKeys(password);
        return this;
    }

    public void clickOnLoginBtn() {
        btnLogin.click();
    }

    public String getErrorText() {
        return lockedErrorMessage.getText();
    }

    public ProductPage clickAndNavigateToProduct() {
        clickOnLoginBtn();
        return new ProductPage();
    }

}
