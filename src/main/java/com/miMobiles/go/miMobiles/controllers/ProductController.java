package com.miMobiles.go.miMobiles.controllers;

import com.miMobiles.go.miMobiles.dto.ProductDto;
import com.miMobiles.go.miMobiles.services.ProductService;
import com.miMobiles.go.miMobiles.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Produces;

/**
 * Created by shrey on 3/31/2019.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductServices productServices;

    @PutMapping
    //@Produces("application/json")
    public @ResponseBody String updateProduct(@Valid @RequestBody  ProductDto productDto){
        productService.updateProduct(productDto);
        return "{\"message\" :true}";
    }

    @DeleteMapping("/{productId}")
    public @ResponseBody String deleteProduct(@PathVariable("productId") String productId){
        productServices.deleteProduct(productId);
        return "{\"message\" :true}";
    }

    @DeleteMapping("/media/{mediaId}")
    public @ResponseBody String deleteProductMediaById(@PathVariable("mediaId") Long mediaId){
        productServices.deleteProductMediaById(mediaId);
        return "{\"message\" :true}";
    }
}
