package src.methods;

import java.util.List;

import src.naming.OrderLine;

public class InvoiceGenerator {

    public String generateInvoice(List<OrderLine> orderLines) {
        double orderTotal = calculateTotal(orderLines);

        StringBuilder result = new StringBuilder();
        result.append(generateInvoiceHeader());
        result.append(generateInvoiceOrderLines(orderLines));
        result.append(generateInvoiceFooter(orderTotal));
        return result.toString();
    }

    private double calculateTotal(List<OrderLine> orderLines) {
        double total = 0;
        for (var line : orderLines) {
            total += line.price * line.count;
        }
        return total;
    }

    private String generateInvoiceHeader() {
        StringBuilder result = new StringBuilder();
        result.append("- - - - - - - - - - - - - -\n");
        result.append("---------------------------\n");
        result.append("-         INVOICE         -\n");
        result.append("---------------------------\n");
        result.append("- - - - - - - - - - - - - -\n");
        return result.toString();
    }

    private String generateInvoiceFooter(double orderTotal) {
        StringBuilder result = new StringBuilder();
        result.append("===========================\n");
        result.append(String.format("TOTAL: $ %.2f\n", orderTotal));
        result.append("===========================\n");
        result.append("- - - - - - - - - - - - - -\n");
        result.append("             2021          \n");
        result.append("- - - - - - - - - - - - - -\n");
        return result.toString();
    }

    private String generateInvoiceOrderLines(List<OrderLine> orderLines) {
        StringBuilder result = new StringBuilder();

        for (var line : orderLines) {
            var total = line.count * line.price;
            result.append(String.format("%s  | %dx | $%.2f\n", line.name, line.count, total));
        }

        return result.toString();
    }
}

class Main2 {
    public static void main(String[] args) {
        InvoiceGenerator generator = new InvoiceGenerator();
        String invoice = generator.generateInvoice(List.of(new OrderLine("product1", 10, 3),
                new OrderLine("product2", 5, 2), new OrderLine("product1", 3, 1)));

        System.out.println(invoice);
    }
}
