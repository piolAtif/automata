import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.Scriptable;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class DFA {


    private DFAFormat dfaFormat;

    public DFA(DFAFormat dfaFormat) {
        this.dfaFormat = dfaFormat;
    }

    public boolean accepts(Integer[] setOfInput) {
        String currentState = dfaFormat.getInitialState();
        for (Integer input : setOfInput) {
            currentState = transition(input, currentState);
        }
        return hasFinalStatesContainCurrentState(dfaFormat.getFinalStates(),currentState);
    }

    private boolean hasFinalStatesContainCurrentState(String[] finalStates, String currentState) {
        for (int index = 0; index < finalStates.length; index++) {
            if(finalStates[index].equals(currentState))
                return true;
        }
        return false;
    }

    private String transition(Integer input, String currentState) {
        HashMap<String, Integer> qaHashMap = new HashMap<>();
        qaHashMap.put(currentState, input);
        for (Map.Entry<String, Map<String, Integer>> entry : dfaFormat.getTransition().entrySet()) {
            if (entry.getValue().containsKey(currentState)) {
                if (entry.getValue().get(currentState).equals(input))
                    return entry.getKey();
            }
        }
        return null;
    }
}

