package com.raz.Custom_Query.controller;

import com.raz.Custom_Query.model.Product;
import com.raz.Custom_Query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/{id}/price")
    public String updateProductPrice(@PathVariable Long id, @RequestParam Double  price){
        productService.updateProductPrice(id, price);
        return "Price updated Successfully!";
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteProductById(id);
        return "Product Deleted Successfully!";
    }
}
