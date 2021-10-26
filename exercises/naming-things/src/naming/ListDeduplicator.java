package src.naming;

import java.util.ArrayList;
import java.util.List;

public class ListDeduplicator {
    public List<String> removeDuplicates(List<String> inputList) {
        var resultList = new ArrayList<String>(inputList.size());

        for (String inputItem : inputList) {
            if (!includesItem(resultList, inputItem)) {
                resultList.add(inputItem);
            }
        }
        return resultList;
    }

    private boolean includesItem(List<String> inputList, String searchItem) {
        for (String value : inputList) {
            if (value.equals(searchItem)) {
                return true;
            }
        }
        return false;
    }

    private void generateInvoiceWithHeader() {
        // generate invoice
    }

    private void generateInvoiceWithoutHeader() {
        // generate invoice
    }

   public void doStuff() {
       this.generateInvoiceWithHeader();
   }
}
