package com.miMobiles.go.miMobiles.services;

import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shrey on 3/17/2019.
 */
@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getByProductId(String productId){
        return productRepository.findByProductId(productId);
    }
}
