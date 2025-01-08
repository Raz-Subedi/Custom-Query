package com.raz.Custom_Query.service;

import com.raz.Custom_Query.model.Product;
import com.raz.Custom_Query.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    public void updateProductDetails(Long id, String name, String price, String description) {
        productRepository.updateProductDetails(id, name, price, description);
    }


    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteByIdCustom(id);
    }

    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id){
       return productRepository.findById(id);
    }
}
