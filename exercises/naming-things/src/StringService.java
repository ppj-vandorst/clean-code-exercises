package src;

public class StringService {
    public String formatA(String i, Boolean flag) {
        i = i.replaceAll(" ", "_");
        if (flag) {
            i.trim();
        }
        return i;
    }

    public String formatb(String i, Boolean flag) {
        i = i.replaceAll(" ", "-");
        if (flag) {
            i.trim();
        }
        return i;
    }

    public String formatc(String i, Boolean flag) {
        i = i.replaceAll(" ", "");
        if (flag) {
            i.trim();
        }
        return i;
    }
}
