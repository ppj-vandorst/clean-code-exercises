package novi.invoices.services;

import novi.invoices.model.Product;

public interface ProductService {
    Product getProduct(int id);

    void setProductStock(int productId, int newStock);
}
