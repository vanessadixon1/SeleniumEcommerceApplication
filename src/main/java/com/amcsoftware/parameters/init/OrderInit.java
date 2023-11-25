package com.amcsoftware.parameters.init;

import com.amcsoftware.parameters.jsonDataItem.OrderDataItem;
import com.amcsoftware.parameters.jsonDataItem.OrderDataJson;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class OrderInit {
    /**
     * Gson is Google json and external library for dealing with json files
     */

    private final Gson gson;

    public OrderInit() {
        gson = new Gson();
    }

    public List<OrderDataItem> initialize(String filePath) {
        List<OrderDataItem> parameterObjects;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            OrderDataJson parameters = gson.fromJson
                    (new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath))), OrderDataJson.class);
            parameterObjects = parameters.getOrderData();
        } catch (JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
            throw e;
        }
        return parameterObjects;
    }
}
