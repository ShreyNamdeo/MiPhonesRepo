package com.miMobiles.go.miMobiles.controllers;

import doryan.windowsnotificationapi.fr.Notification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.net.MalformedURLException;

/**
 * Created by shrey on 2/10/2019.
 */
@Controller
public class MiHomeController {
    @RequestMapping(value = "")
    public String index(Model model){
        try {
            Notification.sendNotification("This is index called", "Some good details here", TrayIcon.MessageType.NONE);
        } catch (AWTException | MalformedURLException e) {
            e.printStackTrace();
        }
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
