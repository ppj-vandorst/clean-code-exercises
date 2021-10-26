package novi.invoices.services;

import java.util.HashMap;
import java.util.Map;

import novi.invoices.model.Product;

public class ProductServiceImpl implements ProductService {
    private Map<Integer, Product> productsDatabase = new HashMap<>();

    public ProductServiceImpl() {
        productsDatabase.put(1, new Product(1, "Product1", 10, 12.00));
        productsDatabase.put(1, new Product(2, "Product2", 2, 10.00));
        productsDatabase.put(1, new Product(3, "Product3", 0, 6.00));
        productsDatabase.put(1, new Product(4, "Product4", 7, 8.00));
        productsDatabase.put(1, new Product(5, "Product5", 1, 9.00));
    }

    @Override
    public Product getProduct(int id) {
        return productsDatabase.get(id);
    }

    public void setProductStock(int productId, int newStock) {
        var product = productsDatabase.get(productId);
        if (product == null) {
            throw new RuntimeException(String.format("Product with id %d does not exist", productId));
        }

        if (newStock < 0) {
            throw new RuntimeException(
                    String.format("Could not update product stock as an invalid value was provided: ", newStock));
        }

        product.setStock(newStock);
    }
}
