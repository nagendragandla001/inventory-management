package com.warehouse.inventory_management.service;

import com.warehouse.inventory_management.model.Product;
import com.warehouse.inventory_management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found!"));
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setCategory(product.getCategory());
        existing.setQuantity(product.getQuantity());
        existing.setPrice(product.getPrice());
        existing.setStatus(product.getStatus());
        return repository.save(existing);
    }

    public void  deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
