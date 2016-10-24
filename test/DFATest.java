import com.google.gson.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void pass_string_that_contain_atleast_1() throws FileNotFoundException {
        String contain_atleast_1 = "[{\"name\":\"only pass string 1\",\"type\":\"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"0\": \"q1\",\"1\": \"q2\"},\"q2\": {\"0\": \"q2\",\"1\": \"q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\":[\"1\",\"01\",\"001\",\"1111\"],\"fail-cases\":[\"0\",\"10\",\"0000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(contain_atleast_1), Machine.class);
        assertTrue(new DFA(machine).passed());
    }


    @Test
    public void should_pass_string_begin_with_1_and_contains_001() throws IOException {
            String str = "[{\"name\": \"begin with 1 and contain 001\",\"type\": \"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\",\"q3\",\"q4\",\"q5\"],\"alphabets\":[\"0\",\"1\"],\"start-state\":\"q1\",\"delta\": {\"q1\": {\"0\": \"q1\",\"1\": \"q2\"},\"q2\": {\"1\": \"q2\",\"0\": \"q3\"},\"q3\": {\"0\": \"q4\",\"1\": \"q2\"},\"q4\": {\"0\":\"q4\",\"1\": \"q5\"},\"q5\": {\"0\":\"q5\",\"1\":\"q5\"}},\"final-states\":[\"q5\"]},\"pass-cases\": [\"1001\",\"101001\",\"100001\",\"1111001\"],\"fail-cases\": [\"0\",\"001\",\"10000\",\"01010\"]}]";
            Machine machines = dfaForTouple().fromJson(parseAsJsonArray(str), Machine.class);
            assertTrue(new DFA(machines).passed());
        }


    @Test
    public void should_pass_string_which_decimal_is_a_even_number() throws IOException {
        String decimal_is_even_number = "[{ \"name\": \"decimal is a even number\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [0, 1],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"0\":\"q2\",\"1\":\"q1\"}, \"q2\": {\"0\":\"q2\",\"1\":\"q1\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"0\",\"10100\",\"10000\",\"11110010\"],\"fail-cases\": [\"01\",\"001\",\"100001\",\"010101\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_even_number), Machine.class);
        assertTrue(new DFA(machine).passed());
    }

    @Test
    public void should_pass_string_that_power_of_two() throws FileNotFoundException {
        String decimal_is_power_of_two = "[{\"name\": \"decimal is power of two\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\",\"q3\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q2\": {\"1\": \"q3\",\"0\": \"q2\"},\"q3\": {\"1\": \"q3\",\"0\": \"q3\"},\"q1\":{\"0\":\"q1\",\"1\": \"q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"1\",\"00100\",\"100000\",\"10000000\"],\"fail-cases\": [\"01\",\"00100\",\"101000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_power_of_two), Machine.class);
        assertTrue(new DFA(machine).passed());
    }

    @Test
    public void should_pass_string_of_examples() throws FileNotFoundException {
        String string_of_examples = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]},{\"name\":\"even number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q1\"]},\"fail-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"pass-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]},{\"name\":\"at least one zero\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q2\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"10\",\"100\",\"1100\",\"01\",\"010\"],\"fail-cases\":[\"\",\"1\",\"11\",\"111\"]},{\"name\":\"at least one one\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"1\":\"q2\",\"0\":\"q1\"},\"q2\":{\"0\":\"q2\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"1\",\"10\",\"100\",\"1100\",\"01\",\"010\"],\"fail-cases\":[\"\",\"0\",\"00\",\"000\"]},{\"name\":\"string length multiple of three\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q3\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q2\"},\"q2\":{\"0\":\"q3\",\"1\":\"q3\"},\"q3\":{\"0\":\"q1\",\"1\":\"q1\"}},\"start-state\":\"q1\",\"final-states\":[\"q1\"]},\"pass-cases\":[\"000\",\"111\",\"010\",\"101\",\"111111\",\"000000\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"11\",\"10\",\"01\",\"11111\",\"00000\",\"01010\",\"10101\"]},{\"name\":\"alternate ones and zeroes beginning with zero\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q3\",\"q2\",\"q4\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q4\"},\"q2\":{\"0\":\"q4\",\"1\":\"q3\"},\"q3\":{\"0\":\"q2\",\"1\":\"q4\"},\"q4\":{\"0\":\"q4\",\"1\":\"q4\"}},\"start-state\":\"q1\",\"final-states\":[\"q3\",\"q2\"]},\"pass-cases\":[\"0\",\"01\",\"010\",\"0101\",\"01010\",\"010101\"],\"fail-cases\":[\"\",\"1\",\"10\",\"101\",\"11\",\"00\",\"0100\",\"011\"]}]";
        String examples_as_array = parseAsJsonArray(string_of_examples);
        isPassed(examples_as_array,"passed");
    }

    @Test
    public void should_fail_string_for_contain_atleast_1(){
        String contain_atleast_1 = "[{\"name\":\"only pass string 1\",\"type\":\"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"0\": \"q1\",\"1\": \"q2\"},\"q2\": {\"0\": \"q2\",\"1\": \"q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\":[\"1\",\"01\",\"001\",\"1111\"],\"fail-cases\":[\"0\",\"10\",\"0000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(contain_atleast_1), Machine.class);
        assertTrue(new DFA(machine).failed());
    }

    @Test
    public void should_fail_string_begin_with_1_and_contains_001() throws IOException {
        String str = "[{\"name\": \"begin with 1 and contain 001\",\"type\": \"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\",\"q3\",\"q4\",\"q5\"],\"alphabets\":[\"0\",\"1\"],\"start-state\":\"q1\",\"delta\": {\"q1\": {\"0\": \"q1\",\"1\": \"q2\"},\"q2\": {\"1\": \"q2\",\"0\": \"q3\"},\"q3\": {\"0\": \"q4\",\"1\": \"q2\"},\"q4\": {\"0\":\"q4\",\"1\": \"q5\"},\"q5\": {\"0\":\"q5\",\"1\":\"q5\"}},\"final-states\":[\"q5\"]},\"pass-cases\": [\"1001\",\"101001\",\"100001\",\"1111001\"],\"fail-cases\": [\"0\",\"001\",\"10000\",\"01010\"]}]";
        Machine machines = dfaForTouple().fromJson(parseAsJsonArray(str), Machine.class);
        assertTrue(new DFA(machines).failed());
    }

    @Test
    public void should_fail_string_which_decimal_is_a_even_number() throws IOException {
        String decimal_is_even_number = "[{ \"name\": \"decimal is a even number\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\"],\"alphabets\": [0, 1],\"start-state\": \"q1\",\"delta\": {\"q1\": {\"0\":\"q2\",\"1\":\"q1\"}, \"q2\": {\"0\":\"q2\",\"1\":\"q1\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"0\",\"10100\",\"10000\",\"11110010\"],\"fail-cases\": [\"01\",\"001\",\"100001\",\"010101\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_even_number), Machine.class);
        assertTrue(new DFA(machine).failed());
    }

    @Test
    public void should_fail_string_that_power_of_two() throws FileNotFoundException {
        String decimal_is_power_of_two = "[{\"name\": \"decimal is power of two\",\"type\": \"dfa\",\"tuple\": {\"states\": [\"q1\",\"q2\",\"q3\"],\"alphabets\": [\"0\",\"1\"],\"start-state\": \"q1\",\"delta\": {\"q2\": {\"1\": \"q3\",\"0\": \"q2\"},\"q3\": {\"1\": \"q3\",\"0\": \"q3\"},\"q1\":{\"0\":\"q1\",\"1\": \"q2\"}},\"final-states\": [\"q2\"]},\"pass-cases\": [\"1\",\"00100\",\"100000\",\"10000000\"],\"fail-cases\": [\"01\",\"00100\",\"101000\",\"01010\"]}]";
        Machine machine = dfaForTouple().fromJson(parseAsJsonArray(decimal_is_power_of_two), Machine.class);
        assertTrue(new DFA(machine).failed());
    }

    @Test
    public void should_fail_string_of_examples() throws FileNotFoundException {
        String string_of_examples = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]},{\"name\":\"even number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q1\"]},\"fail-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"pass-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]},{\"name\":\"at least one zero\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q2\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"10\",\"100\",\"1100\",\"01\",\"010\"],\"fail-cases\":[\"\",\"1\",\"11\",\"111\"]},{\"name\":\"at least one one\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"1\":\"q2\",\"0\":\"q1\"},\"q2\":{\"0\":\"q2\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"1\",\"10\",\"100\",\"1100\",\"01\",\"010\"],\"fail-cases\":[\"\",\"0\",\"00\",\"000\"]},{\"name\":\"string length multiple of three\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q3\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q2\"},\"q2\":{\"0\":\"q3\",\"1\":\"q3\"},\"q3\":{\"0\":\"q1\",\"1\":\"q1\"}},\"start-state\":\"q1\",\"final-states\":[\"q1\"]},\"pass-cases\":[\"000\",\"111\",\"010\",\"101\",\"111111\",\"000000\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"11\",\"10\",\"01\",\"11111\",\"00000\",\"01010\",\"10101\"]},{\"name\":\"alternate ones and zeroes beginning with zero\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q3\",\"q2\",\"q4\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q4\"},\"q2\":{\"0\":\"q4\",\"1\":\"q3\"},\"q3\":{\"0\":\"q2\",\"1\":\"q4\"},\"q4\":{\"0\":\"q4\",\"1\":\"q4\"}},\"start-state\":\"q1\",\"final-states\":[\"q3\",\"q2\"]},\"pass-cases\":[\"0\",\"01\",\"010\",\"0101\",\"01010\",\"010101\"],\"fail-cases\":[\"\",\"1\",\"10\",\"101\",\"11\",\"00\",\"0100\",\"011\"]}]";
        String examples_as_array = parseAsJsonArray(string_of_examples);
        isPassed(examples_as_array,"failed");
    }


    private void isPassed(String array_of_string,String condition) {
        String[] split = array_of_string.split("[,][{]");
        for (int index = 0; index < split.length; index++) {
            if (index != 0) {
                split[index] = "{".concat(split[index]);
            }
            Machine machine = dfaForTouple().fromJson(split[index], Machine.class);
            if(condition.equals("passed"))
                assertTrue(new DFA(machine).passed());
            else
                assertTrue(new DFA(machine).failed());

        }
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