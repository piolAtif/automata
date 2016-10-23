import java.util.HashMap;

public class Tuple {
    private String[] states;
    private String start_state;
    private String[] final_states;
    private HashMap<String , HashMap<String, String>> delta;
    private String[] alphabets;


    public void setStates(String[] states) {
        this.states = states;
    }

    public void setStartState(String startState) {
        this.start_state = startState;
    }

    public void setFinalStates(String[] finalStates) {
        this.final_states = finalStates;
    }

    public void setAlphabets(String[] alphabets) {
        this.alphabets = alphabets;
    }

    public void setDelta(HashMap<String,HashMap<String,String>> delta) {
        this.delta = delta;
    }

    public String getStartState() {
        return start_state;
    }

    public HashMap<String, HashMap<String, String>> getDelta() {
        return delta;
    }

    public String[] getFinalstates() {
        return final_states;
    }
}
