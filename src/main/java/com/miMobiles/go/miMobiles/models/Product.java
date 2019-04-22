package com.miMobiles.go.miMobiles.models;

import com.miMobiles.go.miMobiles.dto.ProductDto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by shrey on 3/14/2019.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "network_technology")
    private String networkTechnology;

    @Column(name = "announced")
    private String announced;

    @Column(name = "status")
    private String status;

    @Column(name = "body_length")
    private float bodyLength;

    @Column(name = "body_width")
    private float bodyWidth;

    @Column(name = "body_height")
    private float bodyHeight;

    @Column(name = "weight")
    private float weight;

    @Column(name = "sim_type")
    private String simType;

    @Column(name = "display_type")
    private String displayType;

    @Column(name = "display_size")
    private String displaySize;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "colors")
    private String colors;

    @Column(name = "price")
    private int price;

    @Column(name = "battery_type")
    private String batteryType;

    @Column(name = "battery_charging")
    private String batteryCharging;

    @Column(name = "card_slot")
    private boolean cardSlot;

    @Column(name = "internal_storage")
    private String internalStorage;

    @Column(name = "loud_speaker")
    private boolean loudSpeaker;

    @Column(name = "sound_3_5_mm_jack")
    private boolean mm35jack;

    @Column(name = "sound_features")
    private String soundFeatures;

    @Column(name = "wlan")
    private String wlan;

    @Column(name = "bluetooth")
    private String bluetooth;

    @Column(name = "gps")
    private String gps;

    @Column(name = "nfc")
    private boolean nfc;

    @Column(name = "radio")
    private boolean radio;

    @Column(name = "usb")
    private String usb;

    @Column(name = "os")
    private String os;

    @Column(name = "chip_set")
    private String chipSet;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "gpu")
    private String gpu;

    @Column(name = "main_camera_type")
    private String mainCameraType;

    @Column(name = "main_camera_description")
    private String mainCameraDescription;

    @Column(name = "main_camera_features")
    private String mainCameraFeatures;

    @Column(name = "main_camera_video")
    private String mainCameraVideo;

    @Column(name = "selfie_camera_type")
    private String selfieCameraType;

    @Column(name = "selfie_camera_description")
    private String selfieCameraDescription;

    @Column(name = "selfie_camera_features")
    private String selfieCameraFeatures;

    @Column(name = "selfie_camera_video")
    private String selfieCameraVideo;

    @Column(name = "other_sensors")
    private String otherSensors;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private Date created;

    public Product(){}

    public Product(ProductDto productDto){
        this.id = productDto.getId();
        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.networkTechnology = productDto.getNetworkTechnology();
        this.announced = productDto.getAnnounced();
        this.status = productDto.getStatus();
        this.bodyHeight = productDto.getBodyHeight();
        this.bodyLength =productDto.getBodyLength();
        this.bodyWidth = productDto.getBodyWidth();
        this.weight =productDto.getWeight();
        this.simType = productDto.getSimType();
        this.displayType = productDto.getDisplayType();
        this.displaySize =productDto.getDisplaySize();
        this.resolution= productDto.getResolution();
        this.colors = productDto.getColors();
        this.price = productDto.getPrice();
        this.batteryType = productDto.getBatteryType();
        this.batteryCharging = productDto.getBatteryCharging();
        this.cardSlot = productDto.isCardSlot();
        this.internalStorage = productDto.getInternalStorage();
        this.loudSpeaker = productDto.isLoudSpeaker();
        this.mm35jack = productDto.isMm35jack();
        this.soundFeatures = productDto.getSoundFeatures();
        this.wlan = productDto.getWlan();
        this.bluetooth = productDto.getBluetooth();
        this.gps = productDto.getGps();
        this.nfc = productDto.isNfc();
        this.radio = productDto.isRadio();
        this.usb =productDto.getUsb();
        this.os = productDto.getOs();
        this.chipSet = productDto.getChipSet();
        this.cpu = productDto.getCpu();
        this.gpu = productDto.getGpu();
        this.mainCameraType = productDto.getMainCameraType();
        this.mainCameraDescription = productDto.getMainCameraDescription();
        this.mainCameraFeatures = productDto.getMainCameraFeatures();
        this.mainCameraVideo = productDto.getMainCameraVideo();
        this.selfieCameraType = productDto.getSelfieCameraType();
        this.selfieCameraDescription = productDto.getSelfieCameraDescription();
        this.selfieCameraFeatures = productDto.getSelfieCameraFeatures();
        this.selfieCameraVideo = productDto.getSelfieCameraVideo();
        this.otherSensors = productDto.getOtherSensors();
        this.description = productDto.getDescription();
        this.created = productDto.getCreated();
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

    public float getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(float bodyLength) {
        this.bodyLength = bodyLength;
    }

    public float getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(float bodyWidth) {
        this.bodyWidth = bodyWidth;
    }

    public float getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(float bodyHeight) {
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
}
