package com.pages;

import com.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private static MobileElement appLogo;

    @AndroidFindBy(accessibility = "test-Username")
    private static MobileElement txtFieldUsername;

    @AndroidFindBy(accessibility = "test-Password")
    private static MobileElement txtFieldPassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private static MobileElement btnLogin;

    @AndroidFindBy(xpath = "//*[@content-desc='test-Error message']/android.widget.TextView")
    private static MobileElement lockedErrorMessage;

    public boolean isAppLogoDisplayed() {
        return isElementDisplayed(appLogo);
    }

    public LoginPage setUsername(String username) {
        enterData(txtFieldUsername, username, "username");
        return this;
    }

    public LoginPage setPassword(String password) {
        enterData(txtFieldPassword, password, "password");
        return this;
    }

    public void clickOnLoginBtn() {
        clickElement(btnLogin, "Login button");
    }

    public String getErrorText() {
        return lockedErrorMessage.getText();
    }

    public ProductPage clickAndNavigateToProduct() {
        clickOnLoginBtn();
        return new ProductPage();
    }

}
