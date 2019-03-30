package com.miMobiles.go.miMobiles.controllers;
import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.services.AWSServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;

/**
 * Created by shrey on 3/26/2019.
 */
@Controller
public class FileUploadController {
    private AWSServices awsServices;

    @Autowired
    FileUploadController(AWSServices awsServices){
        this.awsServices = awsServices;
    }

    @RequestMapping(value="/upload/{mediaType}", method= RequestMethod.POST)
    public String handleFileUpload(@PathVariable("mediaType") String mediaType, MultipartHttpServletRequest request){
        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            if (mediaType.equalsIgnoreCase(ProductImage.mediaTypes.IMAGE.name())) {
                String fileaddr = awsServices.uploadFile(multipartFile,"image/jpeg");
                System.out.println(fileaddr);
            }
            if (mediaType.equalsIgnoreCase(ProductImage.mediaTypes.VIDEO.name())) {
                String fileaddr = awsServices.uploadFile(multipartFile,"video/mp4");
                System.out.println(fileaddr);
            }
        }
        // do stuff...
        return "addProduct";
    }
}
