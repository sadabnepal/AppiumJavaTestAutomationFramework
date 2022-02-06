package com.driver;

import static com.config.ConfigReader.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackImpl implements iDriverManager {

    @Override
    public WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", config.bs_user());
        capabilities.setCapability("browserstack.key", config.bs_key());
        capabilities.setCapability("project", "Appium Java Project");
        capabilities.setCapability("build", "Appium Android demo");
        capabilities.setCapability("name", "Mobile Tests");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, config.bs_app());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        try {
            return new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
