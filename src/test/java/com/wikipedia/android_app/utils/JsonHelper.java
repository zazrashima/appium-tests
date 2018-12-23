package com.wikipedia.android_app.utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonHelper {
    public static JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) obj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
