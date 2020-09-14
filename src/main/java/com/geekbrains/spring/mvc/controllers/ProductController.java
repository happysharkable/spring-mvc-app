package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("allProducts", service.getAllProducts());
        return "products";
    }

    @PostMapping("/add")
    public String addNewProduct(@RequestParam String title, @RequestParam int cost) {
        Product product = new Product(service.getAvailableId(), title, cost);
        service.add(product);
        return "redirect:/products/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/products/all";
    }
}