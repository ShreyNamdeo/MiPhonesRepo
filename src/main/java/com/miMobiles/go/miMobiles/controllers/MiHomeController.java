package com.miMobiles.go.miMobiles.controllers;

import com.miMobiles.go.miMobiles.dto.ProductDto;
import com.miMobiles.go.miMobiles.dto.ProductMediaDto;
import com.miMobiles.go.miMobiles.dto.UserDto;
import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.User;
import com.miMobiles.go.miMobiles.services.ProductServices;
import com.miMobiles.go.miMobiles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.DefaultValue;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by shrey on 2/10/2019.
 */
@Controller
public class MiHomeController {
    private  static String title = "DigitalSunrisers.com";
    @Autowired
    private ProductServices productServices;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title",title);
        List<ProductDto> top8Products = productServices.getTop8Products();
        model.addAttribute("productList",top8Products);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("title",title);
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @RequestMapping(value = "/adminProductList")
    public String adminProductList(Model model){
        model.addAttribute("title",title);
        List<ProductDto> products = productServices.getAllProductsWithMedia();
        model.addAttribute("productList",products);
        return "AdminProductList";
    }

    @RequestMapping(value = "/productDetails")
    public String productDetails(Model model, @RequestParam("product") @DefaultValue(value = " ") String productId ){
        model.addAttribute("title",title);
        Product product = productServices.getByProductId(productId);
        List<ProductMediaDto> productMediaList = productServices.getAllMediaForProductById(product.getId());
        List<Product> productsExceptSelected = productServices.getAllProductsExcept(productId);
        model.addAttribute("displaySieInCm",String.format("%.2f", Float.parseFloat(product.getDisplaySize())*2.54));
        model.addAttribute(product);
        model.addAttribute("productMediaList",productMediaList);
        model.addAttribute("prods",productsExceptSelected);
        return "productDetails";
    }

    @RequestMapping(value = "/productDetailsCompare")
    public String productDetailsCompare(Model model, @RequestParam("q1") @DefaultValue(value = " ") String productId1,
                                        @RequestParam("q2") @DefaultValue(value = " ") String productId2){
        model.addAttribute("title",title);
        Product product1 = productServices.getByProductId(productId1);
        model.addAttribute("displaySie1InCm",String.format("%.2f", Float.parseFloat(product1.getDisplaySize())*2.54));
        List<ProductMediaDto> product1MediaList = productServices.getAllMediaForProductById(product1.getId());
        Product product2 = productServices.getByProductId(productId2);
        model.addAttribute("displaySie2InCm",String.format("%.2f", Float.parseFloat(product2.getDisplaySize())*2.54));
        List<ProductMediaDto> product2MediaList = productServices.getAllMediaForProductById(product2.getId());
        model.addAttribute("product1",product1);
        model.addAttribute("product1MediaList",product1MediaList);
        model.addAttribute("product2",product2);
        model.addAttribute("product2MediaList",updateMediaSequence(product2MediaList,product1MediaList));
        return "productDetailsCompare";
    }

    private List<ProductMediaDto> updateMediaSequence(List<ProductMediaDto> productMediaListResponse, List<ProductMediaDto> productMediaListReference) {
        productMediaListResponse.forEach(productMediaDto -> productMediaDto.setMediaSeq(productMediaDto.getMediaSeq()+productMediaListReference.size()));
        return productMediaListResponse;
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model){
        model.addAttribute("title",title);
        model.addAttribute("uuid", UUID.randomUUID());
        return "addProduct";
    }

    @RequestMapping(value = "/products")
    public String products(Model model){
        model.addAttribute("title",title);
        List<ProductDto> products = productServices.getAllProductsWithMedia();
        model.addAttribute("productList",products);
        return "products";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute UserDto userDto){
        System.out.println(userDto.getEmail());
        Optional<User> user = userService.getUserByEmail(userDto.getEmail());
        if (user.isPresent()){
            User user1 = user.get();
            if (user1.getPassword().equals(userDto.getPassword()))
                return "redirect:/adminProductList";
        }
        return "redirect:/login";
    }
}
