package src.naming;

import java.util.List;

public class InvoiceGenerator {

    public String generateInvoice(List<OrderLine> input) {
        double nt = 0;
        for (var l : input) {
            nt += l.price * l.price;
        }

        StringBuilder result = new StringBuilder();
        result.append("- - - - - - - - - - - - - -\n");
        result.append("---------------------------\n");
        result.append("-         INVOICE         -\n");
        result.append("---------------------------\n");
        result.append("- - - - - - - - - - - - - -\n");

        for (var l : input) {
            var tp = l.count * l.price;
            result.append(String.format("%s  | %dx | $%.2f\n", l.name, l.count, tp));
            result.append("---------------------------\n");
        }

        result.append("===========================\n");
        result.append(String.format("TOTAL: $ %.2f\n", nt));
        result.append("===========================\n");
        result.append("- - - - - - - - - - - - - -\n");
        result.append("             2021          \n");
        result.append("- - - - - - - - - - - - - -\n");


        return result.toString();
    }
}
