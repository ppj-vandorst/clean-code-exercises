package src.methods;

import java.util.List;

public class ListFilter {
    public boolean filterFromList(List<String> list, String searchItem) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(searchItem)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            list.remove(index);
            return true;
        }
        return false;
    }
}