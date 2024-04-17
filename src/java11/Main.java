package java11;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap = setCorrelationId(null);
        System.out.println(hashMap);
    }

    private static Map<String,String> setCorrelationId(Map<String, String> headers) {
        if (headers == null || headers.isEmpty()) {
            headers = new HashMap<>(); // Create a new HashMap if headers is null or empty
        }
        headers.put("CORRELATIONID", "correlationId");
        return headers;
    }


}
