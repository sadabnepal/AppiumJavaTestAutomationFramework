package com.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import static com.constants.PathConstants.*;

public class JsonReader {

    public static JSONObject getJSONData()  {
        JSONObject jsonObject = null;
        try (FileInputStream inputStream = new FileInputStream(LOGIN_DATA_FILE_PATH)) {
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            jsonObject = new JSONObject(jsonTokener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(jsonObject);
    }

}
