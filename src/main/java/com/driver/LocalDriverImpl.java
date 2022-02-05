package com.driver;

import static com.config.ConfigReader.*;

import com.constants.PathConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements iDriverManager {

    @Override
    public WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, PathConstants.APK_APPLICATION_PATH);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.DeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.platformVersion());
        try {
            return new AndroidDriver<>(new URL(config.baseurl() + ":" + config.port()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
