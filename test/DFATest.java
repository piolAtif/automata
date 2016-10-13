import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DFATest {
    @Test
    public void should_pass_string_1(){
        ArrayList<String> FinalStages = new ArrayList<>();
        FinalStages.add("q2");
        HashMap<String, HashMap<String, Integer>> transitionFunction = new HashMap<>();
        HashMap<String, Integer> value1 = new HashMap<>();
        value1.put("q1",0);
        value1.put("q2",0);
        HashMap<String, Integer>value2 = new HashMap<>();
        value2.put("q1",1);
        value2.put("q2",1);
        transitionFunction.put("q1",value1);
        transitionFunction.put("q2", value2);
        String setOfStages[] = {"q1","q2"};
        Integer setOfAlphabets[] = {0,1};
        DFA<String, Integer> dfa = new DFA<>(setOfStages, setOfAlphabets,transitionFunction,"q1", FinalStages);
        Integer setOfAlphabet[] = {1,0,1,0,0,1};
        assertTrue(dfa.accepts(setOfAlphabet));
    }

    @Test
    public void should_pass_string_begin_with_1_and_contains_001(){
        String setOfStages[] = {"q1","q2","q3","q4","q5","q6","q7"};
        Integer setOfAlphabets[] = {1,0};
        ArrayList<String> finalStages = new ArrayList<>();
        finalStages.add("q6");
        finalStages.add("q7");
        HashMap<String, HashMap<String, Integer>> transitionFunction = new HashMap<>();
        HashMap<String, Integer> value1 = new HashMap<>();
        value1.put("q1",0);
        HashMap<String, Integer> value2 = new HashMap<>();
        value2.put("q1",1);
        HashMap<String, Integer> value3 = new HashMap<>();
        value3.put("q2",0);
        value3.put("q4",0);
        HashMap<String, Integer> value4 = new HashMap<>();
        value4.put("q2",1);
        value4.put("q3",1);
        value4.put("q4",1);
        HashMap<String, Integer> value5 = new HashMap<>();
        value5.put("q3",0);
        value5.put("q5",0);
        HashMap<String, Integer> value6 = new HashMap<>();
        value6.put("q5",1);
        value6.put("q6",0);
        value6.put("q7",1);
        HashMap<String, Integer> value7 = new HashMap<>();
        value7.put("q6",1);
        value7.put("q7",0);
        transitionFunction.put("q1",value1);
        transitionFunction.put("q2",value2);
        transitionFunction.put("q3",value3);
        transitionFunction.put("q4",value4);
        transitionFunction.put("q5",value5);
        transitionFunction.put("q6", value6);
        transitionFunction.put("q7", value7);

        DFA<String, Integer> dfa = new DFA<>(setOfStages, setOfAlphabets, transitionFunction, "q1", finalStages);
        Integer setOfInput[] = {1,0,0,1,1,0,0,1};
        assertTrue(dfa.accepts(setOfInput));
        Integer setOfInput2[] = {1,0,0,1};
        assertTrue(dfa.accepts(setOfInput2));
        Integer setOfInput3[] = {1,1,0,1,0};
        assertFalse(dfa.accepts(setOfInput3));
    }

    @Test
    public void should_pass_string_which_decimal_is_a_even_number(){
        String setOfStages[] = {"q1","q2"};
        Integer setOfAlphabets[] = {0,1};
        ArrayList<String> finalStages = new ArrayList<>();
        finalStages.add("q2");
        HashMap<String, HashMap<String, Integer>> transitionFunction = new HashMap<>();
        HashMap<String, Integer> value1 = new HashMap<>();
        value1.put("q1",1);
        value1.put("q2",1);
        HashMap<String, Integer>value2 = new HashMap<>();
        value2.put("q1",0);
        value2.put("q2",0);
        transitionFunction.put("q1",value1);
        transitionFunction.put("q2",value2);
        DFA<String, Integer> dfa = new DFA<>(setOfStages, setOfAlphabets,transitionFunction,"q1", finalStages);
        Integer setOfInput[] = {1,0,0,0,1,0};
        Integer setOfInput1[] = {1,0,1,0,1};
        assertTrue(dfa.accepts(setOfInput));
        assertFalse(dfa.accepts(setOfInput1));
    }

    @Test
    public void should_pass_string_which_is_power_of_two(){
        String setOfStages[] = {"q1","q2","q3","q4"};
        Integer setOfAlphabets[] = {0,1};
        ArrayList<String> finalStages = new ArrayList<>();
        finalStages.add("q2");
        HashMap<String, HashMap<String, Integer>> transitionFunction = new HashMap<>();
        HashMap<String, Integer> value1 = new HashMap<>();
        value1.put("q1",1);
        value1.put("q2",0);
        value1.put("q3",1);
        HashMap<String, Integer> value2 = new HashMap<>();
        value2.put("q1",0);
        value2.put("q3",0);
        HashMap<String, Integer> value3 = new HashMap<>();
        value3.put("q2",1);
        transitionFunction.put("q2",value1);
        transitionFunction.put("q3",value2);
        transitionFunction.put("q4",value3);
        DFA<String, Integer> dfa = new DFA<>(setOfStages, setOfAlphabets,transitionFunction,"q1", finalStages);
        Integer setOfInput[] = {1,0,0,0,0};
        Integer setOfInput2[] = {0,1};
        assertTrue(dfa.accepts(setOfInput));
        assertTrue(dfa.accepts(setOfInput2));
        Integer setOfInput3[] = {0,1,0,0,1,0};
        assertFalse(dfa.accepts(setOfInput3));
    }
}