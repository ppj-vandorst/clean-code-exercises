package novi.invoices.services;

public class EmailServiceImpl implements EmailService {
    public void sendEmail(String receiver, String message) {
        System.out.println("---------EMAIL---------");
        System.out.printf("From: %s\n", "novi@invoicing.com");
        System.out.printf("To: %s\n", receiver);
        System.out.printf("Message: \n%s\n", message);
        System.out.println("-----------------------");
    }
}
