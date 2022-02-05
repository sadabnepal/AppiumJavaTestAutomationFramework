package com.tests;

import static com.utils.ElementUtils.*;

import com.constants.AppPackages;
import com.pages.APIDemoPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementStrategyTest extends BaseTest {

    @Test()
    public void appNameHeaderTest() {
        Assert.assertEquals(new APIDemoPage().getTextView().getText(), "API Demos");
    }

    @Test(priority = 1)
    public void allMenuNamesTest() {
        String[] list = {"API Demos", "Access'ibility", "Accessibility", "Animation", "App", "Content", "Graphics", "Media", "NFC", "OS", "Preference", "Text", "Views"};
        List<String> expectedMenuList = Arrays.asList(list);

        List<String> actualMenuList = new ArrayList<>();
        new APIDemoPage().getTextViews()
                .stream().map(WebElement::getText)
                .forEach(actualMenuList::add);
        Assertions.assertThat(actualMenuList)
                .hasSizeBetween(10, 15)
                .isEqualTo(expectedMenuList)
                .contains("Accessibility")
                .isNotEmpty();
    }

    @Test(priority = 2)
    public void viewMenuNavigationTest() {
        APIDemoPage page = new APIDemoPage();
        page.getViewMenu().click();
        Assert.assertTrue(page.getAnimationMenu().isDisplayed());
    }

    @Test(priority = 3)
    public void openMenuUsingAppActivityTest() throws InterruptedException {
        APIDemoPage page = new APIDemoPage();
        openAppUsingPackage(AppPackages.ALERT_DIALOGUE);
        page.getListDialogMenu().click();
        Thread.sleep(1000);
        page.commandTwoMenu().click();
        Assertions.assertThat(page.messageText())
                .isNotEmpty()
                .containsWhitespaces()
                .isEqualTo("You selected: 1 , Command two");
    }

    @Test(priority = 4)
    public void findElementByUIAutomatorTest() {
        waitForElementTobeClickable(findElementByText("App")).click();
        Assert.assertTrue(findElementByText("Action Bar").isDisplayed());
    }

    @Test(priority = 5)
    public void scrollElementTest() {
        APIDemoPage page = new APIDemoPage();
        page.getViewMenu().click();
        scrollAndFindElementByText("ScrollBars").click();
        Assert.assertTrue(page.getBasicMenu().isDisplayed());
    }

}
