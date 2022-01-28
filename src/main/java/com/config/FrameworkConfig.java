package com.config;

import com.constants.PathConstants;
import org.aeonbits.owner.Config;

@Config.Sources({PathConstants.PROPERTIES_FILE_PATH})
public interface FrameworkConfig extends Config {

    String baseurl();
    String port();

}
