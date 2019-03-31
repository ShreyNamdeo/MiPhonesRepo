package com.miMobiles.go.miMobiles.controllers;

import com.miMobiles.go.miMobiles.dto.ProductDto;
import com.miMobiles.go.miMobiles.services.ProductService;
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

    @PutMapping
    //@Produces("application/json")
    public @ResponseBody String updateProduct(@Valid @RequestBody  ProductDto productDto){
        productService.updateProduct(productDto);
        return "{\"message\" :true}";
    }
}
