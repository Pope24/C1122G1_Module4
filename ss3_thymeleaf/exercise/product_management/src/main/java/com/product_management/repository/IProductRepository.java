package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void saveProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product getProductById(int id);
}
