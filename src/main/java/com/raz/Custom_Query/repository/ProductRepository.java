package com.raz.Custom_Query.repository;

import com.raz.Custom_Query.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();


    @Query("SELECT p FROM Product p WHERE p.name = :n")
    List<Product> findByName(@Param("n") String name);

    @Query(value="SELECT * FROM Product", nativeQuery = true)
    List<Product> getProducts();


    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :name, p.price = :price, p.description = :description WHERE p.id = :id")
    void updateProductDetails(@Param("id") Long id, @Param("name") String name, @Param("price") String price, @Param("description") String description);


    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteByIdCustom(@Param("id") Long id);
}

