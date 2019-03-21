package com.miMobiles.go.miMobiles.services;

import com.miMobiles.go.miMobiles.dto.ProductMediaDto;
import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.repositories.ProductImageRepository;
import com.miMobiles.go.miMobiles.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrey on 3/17/2019.
 */
@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getByProductId(String productId){
        return productRepository.findByProductId(productId);
    }

    public List<Product> getAllProductsExcept(String productId) {
        return productRepository.findAllExcept(productId);
    }

    public List<ProductMediaDto> getAllMediaForProductById(Long productDbId){
        List<ProductImage> productMediaList = productImageRepository.findByProductDbId(productDbId);
        List<ProductMediaDto> productMediaDtos = new ArrayList<>();
        for (int i=0;i<productMediaList.size();i++){
            productMediaDtos.add(new ProductMediaDto(productMediaList.get(i),i+1));
        }
        return productMediaDtos;
    }
}
