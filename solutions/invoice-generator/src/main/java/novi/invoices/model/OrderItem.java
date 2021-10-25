package novi.invoices.model;

public class OrderItem {
    private int count;
    private Product product;

    public OrderItem(Product product, int count) {
        this.setProduct(product);
        this.setCount(count);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}