package com.miMobiles.go.miMobiles.dto;

import com.miMobiles.go.miMobiles.models.Product;

import java.util.Date;
import java.util.List;

/**
 * Created by shrey on 3/23/2019.
 */
public class ProductDto {
    private Long id;

    private String productId;

    private String productName;

    private String networkTechnology;

    private String announced;

    private String status;

    private int bodyLength;

    private int bodyWidth;

    private int bodyHeight;

    private float weight;

    private String simType;

    private String displayType;

    private String displaySize;

    private String resolution;

    private String colors;

    private int price;

    private String batteryType;

    private String batteryCharging;

    private boolean cardSlot;

    private String internalStorage;

    private boolean loudSpeaker;

    private boolean mm35jack;

    private String soundFeatures;

    private String wlan;

    private String bluetooth;

    private String gps;

    private boolean nfc;

    private boolean radio;

    private String usb;

    private String os;

    private String chipSet;

    private String cpu;

    private String gpu;

    private String mainCameraType;

    private String mainCameraDescription;

    private String mainCameraFeatures;

    private String mainCameraVideo;

    private String selfieCameraType;

    private String selfieCameraDescription;

    private String selfieCameraFeatures;

    private String selfieCameraVideo;

    private String otherSensors;

    private String description;

    private Date created;

    private List<ProductMediaDto> productMedias;

    public ProductDto(){}

    public ProductDto(Product product,List<ProductMediaDto> productMedias){
        this.id = product.getId();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.networkTechnology = product.getNetworkTechnology();
        this.announced = product.getAnnounced();
        this.status = product.getStatus();
        this.created = product.getCreated();
        this.description = product.getDescription();
        //TODO: add other variables as per requirement
        this.productMedias = productMedias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNetworkTechnology() {
        return networkTechnology;
    }

    public void setNetworkTechnology(String networkTechnology) {
        this.networkTechnology = networkTechnology;
    }

    public String getAnnounced() {
        return announced;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public int getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(int bodyWidth) {
        this.bodyWidth = bodyWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryCharging() {
        return batteryCharging;
    }

    public void setBatteryCharging(String batteryCharging) {
        this.batteryCharging = batteryCharging;
    }

    public boolean isCardSlot() {
        return cardSlot;
    }

    public void setCardSlot(boolean cardSlot) {
        this.cardSlot = cardSlot;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public boolean isLoudSpeaker() {
        return loudSpeaker;
    }

    public void setLoudSpeaker(boolean loudSpeaker) {
        this.loudSpeaker = loudSpeaker;
    }

    public boolean isMm35jack() {
        return mm35jack;
    }

    public void setMm35jack(boolean mm35jack) {
        this.mm35jack = mm35jack;
    }

    public String getSoundFeatures() {
        return soundFeatures;
    }

    public void setSoundFeatures(String soundFeatures) {
        this.soundFeatures = soundFeatures;
    }

    public String getWlan() {
        return wlan;
    }

    public void setWlan(String wlan) {
        this.wlan = wlan;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public boolean isNfc() {
        return nfc;
    }

    public void setNfc(boolean nfc) {
        this.nfc = nfc;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChipSet() {
        return chipSet;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMainCameraType() {
        return mainCameraType;
    }

    public void setMainCameraType(String mainCameraType) {
        this.mainCameraType = mainCameraType;
    }

    public String getMainCameraDescription() {
        return mainCameraDescription;
    }

    public void setMainCameraDescription(String mainCameraDescription) {
        this.mainCameraDescription = mainCameraDescription;
    }

    public String getMainCameraFeatures() {
        return mainCameraFeatures;
    }

    public void setMainCameraFeatures(String mainCameraFeatures) {
        this.mainCameraFeatures = mainCameraFeatures;
    }

    public String getMainCameraVideo() {
        return mainCameraVideo;
    }

    public void setMainCameraVideo(String mainCameraVideo) {
        this.mainCameraVideo = mainCameraVideo;
    }

    public String getSelfieCameraType() {
        return selfieCameraType;
    }

    public void setSelfieCameraType(String selfieCameraType) {
        this.selfieCameraType = selfieCameraType;
    }

    public String getSelfieCameraDescription() {
        return selfieCameraDescription;
    }

    public void setSelfieCameraDescription(String selfieCameraDescription) {
        this.selfieCameraDescription = selfieCameraDescription;
    }

    public String getSelfieCameraFeatures() {
        return selfieCameraFeatures;
    }

    public void setSelfieCameraFeatures(String selfieCameraFeatures) {
        this.selfieCameraFeatures = selfieCameraFeatures;
    }

    public String getSelfieCameraVideo() {
        return selfieCameraVideo;
    }

    public void setSelfieCameraVideo(String selfieCameraVideo) {
        this.selfieCameraVideo = selfieCameraVideo;
    }

    public String getOtherSensors() {
        return otherSensors;
    }

    public void setOtherSensors(String otherSensors) {
        this.otherSensors = otherSensors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<ProductMediaDto> getProductMedias() {
        return productMedias;
    }

    public void setProductMedias(List<ProductMediaDto> productMedias) {
        this.productMedias = productMedias;
    }
}
