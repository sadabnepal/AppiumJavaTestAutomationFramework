package com.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utils.ElementUtils.*;

public class APIDemoPage {

    private final String textView = "//android.widget.TextView";

    public WebElement getTextView() {
        return findByXpath(textView);
    }

    public List<WebElement> getTextViews() {
        return findElementsByXpath(textView);
    }

    public WebElement getViewMenu() {
        return findByAccessibilityId("Views");
    }

    public WebElement getAnimationMenu() {
        return findByAccessibilityId("Animation");
    }

    public WebElement getListDialogMenu() {
        return findByXpath("//*[@content-desc='List dialog']");
    }

    public WebElement commandTwoMenu() {
        return findByXpath("//*[@text='Command two']");
    }

    public String messageText() {
        return findByXpath("//*[@resource-id='android:id/message']").getText();
    }

    public WebElement getBasicMenu() {
        return findByAccessibilityId("1. Basic");
    }

    public WebElement getExpandableListMenu() {
        return findByAccessibilityId("Expandable Lists");
    }

    public WebElement getCustomerAdaptorMenu() {
        return findByAccessibilityId("1. Custom Adapter");
    }

    public WebElement getPeopleNamesMenu() {
        return findByXpath("//*[@text='People Names']");
    }

    public WebElement getSampleActionPopup() {
        return findByXpath("//*[@text='Sample action']");
    }

    public WebElement getDateWidgetsMenu() {
        return findByAccessibilityId("Date Widgets");
    }

    public WebElement getInlineMenu() {
        return findByAccessibilityId("2. Inline");
    }

    public WebElement getSource() {
        return findByAccessibilityId("12");
    }

    public WebElement getTarget() {
        return findByAccessibilityId("3");
    }

}
