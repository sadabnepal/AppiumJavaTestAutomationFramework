package com.driver;

import static com.config.ConfigFactory.*;

import com.constants.AppPackages;
import com.constants.PathConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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
        capabilities.setCapability(MobileCapabilityType.APP, PathConstants.ANDROID_APK_PATH);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getConfig().DeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getConfig().platformVersion());
        capabilities.setCapability(MobileCapabilityType.UDID, getConfig().udid());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppPackages.APP_PACKAGE_SAUCELABS);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppPackages.APP_ACTIVITY_SAUCELABS);
        if(getConfig().autoLaunchEmulator()) {
            capabilities.setCapability("avd", getConfig().DeviceID());
            capabilities.setCapability("avdLaunchTimeout", 180000);
        }
        try {
            return new AndroidDriver<>(new URL(getConfig().baseurl() + ":" + getConfig().port()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
