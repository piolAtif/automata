import com.google.gson.*;

import java.lang.reflect.Type;

public class TupleDeserialiser implements JsonDeserializer<Tuple>{

    @Override
    public Tuple deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Tuple tuple = new Tuple();
        tuple.setStates(ConvertJsonArrayToPrimtiveArray.convertString(jsonObject.get("states").getAsJsonArray()));
        tuple.setStartState(jsonObject.get("start-state").getAsString());
        tuple.setFinalStates(ConvertJsonArrayToPrimtiveArray.convertString(jsonObject.get("final-states").getAsJsonArray()));
        tuple.setDelta(ConvertJsonObjectToMap.convertHashMap(jsonObject.get("delta").getAsJsonObject()));
        tuple.setAlphabets(ConvertJsonArrayToPrimtiveArray.convertString(jsonObject.get("alphabets").getAsJsonArray()));
        return tuple;
    }
}
