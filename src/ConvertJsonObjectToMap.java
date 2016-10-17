import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ConvertJsonObjectToMap {
    public static HashMap<String, HashMap<String, String>> convertHashMap(JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
        Iterator<Map.Entry<String, JsonElement>> iterator = entries.iterator();
            HashMap<String, HashMap<String,String>> exterior = new HashMap<>();
            HashMap<String, String> interior = new HashMap<>();
        while (iterator.hasNext()){
            Map.Entry<String, JsonElement> entry = iterator.next();
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            interior = convertInnerHashMap(value.getAsJsonObject());
            exterior.put(key,interior);
        }
        return exterior;
    }

    private static HashMap<String, String> convertInnerHashMap(JsonObject jsonObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
        Iterator<Map.Entry<String, JsonElement>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, JsonElement> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            hashMap.put(key, value);
        }
        return hashMap;
    }
}
