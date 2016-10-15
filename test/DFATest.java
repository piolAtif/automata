import com.google.gson.Gson;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DFATest {
    @Test
    public void should_pass_string_1() throws FileNotFoundException {
        DFA dfa = dfaForTouple(new FileReader("./jsonFiles/Touple.JSON"));
        assertTrue(dfa.accepts(new Integer[]{1, 0, 1, 0, 0, 1}));
    }

    @Test
    public void should_pass_string_begin_with_1_and_contains_001() throws FileNotFoundException {
        DFA dfa = dfaForTouple(new FileReader("./jsonFiles/begin_with_1_and_contain_001.JSON"));
        assertTrue(dfa.accepts(new Integer[]{1,0,0,1,1,0,0,1}));
    }

    @Test
    public void should_pass_string_which_decimal_is_a_even_number() throws FileNotFoundException {
        DFA dfa = dfaForTouple(new FileReader("./jsonFiles/string_decimal_is_a_even_number.JSON"));
        assertTrue(dfa.accepts(new Integer[]{1, 0, 0, 0, 1, 0}));
        assertFalse(dfa.accepts(new Integer[]{1,0,1,0,1}));
    }

    @Test
    public void should_pass_string_which_is_power_of_two() throws FileNotFoundException {
        DFA dfa = dfaForTouple(new FileReader("./jsonFiles/string_decimal_is_power_of_two.JSON"));
        assertTrue(dfa.accepts(new Integer[]{1,0,0,0,0}));
        assertTrue(dfa.accepts(new Integer[]{0,1}));
        assertFalse(dfa.accepts(new Integer[]{0,1,0,0,1,0}));
    }

    public DFA dfaForTouple(FileReader fileReader){
        Gson gson = new Gson();
        DFAFormat dfaFormat = gson.fromJson(fileReader, DFAFormat.class);
        return new DFA(dfaFormat);
    }
}