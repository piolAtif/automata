import com.google.gson.JsonArray;

import java.util.Map;

public class Machine {
    private String name;
    private String type;
    private Tuple tuple;
    private String[] pass_cases;
    private String[] fail_cases;
    private String[] fin;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTuple(Tuple tuple) {
        this.tuple = tuple;
    }

    public void setPassCases(String[] passCases) {
        this.pass_cases = passCases;
    }

    public void setFailCases(String[] failCases) {
        this.fail_cases = failCases;
    }

    public Tuple getTouple() {
        return tuple;
    }

    public String[] getPassCases() {
        return pass_cases;
    }

}
