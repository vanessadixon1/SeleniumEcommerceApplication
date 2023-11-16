package com.amcsoftware.parameters.init;

import com.amcsoftware.parameters.jsonDataItem.LoginDataItem;
import com.amcsoftware.parameters.jsonDataItem.LoginDataJson;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class LoginInit {
    /**
     * Gson is Google json and external library for dealing with json files
     */

    private final Gson gson;

    public LoginInit() {
        gson = new Gson();
    }

    public List<LoginDataItem> initialize(String filePath) {
        List<LoginDataItem> parameterObjects;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            LoginDataJson parameters = gson.fromJson
                    (new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath))), LoginDataJson.class);
            System.out.println(parameters.toString());
            parameterObjects = parameters.getLoginData();
        } catch (JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
            throw e;
        }
        return parameterObjects;
    }
}
