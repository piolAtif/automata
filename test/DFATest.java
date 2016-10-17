import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import java.io.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DFATest {
    @Test
    public void pass_string_only_1() throws FileNotFoundException {
        Machine[] machines = dfaForTouple().fromJson(new FileReader("./jsonFiles/Touple.JSON"), Machine[].class);
        isMachinePassedCases(machines);
    }


        @Test
    public void should_pass_string_begin_with_1_and_contains_001() throws FileNotFoundException {
        Machine[] machines= dfaForTouple().fromJson(new FileReader("./jsonFiles/begin_with_1_and_contain_001.JSON"), Machine[].class);
       isMachinePassedCases(machines);
    }

    @Test
    public void should_pass_string_which_decimal_is_a_even_number() throws FileNotFoundException {
        Machine[] machines = dfaForTouple().fromJson(new FileReader("./jsonFiles/string_decimal_is_a_even_number.JSON"),Machine[].class);
        isMachinePassedCases(machines);
    }

    @Test
    public void should_pass_string_that_power_of_two() throws FileNotFoundException {
        Machine[] machines = dfaForTouple().fromJson(new FileReader("./jsonFiles/string_decimal_is_power_of_two.JSON"), Machine[].class);
        isMachinePassedCases(machines);
    }


    public Gson dfaForTouple(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Machine.class, new MachineDeserialiser());
        gsonBuilder.registerTypeAdapter(Tuple.class, new TupleDeserialiser());
        Gson gson = gsonBuilder.create();
       return gson;
    }


    private void isMachinePassedCases(Machine[] machine) {
        for (int index = 0; index < machine.length; index++) {
            DFA dfa = new DFA(machine[index]);
            assertTrue(dfa.passed());
        }
    }
}