package com.example.findopenwifi.domain.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Optional;

public enum JsonParsingUtil {
    INSTANCE;

    public Optional<JsonObject> getJsonObject(String jsonData, String tag) {

        JsonElement jsonElement = JsonParser.parseString(jsonData).getAsJsonObject().get(tag);
        if (jsonElement == null) {
            return Optional.empty();
        }

        return Optional.of(jsonElement.getAsJsonObject());
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

    public JsonArray getJsonArray(JsonObject jsonObject, String tag) {return jsonObject.get(tag).getAsJsonArray();}
}
