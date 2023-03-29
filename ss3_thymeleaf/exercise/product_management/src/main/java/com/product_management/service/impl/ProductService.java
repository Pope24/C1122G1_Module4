package com.product_management.service.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product searchProductByName(String name) {
        List<Product> productList = productRepository.findAll();
        for (Product product: productList) {
            if (product.getNameProduct().equals(name)) return product;
        }
        return null;
    }
}
