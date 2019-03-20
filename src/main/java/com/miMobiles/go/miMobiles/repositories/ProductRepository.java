package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by shrey on 3/16/2019.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getProductById(Long id);

    @Query("SELECT p from Product p WHERE p.productId = :productId")
    Product findByProductId(@Param("productId") String productId);

    @Query("SELECT p from Product p WHERE p.productId != :productId")
    List<Product> findAllExcept(@Param("productId") String productId);
}
