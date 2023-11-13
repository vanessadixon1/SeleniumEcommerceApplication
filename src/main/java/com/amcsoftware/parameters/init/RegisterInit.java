package com.amcsoftware.parameters.init;

import com.amcsoftware.parameters.init.jsonDataItem.RegisterDataItem;
import com.amcsoftware.parameters.init.jsonDataItem.RegisterDataJson;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class RegisterInit {
    /**
     * Gson is Google json and external library for dealing with json files
     */

    private final Gson gson;

    public RegisterInit() {
        gson = new Gson();
    }

    public List<RegisterDataItem> initialize(String filePath) {
        List<RegisterDataItem> parameterObjects;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            RegisterDataJson parameters = gson.fromJson
                    (new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath))), RegisterDataJson.class);
            System.out.println(parameters.toString());
            parameterObjects = parameters.getRegisterData();
        } catch (JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
            throw e;
        }
        return parameterObjects;
    }
}
