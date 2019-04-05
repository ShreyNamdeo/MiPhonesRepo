package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shrey on 3/21/2019.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findByProductDbId(Long productDbId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ProductImage set thumbnailKey =:thumbnailKey where mediaKey =:videoName")
    void updateProductVideoSetThumbnail(@Param("videoName") String videoName, @Param("thumbnailKey") String mediakey);
}
