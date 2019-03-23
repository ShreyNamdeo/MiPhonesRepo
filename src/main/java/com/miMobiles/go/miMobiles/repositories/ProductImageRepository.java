package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by shrey on 3/21/2019.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findByProductDbId(Long productDbId);
}
