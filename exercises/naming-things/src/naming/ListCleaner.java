package src.naming;

import java.util.ArrayList;
import java.util.List;

public class ListCleaner {
    public List<String> clean(List<String> l) {
        var l2 = new ArrayList<String>(l.size());
        for (String s : l) {
            var match = false;
            for (String value : l2) {
                if (value.equals(s)) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                l2.add(s);
            }
        }
        return l2;
    }
}
