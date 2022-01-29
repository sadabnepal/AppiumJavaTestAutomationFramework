package com.pages;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import static com.utils.ElementUtils.*;

public class APIDemoPage {

    private final String textView = "//android.widget.TextView";

    public AndroidElement getTextView() {
        return findByXpath(textView);
    }

    public List<AndroidElement> getTextViews() {
        return findElementsByXpath(textView);
    }

    public AndroidElement getViewMenu() {
        return findByAccessibilityId("Views");
    }

    public AndroidElement getAnimationMenu() {
        return findByAccessibilityId("Animation");
    }

    public AndroidElement getListDialogMenu() {
        return findByXpath("//*[@content-desc='List dialog']");
    }

    public AndroidElement commandTwoMenu() {
        return findByXpath("//*[@text='Command two']");
    }

    public String messageText() {
        return findByXpath("//*[@resource-id='android:id/message']").getText();
    }

    public AndroidElement getBasicMenu() {
        return findByAccessibilityId("1. Basic");
    }

    public AndroidElement getExpandableListMenu() {
        return findByAccessibilityId("Expandable Lists");
    }

    public AndroidElement getCustomerAdaptorMenu() {
        return findByAccessibilityId("1. Custom Adapter");
    }

    public AndroidElement getPeopleNamesMenu() {
        return findByXpath("//*[@text='People Names']");
    }

    public AndroidElement getSampleActionPopup() {
        return findByXpath("//*[@text='Sample action']");
    }

    public AndroidElement getDateWidgetsMenu() {
        return findByAccessibilityId("Date Widgets");
    }

    public AndroidElement getInlineMenu() {
        return findByAccessibilityId("2. Inline");
    }

    public AndroidElement getSource() {
        return findByAccessibilityId("12");
    }

    public AndroidElement getTarget() {
        return findByAccessibilityId("3");
    }

}
