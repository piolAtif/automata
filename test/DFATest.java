import com.google.gson.*;
import org.junit.Test;

import java.io.*;


import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void pass_string_only_1() throws FileNotFoundException {
        String pass_only_1 = "[{\"name\":\"only pass string 1\",\"type\":\"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"0\": \"q1,q2\"},\"q2\": {\"1\": \"q1,q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\":[\"1\",\"01\",\"001\",\"1111\"],\"fail-cases\":[\"0\",\"10\",\"0000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(pass_only_1), Machine.class);
        assertTrue(new DFA(machine).passed());
    }


    @Test
    public void should_pass_string_begin_with_1_and_contains_001() throws IOException {
            String str = "[{\"name\": \"begin with 1 and contain 001\",\"type\": \"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\",\"q3\",\"q4\",\"q5\"],\"alphabets\":[\"0\",\"1\"],\"start-state\":\"q1\",\"delta\": {\"q1\": {\"0\": \"q1\"},\"q2\": {\"1\": \"q1,q2,q3\"},\"q3\": {\"0\": \"q2\"},\"q4\": {\"0\":\"q3,q4\"},\"q5\": {\"1\":\"q4,q5\",\"0\":\"q5\"}},\"final-states\":[\"q5\"]},\"pass-cases\": [\"1001\",\"101001\",\"100001\",\"1111001\"],\"fail-cases\": [\"0\",\"001\",\"10000\",\"01010\"]}]";
            Machine machines = dfaForTouple().fromJson(parseAsJsonArray(str), Machine.class);
            assertTrue(new DFA(machines).passed());
        }


    @Test
    public void should_pass_string_which_decimal_is_a_even_number() throws IOException {
        String decimal_is_even_number = "[{ \"name\": \"decimal is a even number\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [0, 1],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"1\":\"q1,q2\"}, \"q2\": {\"0\":\"q1,q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"0\",\"10100\",\"10000\",\"11110010\"],\"fail-cases\": [\"01\",\"001\",\"100001\",\"010101\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_even_number), Machine.class);
        assertTrue(new DFA(machine).passed());
    }

    @Test
    public void should_pass_string_that_power_of_two() throws FileNotFoundException {
        String decimal_is_power_of_two = "[{\"name\": \"decimal is power of two\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\",\"q3\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q2\": {\"1\": \"q1\",\"0\": \"q2\"},\"q3\": {\"1\": \"q2\"},\"q1\":{\"0\":\"q1\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"1\",\"00100\",\"100000\",\"10000000\"],\"fail-cases\": [\"01\",\"00100\",\"101000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_power_of_two), Machine.class);
        assertTrue(new DFA(machine).passed());
    }


    private Gson dfaForTouple(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Machine.class, new MachineDeserialiser());
        gsonBuilder.registerTypeAdapter(Tuple.class, new TupleDeserialiser());
        Gson gson = gsonBuilder.create();
       return gson;
    }

    private String parseAsJsonArray(String str) {
        String withoutEscapeCharacter = str.replaceAll("\\\\", "");
        return withoutEscapeCharacter.substring(1, withoutEscapeCharacter.length() - 1);
    }


}