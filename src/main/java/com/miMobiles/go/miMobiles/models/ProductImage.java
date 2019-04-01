package com.miMobiles.go.miMobiles.models;

/**
 * Created by shrey on 3/21/2019.
 */

import javax.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_db_id")
    private Long productDbId;

    @Column(name = "media_key")
    private String mediaKey;

    @Column(name = "url")
    private String url;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "video_type")
    private String videoType;

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

    public enum mediaTypes{
        IMAGE, VIDEO
    }

    public enum videoType{
        UPLOAD, YOUTUBE
    }
}
