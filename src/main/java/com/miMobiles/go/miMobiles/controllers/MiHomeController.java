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
import javax.ws.rs.QueryParam;

/**
 * Created by shrey on 2/10/2019.
 */
@Controller
public class MiHomeController {
    @Autowired
    private ProductServices productServices;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
        return "login";
    }

    @RequestMapping(value = "/adminProductList")
    public String adminProductList(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
        return "AdminProductList";
    }

    @RequestMapping(value = "/productDetails")
    public String productDetails(Model model, @RequestParam("product") @DefaultValue(value = " ") String productId ){
        Product product = productServices.getByProductId(productId);
        model.addAttribute("title","Gadget-Meter Studios");
        model.addAttribute("displaySieInCm",String.format("%.2f", Float.parseFloat(product.getDisplaySize())*2.54));
        model.addAttribute(product);
        return "productDetails";
    }

    @RequestMapping(value = "/productDetailsCompare")
    public String productDetailsCompare(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
        return "productDetailsCompare";
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
        return "addProduct";
    }
}
