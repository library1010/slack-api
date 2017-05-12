package com.hos.slack.json.implement;

import java.util.Collection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hos.slack.json.JsonServerMessage;

public abstract class MessageJson implements JsonServerMessage {

    private static Gson jsonCreator;

    protected Gson getJsonCreator() {
        if (jsonCreator == null) {
            jsonCreator =
                new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeHierarchyAdapter(Collection.class, new CollectionAdapter())
                    .create();
        }
        return jsonCreator;
    }
}
