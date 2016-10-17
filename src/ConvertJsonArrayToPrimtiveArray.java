import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ConvertJsonArrayToPrimtiveArray{

    public static int[] convertInt(JsonArray jsonArray) {
        int[] intArray = new int[jsonArray.size()];
        for (int index = 0; index < intArray.length; index++) {
            intArray[index] = jsonArray.get(index).getAsInt();
        }
        return intArray;
    }

    public static String[] convertString(JsonArray jsonArray) {
        String[] stringArray = new String[jsonArray.size()];
        for (int index = 0; index < stringArray.length; index++) {
            stringArray[index] = jsonArray.get(index).getAsString();
        }
        return stringArray;
    }
}
