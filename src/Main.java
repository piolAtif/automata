import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;


public class Main {
    public static final String DOUBLE_SLASH = "\\\\";
    public static final String CHARACTER_ENCODING = "UTF-8";

    public static void main(String[] args) throws IOException {
         String content = ReadFile(args[0]);
        String withoutEscapeCharacter = content.replaceAll(DOUBLE_SLASH, "");
        String substring = withoutEscapeCharacter.substring(2, withoutEscapeCharacter.length() - 2);
        isPassed(substring);
    }

    private static String ReadFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);
        String str = new String(data, CHARACTER_ENCODING);
        fileInputStream.close();
        return str;
    }

    private static void isPassed(String array_of_string) {
        String[] split = array_of_string.split("[,][{]");
        for (int index = 0; index < split.length; index++) {
            if (index != 0) {
                split[index] = "{".concat(split[index]);
            }
            Machine machine = dfaForTouple().fromJson(split[index], Machine.class);
            System.out.println(isMachinePassedCases(machine));
        }
    }

    private static Gson dfaForTouple(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Machine.class, new MachineDeserialiser());
        gsonBuilder.registerTypeAdapter(Tuple.class, new TupleDeserialiser());
        Gson gson = gsonBuilder.create();
        return gson;
    }

    private static String isMachinePassedCases(Machine machine) {
            DFA dfa = new DFA(machine);
            if(!dfa.passed())
                return dfa.machineName()+" : failed";
        return dfa.machineName()+" : passed";
    }
}
