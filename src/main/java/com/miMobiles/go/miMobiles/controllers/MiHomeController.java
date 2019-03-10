package com.miMobiles.go.miMobiles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shrey on 2/10/2019.
 */
@Controller
public class MiHomeController {
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
    public String productDetails(Model model){
        model.addAttribute("title","Gadget-Meter Studios");
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
