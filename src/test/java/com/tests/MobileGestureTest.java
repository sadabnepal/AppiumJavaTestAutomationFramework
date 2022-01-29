package com.tests;

import com.constants.AppPackages;
import com.pages.APIDemoPage;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.ElementUtils.*;

public class MobileGestureTest extends BaseTest {

    // Tap, Long Press, swiping, drag and drop, scrolling

    @Test(priority = 6)
    public void tapAndLongPressTest() {
        openAppUsingPackage(AppPackages.LANDING_PAGE);
        APIDemoPage page = new APIDemoPage();
        tapOnElement(page.getViewMenu());
        AndroidElement expandableListsMenu = page.getExpandableListMenu();
        Assert.assertTrue(expandableListsMenu.isDisplayed());
        tapOnElement(expandableListsMenu);
        tapOnElement(page.getCustomerAdaptorMenu());
        longPressOnElement(page.getPeopleNamesMenu(), 3);
        Assert.assertTrue(page.getSampleActionPopup().isDisplayed());
    }

    @Test(priority = 7)
    public void swipeTest() {
        APIDemoPage page = new APIDemoPage();
        openAppUsingPackage(AppPackages.LANDING_PAGE);
        page.getViewMenu().click();
        page.getDateWidgetsMenu().click();
        page.getInlineMenu().click();
        moveElementFromSourceToTarget(page.getSource(), page.getTarget());
    }

}
