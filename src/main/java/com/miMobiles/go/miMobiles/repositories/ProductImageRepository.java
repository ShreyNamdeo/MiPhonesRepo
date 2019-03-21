package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shrey on 3/21/2019.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findByProductDbId(Long productDbId);
}
