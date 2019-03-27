package com.miMobiles.go.miMobiles.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.miMobiles.go.miMobiles.models.AmazonService;
import com.miMobiles.go.miMobiles.repositories.AmazonServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by shrey on 3/27/2019.
 */
@Service
public class AWSServices {
    private String endpointUrl = "https://s3.us-west-2.amazonaws.com";
    private String bucketName = "phoneapp-media-1";

    @Autowired
    private AmazonServiceRepository amazonServiceRepository;

    private AmazonService getCredsForS3(String serviceName){
        return amazonServiceRepository.findByServiceName(serviceName);
    }

    private AmazonS3 s3client;

    @PostConstruct
    private void initializeAmazon() {
        AmazonService service = getCredsForS3("aws-s3");
        AWSCredentials credentials = new BasicAWSCredentials(service.getAccessKey(), service.getSecretKey());
        this.s3client = new AmazonS3Client(credentials);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String uploadFile(MultipartFile multipartFile) {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }
}
