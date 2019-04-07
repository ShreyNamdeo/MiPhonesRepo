package com.miMobiles.go.miMobiles.dto;

import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.services.AWSServices;

import static com.amazonaws.HttpMethod.GET;
import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.IMAGE;
import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.VIDEO;
import static com.miMobiles.go.miMobiles.models.ProductImage.videoType.YOUTUBE;

/**
 * Created by shrey on 3/21/2019.
 */
public class ProductMediaDto {
    private Long id;
    private Long productDbId;
    private String mediaKey;
    private String url;
    private String mediaType;
    private String videoType;
    private int mediaSeq;
    private String thumbnailUrl;

    public ProductMediaDto(){}

    public ProductMediaDto(ProductImage productImage, int index, AWSServices awsServices){
        this.id = productImage.getId();
        this.productDbId = productImage.getProductDbId();
        this.mediaKey = productImage.getMediaKey();
        if (productImage.getUrl() != null)
            this.url = productImage.getUrl();
        if (productImage.getUrl() == null && productImage.getMediaKey() != null){
            if (productImage.getMediaType().equalsIgnoreCase(IMAGE.name()))
                this.url = awsServices.generatePresignedUrl(productImage.getMediaKey(),GET, "image/jpeg").toString();
            if (productImage.getMediaType().equalsIgnoreCase(VIDEO.name()) && !productImage.getVideoType().equalsIgnoreCase(YOUTUBE.name())){
                this.url = awsServices.generatePresignedUrl(productImage.getMediaKey(),GET, "video/mp4").toString();
                if (productImage.getThumbnailKey() != null)
                this.thumbnailUrl = awsServices.generatePresignedUrl(productImage.getThumbnailKey(),GET, "image/png").toString();
            }
            if (productImage.getMediaType().equalsIgnoreCase(VIDEO.name()) && productImage.getVideoType().equalsIgnoreCase(YOUTUBE.name()))
                this.url = "https://www.youtube.com/embed/"+productImage.getMediaKey();
        }
        this.mediaType = productImage.getMediaType();
        this.videoType = productImage.getVideoType();
        this.mediaSeq = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductDbId() {
        return productDbId;
    }

    public void setProductDbId(Long productDbId) {
        this.productDbId = productDbId;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public int getMediaSeq() {
        return mediaSeq;
    }

    public void setMediaSeq(int mediaSeq) {
        this.mediaSeq = mediaSeq;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
