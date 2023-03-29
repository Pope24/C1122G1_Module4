package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1, new Product(1, "Iphone", 1500, "Public in American", "Steveb Job"));
        products.put(2, new Product(2, "Samsung", 2300, "Public in Korean", "Chew Jung"));
        products.put(3, new Product(3, "Xiaomi", 900, "Public in China", "Jack Ma"));
        products.put(4, new Product(4, "Nokia", 1800, "Public in China", "Forbes"));
        products.put(5, new Product(5, "Redmi", 1200, "Public in Viet Nam", "Van Chinh"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }
}
