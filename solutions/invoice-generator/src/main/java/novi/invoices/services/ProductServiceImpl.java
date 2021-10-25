package novi.invoices.services;

import java.util.HashMap;
import java.util.Map;

import novi.invoices.model.Product;

public class ProductServiceImpl implements ProductService {
    private Map<Integer, Product> productsDatabase = new HashMap<>();

    public ProductServiceImpl() {
        productsDatabase.put(1, new Product(1, "Product1", 10, 12.00));
        productsDatabase.put(1, new Product(1, "Product2", 2, 10.00));
        productsDatabase.put(1, new Product(1, "Product3", 0, 6.00));
        productsDatabase.put(1, new Product(1, "Product4", 7, 8.00));
        productsDatabase.put(1, new Product(1, "Product5", 1, 9.00));
    }

    @Override
    public Product getProduct(int id) {
        return productsDatabase.get(id);
    }
}
