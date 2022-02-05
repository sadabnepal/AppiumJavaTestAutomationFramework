package com.config;

import com.constants.PathConstants;
import org.aeonbits.owner.Config;

@Config.Sources({PathConstants.PROPERTIES_FILE_PATH})
public interface FrameworkConfig extends Config {

    String baseurl();

    String port();

    String DeviceName();

    String platformVersion();

    String mode();

    String bs_user();

    String bs_key();

    String bs_deviceName();

    String bs_platformVersion();

    String bs_app();

}
