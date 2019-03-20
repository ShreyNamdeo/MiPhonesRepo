package com.miMobiles.go.miMobiles.controllers;

import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.repositories.ProductRepository;
import com.miMobiles.go.miMobiles.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.DefaultValue;
import java.util.List;

/**
 * Created by shrey on 2/10/2019.
 */
@Controller
public class MiHomeController {
    private  static String title = "Gadget-Meter Studios";
    @Autowired
    private ProductServices productServices;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title",title);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("title",title);
        return "login";
    }

    @RequestMapping(value = "/adminProductList")
    public String adminProductList(Model model){
        model.addAttribute("title",title);
        return "AdminProductList";
    }

    @RequestMapping(value = "/productDetails")
    public String productDetails(Model model, @RequestParam("product") @DefaultValue(value = " ") String productId ){
        model.addAttribute("title",title);
        Product product = productServices.getByProductId(productId);
        List<Product> productsExceptSelected = productServices.getAllProductsExcept(productId);
        model.addAttribute("displaySieInCm",String.format("%.2f", Float.parseFloat(product.getDisplaySize())*2.54));
        model.addAttribute(product);
        model.addAttribute("prods",productsExceptSelected);
        return "productDetails";
    }

    @RequestMapping(value = "/productDetailsCompare")
    public String productDetailsCompare(Model model, @RequestParam("q1") @DefaultValue(value = " ") String productId1,
                                        @RequestParam("q2") @DefaultValue(value = " ") String productId2){
        model.addAttribute("title",title);
        Product product1 = productServices.getByProductId(productId1);
        Product product2 = productServices.getByProductId(productId2);
        return "productDetailsCompare";
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model){
        model.addAttribute("title",title);
        return "addProduct";
    }
}
