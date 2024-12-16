package com.education.ztu.game;

import com.google.gson.Gson;

/**
 * Handles JSON serialization and deserialization.
 */
public class JsonParser {
    private static final Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
