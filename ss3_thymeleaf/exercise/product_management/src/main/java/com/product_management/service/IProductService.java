package com.product_management.service;

import com.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void saveProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product getProductById(int id);

    Product searchProductByName(String name);
}
