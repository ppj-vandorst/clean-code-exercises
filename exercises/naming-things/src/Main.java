package src;

import java.util.List;

import src.naming.ListDeduplicator;

public class Main {
    public static void main(String[] args) {
        // InvoiceGenerator generator = new InvoiceGenerator();
        // String invoice = generator.generateInvoice(List.of(new OrderLine("prod1",
        // 12.99, 3),
        // new OrderLine("prod2", 10.99, 2), new OrderLine("prod1", 15.00, 10)));
        // System.out.println(invoice);

        ListDeduplicator cleaner = new ListDeduplicator();
        List<String> result = cleaner.removeDuplicates(List.of("a", "b", "c", "d", "e", "b", "c", "f"));
        System.out.println(result);
    }
}
