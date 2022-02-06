package com.pages;

import com.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='test-Cart drop zone']//android.widget.TextView")
    private static MobileElement productPageHeader;

    public boolean isProductHeaderDisplayed() {
        return productPageHeader.isDisplayed();
    }
}
