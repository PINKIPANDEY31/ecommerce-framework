package com.ecommerce.automation.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class JsonDataReader {

    private static Map<String, Object> data;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(
                    new File("src/test/resources/testdata.json"),
                    Map.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data JSON", e);
        }
    }

    public static String get(String key) {
        return data.get(key).toString();
    }
}