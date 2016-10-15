import java.util.Map;

public class DFAFormat {
    private String[] setOfStates;
    private String initialState;
    private String[] finalStates;
    private Integer[] setOfAlphabets;
    private Map<String, Map<String, Integer>> transition;

    public void setSetOfStates(String[] setOfStates){
        this.setOfStates = setOfStates;
    };

    public void setInitialState(String initialState){
        this.initialState = initialState;
    }

    public void setFinalStates(String[] finalStates){
        this.finalStates = finalStates;
    }

    public void setSetOfAlphabets(Integer[] setOfAlphabets){
        this.setOfAlphabets = setOfAlphabets;
    }

    public void setTransition(Map<String, Map<String, Integer>> transition){
        this.transition = transition;
    }

    public Integer[] getSetOfAlphabets() {
        return setOfAlphabets;
    }

    public String getInitialState() {
        return initialState;
    }

    public String[] getFinalStates() {
        return finalStates;
    }

    public String[] getSetOfStates() {
        return setOfStates;
    }

    public Map<String, Map<String, Integer>> getTransition() {
        return transition;
    }

    public String toString(){
        return "setOfStates="+this.setOfStates+" \nsetOfAlphabets="+this.setOfAlphabets+" \ninitialState="+initialState+" \ntransition="+transition+" \nfinalStates"+finalStates;
    }

}
