package com.raz.Custom_Query.repository;

import com.raz.Custom_Query.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 1. Custom Query to Fetch All Products
    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    // 2. Custom Query to Fetch Product by Name
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findByName(@Param("name") String name);

    // 3. Custom Query to Update Product Price
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :name, p.price = :price, p.description = :description WHERE p.id = :id")
    void updateProductDetails(@Param("id") Long id, @Param("name") String name, @Param("price") String price, @Param("description") String description);


    // 4. Custom Query to Delete a Product by ID
    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteByIdCustom(@Param("id") Long id);
}

