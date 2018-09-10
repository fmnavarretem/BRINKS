package fmnavarretem.co.brinks.Util;

import com.google.gson.Gson;

public class JSONHelper {
    public static Object objectFromJson(Object object, Class<?> type) {
        String jsonString = new Gson().toJson(object);
        return new Gson().fromJson(jsonString,type);
    }

    public static Object objectFromJson(String object, Class<?> type) {
        return new Gson().fromJson(object,type);
    }

    public static String toJson(Object object){
        return new Gson().toJson(object);
    }
}
