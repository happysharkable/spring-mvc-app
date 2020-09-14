package com.geekbrains.spring.mvc.reposiories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;
    private Long maxId;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.addAll(Arrays.asList(
                new Product(1L, "Кроссовки Nike", 5999),
                new Product(2L, "Кроссовки Reebok", 4999),
                new Product(3L, "Кроссовки Asics", 7999),
                new Product(4L, "Кроссовки Puma", 3999),
                new Product(5L, "Кроссовки Москва", 999)
        ));
        maxId = products.size() + 1L;
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }

        throw new RuntimeException("Product not found");
    }

    public void add(Product product) {
        products.add(product);
        maxId++;
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public Long getAvailableId() {
        return maxId.longValue();
    }
}
