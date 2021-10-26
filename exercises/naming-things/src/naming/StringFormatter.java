package src.naming;

public class StringFormatter {
    public String replaceSpacesWith(String inputString, String replacement) {
        inputString = inputString.replaceAll(" ", replacement);
        return inputString;
    }
}

class Main {
    public static void main(String[] args) {
        StringFormatter formatter = new StringFormatter();
        String inputString = "this is a test     ".trim();
        String result = formatter.replaceSpacesWith(inputString, "_");
        System.out.println(result);
    }
}