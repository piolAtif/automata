import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.util.*;

public class DFA<Q, A>{

    private final Q[] setOfStages;
    private final A[] setOfAlphabets;
    private final HashMap<Q, HashMap<Q, A>> transitionFunction;
    private final Q initialStage;
    private final ArrayList<Q> finalStatges;

    public DFA(Q[] setOfStages, A[] setOfAlphabets, HashMap<Q, HashMap<Q, A>> transitionFunction, Q initialStage, ArrayList<Q> finalStatges) {
        this.setOfStages = setOfStages;
        this.setOfAlphabets = setOfAlphabets;
        this.transitionFunction = transitionFunction;
        this.initialStage = initialStage;
        this.finalStatges = finalStatges;
    }

    public boolean accepts(A[] setOfInput) {
        Q q = initialStage;
        for (A input:setOfInput){
            q = transition(q, input);
        }
        return finalStatges.contains(q);
    }


    private Q transition(Q stage, A input) {
        HashMap<Q, A> qaHashMap = new HashMap<>();
        qaHashMap.put(stage,input);
        for (Map.Entry<Q, HashMap<Q, A>> entry:transitionFunction.entrySet()){
            if(entry.getValue().containsKey(stage)) {
                if (entry.getValue().get(stage).equals(input))
                    return entry.getKey();
            }
        }
        return null;
    };
}
