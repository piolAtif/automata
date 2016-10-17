import java.util.*;

public class DFA {


    private Machine machineFormat;

    public DFA(Machine machineFormat) {
        this.machineFormat = machineFormat;
    }

    public boolean passed() {
        for (String input : machineFormat.getPassCases()) {
            if(!isCasePassed(input))
                return false;
        }
        return true;
    }

    private boolean hasFinalStatesContainCurrentState(String[] finalStates, String currentState) {
        for (int index = 0; index < finalStates.length; index++) {
            if(finalStates[index].equals(currentState))
                return true;
        }
        return false;
    }

    private String transition(String input, String currentState) {
        HashMap<String, String> qaHashMap = new HashMap<>();
        qaHashMap.put(currentState, input);
        for (Map.Entry<String, HashMap<String, String>> entry : machineFormat.getTouple().getDelta().entrySet()) {
            if (entry.getValue().containsKey(input)) {
               String stage =  entry.getValue().get(input);
                 if(stage.length()>2) {
                     String[] stages = stage.split(",");
                     if (hasElement(stages, currentState))
                         return entry.getKey();
                 }
                else if (stage.equals(currentState))
                    return entry.getKey();
            }
        }
        return null;
    }

    private boolean hasElement(String[] stages, String currentState) {
        for (int index = 0; index < stages.length; index++) {
            if(stages[index].equals(currentState))
                return true;
        }
        return false;
    }

    private boolean isCasePassed(String input) {
       String currentState = machineFormat.getTouple().getStartState();
       String[] elements = input.split("");
       for (int index = 1; index < elements.length; index++) {
           currentState = transition(elements[index], currentState);
       }
       return hasFinalStatesContainCurrentState(machineFormat.getTouple().getFinalstates(), currentState);
   }

}

