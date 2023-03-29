package com.example.findopenwifi.domain.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public enum JsonParsingUtil {
    INSTANCE;

    public JsonObject getJsonObject(String jsonData, String tag) {
        return JsonParser.parseString(jsonData).getAsJsonObject().get(tag).getAsJsonObject();
    }

    public JsonObject getJsonObject(JsonObject jsonObject, String tag) {
        return jsonObject.get(tag).getAsJsonObject();
    }

    public int getInt(JsonObject jsonObject, String tag) {
        return jsonObject.get(tag).getAsInt();
    }

    public String getString(JsonObject jsonObject, String tag) {
        return jsonObject.get(tag).getAsString();
    }
}
