package com.miMobiles.go.miMobiles.services;

import com.miMobiles.go.miMobiles.dto.ProductDto;
import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.repositories.ProductImageRepository;
import com.miMobiles.go.miMobiles.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.VIDEO;
import static com.miMobiles.go.miMobiles.models.ProductImage.videoType.UPLOAD;
import static com.miMobiles.go.miMobiles.models.ProductImage.videoType.YOUTUBE;

/**
 * Created by shrey on 3/31/2019.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    public Product updateProduct(ProductDto productDto) {
        Product product = productRepository.findByProductId(productDto.getProductId());
        if (product != null){
            if (productDto.getProductName() != null)
                product.setProductName(productDto.getProductName());
            if (productDto.getNetworkTechnology() != null)
                product.setNetworkTechnology(productDto.getNetworkTechnology());
            if (productDto.getAnnounced() != null)
                product.setNetworkTechnology(productDto.getAnnounced());
            if(productDto.getStatus() != null)
                product.setStatus(productDto.getStatus());
            product.setBodyLength(productDto.getBodyLength());
            product.setBodyHeight(productDto.getBodyHeight());
            product.setBodyWidth(productDto.getBodyWidth());
            product.setWeight(productDto.getWeight());
            if (productDto.getSimType() != null)
                product.setSimType(productDto.getSimType());
            if (productDto.getDisplayType() != null)
                product.setDisplayType(productDto.getDisplayType());
            if (productDto.getDisplaySize() != null)
                product.setDisplaySize(productDto.getDisplaySize());
            if (productDto.getResolution() != null)
                product.setResolution(productDto.getResolution());
            if (productDto.getColors() != null)
                product.setColors(productDto.getColors());
            product.setPrice(productDto.getPrice());
            if (productDto.getBatteryType() != null)
                product.setBatteryType(productDto.getBatteryType());
            if (productDto.getBatteryCharging() != null)
                product.setBatteryCharging(productDto.getBatteryCharging());
            product.setCardSlot(productDto.isCardSlot());
            if (productDto.getInternalStorage() != null)
                product.setInternalStorage(productDto.getInternalStorage());
            product.setLoudSpeaker(productDto.isLoudSpeaker());
            product.setMm35jack(productDto.isMm35jack());
            if (productDto.getSoundFeatures() != null)
                product.setSoundFeatures(productDto.getSoundFeatures());
            if (productDto.getWlan() != null)
                product.setWlan(productDto.getWlan());
            if (productDto.getBluetooth() != null)
                product.setBluetooth(productDto.getBluetooth());
            if (productDto.getGps() != null)
                product.setGps(productDto.getGps());
            product.setNfc(productDto.isNfc());
            product.setRadio(productDto.isRadio());
            if (productDto.getUsb() != null)
                product.setUsb(productDto.getUsb());
            if (productDto.getOs() != null)
                product.setOs(productDto.getOs());
            if (productDto.getChipSet() != null)
                product.setChipSet(productDto.getChipSet());
            if (productDto.getCpu() != null)
                product.setCpu(productDto.getCpu());
            if (productDto.getGpu() != null)
                product.setGpu(productDto.getGpu());
            if (productDto.getMainCameraType() != null)
                product.setMainCameraType(productDto.getMainCameraType());
            if (productDto.getMainCameraDescription() != null)
                product.setMainCameraDescription(productDto.getMainCameraDescription());
            if (productDto.getMainCameraFeatures() != null)
                product.setMainCameraFeatures(productDto.getMainCameraFeatures());
            if (productDto.getMainCameraVideo() != null)
                product.setMainCameraVideo(productDto.getMainCameraVideo());
            if (productDto.getSelfieCameraType() != null)
                product.setSelfieCameraType(productDto.getSelfieCameraType());
            if (productDto.getSelfieCameraDescription() != null)
                product.setSelfieCameraDescription(productDto.getSelfieCameraDescription());
            if (productDto.getSelfieCameraFeatures() != null)
                product.setMainCameraFeatures(productDto.getMainCameraFeatures());
            if (productDto.getSelfieCameraVideo() != null)
                product.setSelfieCameraVideo(productDto.getSelfieCameraVideo());
            if (productDto.getOtherSensors() != null)
                product.setOtherSensors(productDto.getOtherSensors());
            if (productDto.getDescription() != null)
                product.setDescription(productDto.getDescription());
            return  productRepository.save(product);
        }else{
            productDto.setCreated(new Date());
            return productRepository.save(new Product(productDto));
        }
    }

    public Product findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    public void saveProductMedia(Long productDbId, String mediakey, String mediaType) {
        ProductImage productImage = new ProductImage();
        productImage.setProductDbId(productDbId);
        productImage.setMediaType(mediaType);
        productImage.setMediaKey(mediakey);
        if (mediaType.equalsIgnoreCase(VIDEO.name())){
            productImage.setVideoType(UPLOAD.name());
        }
        if (mediaType.equalsIgnoreCase(YOUTUBE.name())){
            productImage.setMediaType(VIDEO.name());
            productImage.setVideoType(YOUTUBE.name());
        }
        productImageRepository.save(productImage);
    }

    public void saveVideoThumbnail(String videoName, String mediakey) {
        productImageRepository.updateProductVideoSetThumbnail(videoName,mediakey);
    }
}
