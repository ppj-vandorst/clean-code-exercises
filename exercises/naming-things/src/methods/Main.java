package src.methods;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ListFilter filter = new ListFilter();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        boolean result = filter.filterFromList(list, "c");
        
        System.out.println(list);
        System.out.println(result);  
    }

}
