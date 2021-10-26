public class Customer {
    private String firstname;
    private String lastname;

    static Customer anonymous() {
        return new Customer();
    }

    static Customer known(String firstname, String lastname) {
        return new Customer(firstname, lastname);
    }

    private Customer() {
    }

    private Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

class Main{
    public static void main(String[] args) {
        Customer anonymousCustomer = Customer.anonymous();
        Customer knownCustomer = Customer.known("john", "doe");
    }
}