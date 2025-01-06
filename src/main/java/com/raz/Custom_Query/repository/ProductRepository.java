package com.raz.Custom_Query.repository;

import com.raz.Custom_Query.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    // 1. Custom Query to Fetch All Products
    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    // 2. Custom Query to Fetch Product by Name
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findByName(@Param("name") String name);

    // 3. Custom Query to Update Product Price
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    void updatePrice(@Param("id") Long id, @Param("price") Double price);

    // 4. Custom Query to Delete a Product by ID
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteByIdCustom(@Param("id") Long id);
}
