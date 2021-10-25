package novi.invoices;

import java.util.List;

import novi.invoices.model.Order;
import novi.invoices.model.OrderItem;

public class InvoiceBuilder {

    public String buildInvoice(Order order) {
        var orderTotal = calculateOrderTotal(order.getItems());

        StringBuilder invoiceBuilder = new StringBuilder();
        invoiceBuilder.append(generateHeader());
        invoiceBuilder.append(formatOrderLines(order.getItems()));
        invoiceBuilder.append(generateTotalSection(orderTotal));
        invoiceBuilder.append(generateFooter());

        return invoiceBuilder.toString();
    }

    public String generateHeader() {
        StringBuilder headerBuilder = new StringBuilder();

        headerBuilder.append("- - - - - - - - - - - - - -\n");
        headerBuilder.append("---------------------------\n");
        headerBuilder.append("-         INVOICE         -\n");
        headerBuilder.append("---------------------------\n");
        headerBuilder.append("- - - - - - - - - - - - - -\n");

        return headerBuilder.toString();
    }

    public String formatOrderLines(List<OrderItem> orderLines) {
        var linesBuilder = new StringBuilder();

        for (var line : orderLines) {
            var totalPrice = line.getCount() * line.getProduct().getPrice();
            linesBuilder.append(String.format("%s  | %dx | $%.2f\n", line.getProduct().getName(), line.getCount(), totalPrice));
            linesBuilder.append("---------------------------\n");
        }

        return linesBuilder.toString();
    }

    public double calculateOrderTotal(List<OrderItem> orderLines) {
        var total = 0;
        for (var line : orderLines) {
            total += line.getProduct().getPrice() * line.getCount();
        }

        return total;
    }

    public String generateTotalSection(double total) {
        var sectionBuilder = new StringBuilder();

        sectionBuilder.append("===========================\n");
        sectionBuilder.append(String.format("TOTAL: $ %.2f\n", total));
        sectionBuilder.append("===========================\n");

        return sectionBuilder.toString();
    }

    private String generateFooter() {
        var footerBuilder = new StringBuilder();

        footerBuilder.append("- - - - - - - - - - - - - -\n");
        footerBuilder.append("             2021          \n");
        footerBuilder.append("- - - - - - - - - - - - - -\n");

        return footerBuilder.toString();
    }
}
