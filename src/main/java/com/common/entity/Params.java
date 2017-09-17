package com.common.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Params {

    private String name;
    private String value;

    public static Map<String, String> turnToMap(Params[] paramsList) {
        Map<String, String> result = new HashMap<>();
        for (Params p : paramsList) {
            result.put(p.getName(), p.getValue());
        }
        return result;
    }
}
