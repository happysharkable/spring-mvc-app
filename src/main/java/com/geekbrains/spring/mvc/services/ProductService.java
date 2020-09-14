package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.reposiories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void deleteById(Long id) { repository.deleteById(id); }

    public Long getAvailableId() { return repository.getAvailableId(); }
}
