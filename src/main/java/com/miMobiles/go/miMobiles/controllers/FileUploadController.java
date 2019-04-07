package com.miMobiles.go.miMobiles.controllers;
import com.amazonaws.HttpMethod;
import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.services.AWSServices;
import com.miMobiles.go.miMobiles.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;

import static com.amazonaws.HttpMethod.GET;
import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.IMAGE;
import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.VIDEO;
import static com.miMobiles.go.miMobiles.models.ProductImage.videoType.YOUTUBE;

/**
 * Created by shrey on 3/26/2019.
 */
@RestController
public class FileUploadController {
    private AWSServices awsServices;

    @Autowired
    FileUploadController(AWSServices awsServices){
        this.awsServices = awsServices;
    }

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/upload/{mediaType}/product/{productId}", method= RequestMethod.POST)
    public String handleFileUpload(@PathVariable("mediaType") String mediaType, @PathVariable("productId") String productId,
                                   MultipartHttpServletRequest request){
        Product product = productService.findByProductId(productId);
        if (product != null){
            Iterator<String> iterator = request.getFileNames();
            while (iterator.hasNext()) {
                String fileName = iterator.next();
                MultipartFile multipartFile = request.getFile(fileName);
                String mediakey;
                if (mediaType.equalsIgnoreCase(IMAGE.name())) {
                    mediakey = awsServices.uploadFile(multipartFile,"image/jpeg");
                    productService.saveProductMedia(product.getId(),mediakey,IMAGE.name());
                }
                if (mediaType.equalsIgnoreCase(ProductImage.mediaTypes.VIDEO.name())) {
                    mediakey = awsServices.uploadFile(multipartFile,"video/mp4");
                    productService.saveProductMedia(product.getId(),mediakey,VIDEO.name());
                    return "{\"mediaKey\":\""+mediakey+"\",\"mediaLink\":\""+awsServices.generatePresignedUrl(mediakey, GET,"video/mp4")+"\"}";
                }
            }
        }
        return "addProduct";
    }
    @RequestMapping(value="/upload/VIDEO/YOUTUBE/{youtubeKey}/product/{productId}", method= RequestMethod.POST)
    public String uploadYoutubeVideo(@PathVariable("youtubeKey") String mediaKey,@PathVariable("productId") String productId){
        Product product = productService.findByProductId(productId);
        if (product != null){
            productService.saveProductMedia(product.getId(),mediaKey, YOUTUBE.name());
        }
        return "addProduct";
    }

    @RequestMapping(value="/upload/VIDEO/{videoName}/thumbnail", method= RequestMethod.POST)
    public String uploadVideoThumbnail(@PathVariable("videoName") String videoName,MultipartHttpServletRequest request){
        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            String mediakey = awsServices.uploadFile(multipartFile,"image/png");
            productService.saveVideoThumbnail(videoName,mediakey);
        }
        return "addProduct";
    }
}
