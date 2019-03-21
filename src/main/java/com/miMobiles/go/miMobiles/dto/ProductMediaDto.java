package com.miMobiles.go.miMobiles.dto;

import com.miMobiles.go.miMobiles.models.ProductImage;

/**
 * Created by shrey on 3/21/2019.
 */
public class ProductMediaDto {
    private Long id;
    private Long productDbId;
    private String s3Key;
    private String url;
    private String mediaType;
    private String videoType;
    private int mediaSeq;

    public ProductMediaDto(){}

    public ProductMediaDto(ProductImage productImage, int index){
        this.id = productImage.getId();
        this.productDbId = productImage.getProductDbId();
        this.s3Key = productImage.getS3Key();
        this.url = productImage.getUrl();
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

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
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
}
