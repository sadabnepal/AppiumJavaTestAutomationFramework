package com.tests;

import com.pages.APIDemoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.ElementUtils.*;

public class MobileGestureTest extends BaseTest {

    @Test(priority = 6)
    public void tapAndLongPressTest() {
        APIDemoPage page = new APIDemoPage();
        tapOnElement(page.getViewMenu());
        WebElement expandableListsMenu = page.getExpandableListMenu();
        Assert.assertTrue(expandableListsMenu.isDisplayed());
        tapOnElement(expandableListsMenu);
        tapOnElement(page.getCustomerAdaptorMenu());
        longPressOnElement(page.getPeopleNamesMenu(), 3);
        Assert.assertTrue(page.getSampleActionPopup().isDisplayed());
    }

    @Test(priority = 7)
    public void swipeTest() {
        APIDemoPage page = new APIDemoPage();
        page.getViewMenu().click();
        page.getDateWidgetsMenu().click();
        page.getInlineMenu().click();
        moveElementFromSourceToTarget(page.getSource(), page.getTarget());
    }

}
