package com.miMobiles.go.miMobiles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by shrey on 3/26/2019.
 */
@Controller
public class FileUploadController {
    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String handleFileUpload(MultipartHttpServletRequest request){
        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            byte[] fileInByte = new byte[0];
            try {
                fileInByte = multipartFile.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(fileInByte);
            // do stuff...

        }

        // do stuff...
        return "addProduct";
    }
}
