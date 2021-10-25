package novi.invoices;

import novi.invoices.dto.OrderRequestDto;
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
        // Process order request
    }

}