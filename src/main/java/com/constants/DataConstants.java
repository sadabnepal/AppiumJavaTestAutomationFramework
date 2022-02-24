package com.constants;


import static com.utils.JsonReader.*;

public class DataConstants {

    private DataConstants() {
    }

    public static final String VALID_USER = getJSONData().getJSONObject("validUser").getString("user");
    public static final String LOGIN_PASSWORD = getJSONData().getJSONObject("validUser").getString("password");

    public static final String LOCKED_OUT_USER = getJSONData().getJSONObject("lockedUser").getString("user");

    public static final String IN_VALID_USER = getJSONData().getJSONObject("invalidUser").getString("user");
    public static final String IN_VALID_PASSWORD = getJSONData().getJSONObject("invalidPassword").getString("password");

    public static final String USER_LOCKED_OUT_ERROR = "Sorry, this user has been locked out.";
    public static final String INVALID_CRED_ERROR = "Username and password do not match any user in this service.";
}
