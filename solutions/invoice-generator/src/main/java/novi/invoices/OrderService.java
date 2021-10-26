package novi.invoices;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import novi.invoices.dto.OrderItemInputDto;
import novi.invoices.dto.OrderRequestDto;
import novi.invoices.model.Order;
import novi.invoices.model.OrderItem;
import novi.invoices.model.Product;
import novi.invoices.services.EmailService;
import novi.invoices.services.EmailServiceImpl;
import novi.invoices.services.ProductService;
import novi.invoices.services.ProductServiceImpl;
import novi.invoices.services.TextFileGenerator;

public class OrderService {
    private EmailService emailService;
    private ProductService productService;
    private TextFileGenerator textFileGenerator;
    private InvoiceBuilder invoiceBuilder;

    public OrderService() {
        this.emailService = new EmailServiceImpl();
        this.productService = new ProductServiceImpl();
        this.textFileGenerator = new TextFileGenerator();
        this.invoiceBuilder = new InvoiceBuilder();
    }

    public void processOrderRequest(OrderRequestDto request) {
        try {
            Order order = generateOrder(request.items);
            String invoice = invoiceBuilder.buildInvoice(order);
            storeInvoice(order.getOrderNumber(), invoice);
            notifyUser(request.customerEmail, invoice);
        } catch (RuntimeException e) {
            throw new RuntimeException("Processing of order request failed", e);
        }
    }

    private Order generateOrder(List<OrderItemInputDto> items) {
        List<OrderItem> orderItems = items.stream().map(this::toOrderItem).collect(Collectors.toList());
        return new Order(UUID.randomUUID().toString(), new Date(), orderItems);
    }

    private OrderItem toOrderItem(OrderItemInputDto input) {
        if (input.count < 1) {
            throw new RuntimeException(String.format("The given product count is invalid: %d", input.count));
        }

        Product product = this.productService.getProduct(input.productId);
        if (product == null) {
            throw new RuntimeException(String.format("The product with id %d does not exist", input.productId));
        }
        
        if (product.getStock() < input.count) {
            throw new RuntimeException(
                    String.format("The product with id %d does not have enough stock: requested: %d, stock: %d",
                            product.getId(), input.count, product.getStock()));
        }

        return new OrderItem(product, input.count);
    }

    private void storeInvoice(String orderNumber, String invoice) {
        try {
            textFileGenerator.generateFile("./invoices", orderNumber, invoice);
        } catch (IOException e) {
            throw new RuntimeException("Storing of invoice file failed", e);
        }
    }

    private void notifyUser(String customerEmail, String invoice) {
        emailService.sendEmail(customerEmail, invoice);
    }
}