package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shrey on 3/16/2019.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getProductById(Long id);
}
