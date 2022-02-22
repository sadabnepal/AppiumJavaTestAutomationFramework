package com.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@content-desc='test-Cart drop zone']//android.widget.TextView")
    private static MobileElement productPageHeader;

    public boolean isProductHeaderDisplayed() {
        return isElementDisplayed(productPageHeader);
    }
}
