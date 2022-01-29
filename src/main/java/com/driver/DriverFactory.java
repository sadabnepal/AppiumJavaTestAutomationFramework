package com.driver;

import com.config.FrameworkConfig;
import com.constants.PathConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, PathConstants.APPLICATION_PATH);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.DeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.platformVersion());
        try {
            driver = new AndroidDriver<>(new URL(config.baseurl() + ":" + config.port()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
