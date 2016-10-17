import com.google.gson.*;

import java.lang.reflect.Type;

public class MachineDeserialiser implements JsonDeserializer<Machine>{

    @Override
    public Machine deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String name = jsonObject.get("name").getAsString();
        final String typeOfMachine = jsonObject.get("type").getAsString();
        Tuple tuple = context.deserialize(jsonObject.get("tuple"), Tuple.class);
        String[] pass_cases = ConvertJsonArrayToDataTypeArray.convertString(jsonObject.get("pass-cases").getAsJsonArray());
        String[] fail_cases = ConvertJsonArrayToDataTypeArray.convertString(jsonObject.get("fail-cases").getAsJsonArray());
        Machine machine = new Machine();
        machine.setName(name);
        machine.setType(typeOfMachine);
        machine.setTuple(tuple);
        machine.setPassCases(pass_cases);
        machine.setFailCases(fail_cases);
        return machine;
    }
}
