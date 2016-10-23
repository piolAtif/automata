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
        for (Map.Entry<String, HashMap<String, String>> entry : machineFormat.getTouple().getDelta().entrySet()) {
            if (entry.getKey().equals(currentState) &&entry.getValue().containsKey(input)) {
               return entry.getValue().get(input);
            }
        }
        return null;
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

