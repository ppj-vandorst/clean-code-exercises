package novi.invoices;

import novi.invoices.dto.OrderRequestDto;
import novi.invoices.services.EmailService;
import novi.invoices.services.EmailServiceImpl;
import novi.invoices.services.ProductService;
import novi.invoices.services.ProductServiceImpl;
import novi.invoices.services.TextFileGenerator;

/**
 * Wanneer een ‘OrderRequest’ binnenkomt wordt hier een order van gemaakt, een
 * factuur opgeslagen en wordt deze naar de gebruiker gemaild
 * 
 * De order wordt aangemaakt met een correct totaalbedrag + verzendkosten (3.95)
 * 
 * De factuur wordt als .txt bestand opgeslagen in het systeem
 * 
 * De voorraad van de gekozen producten wordt automatisch afgeboekt
 * 
 * Wanneer de gebruiker een producthoeveelheid < 1 probeert te bestellen wordt
 * er een exceptie gegooid.
 * 
 * Wanneer de gebruiker meer probeert te bestellen dan er voorraad is wordt er
 * een exceptie gegooid.
 * 
 */

public class OrderService {
    private EmailService emailService;
    private ProductService productService;
    private TextFileGenerator textFileGenerator;

    public OrderService() {
        this.emailService = new EmailServiceImpl();
        this.productService = new ProductServiceImpl();
        this.textFileGenerator = new TextFileGenerator();
    }

    public void processOrderRequest(OrderRequestDto request) {
        // Process order request
    }

}