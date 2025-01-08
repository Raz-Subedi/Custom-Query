package com.raz.Custom_Query.controller;


import com.raz.Custom_Query.model.Product;
import com.raz.Custom_Query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @GetMapping("/{name}")
//    public Product getProductByName(@PathVariable String name) {
//        return productService.getProductByName(name);
//    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String price, @RequestParam String description) {
        productService.updateProductDetails(id, name, price, description);
        return "Product updated successfully!";
    }


    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Product deleted successfully!";
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully!";
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}

