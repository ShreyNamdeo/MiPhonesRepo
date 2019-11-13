package com.miMobiles.go.miMobiles.services;

import com.miMobiles.go.miMobiles.dto.ProductDto;
import com.miMobiles.go.miMobiles.dto.ProductMediaDto;
import com.miMobiles.go.miMobiles.models.Product;
import com.miMobiles.go.miMobiles.models.ProductImage;
import com.miMobiles.go.miMobiles.repositories.ProductImageRepository;
import com.miMobiles.go.miMobiles.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.miMobiles.go.miMobiles.models.ProductImage.mediaTypes.IMAGE;

/**
 * Created by shrey on 3/17/2019.
 */
@Service
public class ProductServices {
    AWSServices awsServices;

    @Autowired
    ProductServices(AWSServices awsServices){
        this.awsServices = awsServices;
    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getByProductId(String productId){
        return productRepository.findByProductId(productId);
    }

    public List<Product> getAllProductsExcept(String productId) {
        return productRepository.findAllExcept(productId);
    }

    public List<ProductMediaDto> getAllMediaForProductById(Long productDbId){
        List<ProductImage> productMediaList = productImageRepository.findByProductDbId(productDbId);
        List<ProductMediaDto> productMediaDtos = new ArrayList<>();
        if (productMediaList.size() > 0){
            for (int i=0;i<productMediaList.size();i++){
                productMediaDtos.add(new ProductMediaDto(productMediaList.get(i),i+1,awsServices));
            }
        }else {
            ProductImage productImage = new ProductImage();
            productImage.setUrl("img/mobilePlaceHolder.png");
            productImage.setMediaType(IMAGE.name());
            productMediaDtos.add(new ProductMediaDto(productImage,1,awsServices));
        }
        return productMediaDtos;
    }

    public List<ProductDto> getTop8Products() {
        List<Product> products = productRepository.findTop8ByOrderByCreatedDesc();
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> productDtos.add(new ProductDto(product,getTopImageForProduct(product))));
        return productDtos;
    }

    private List<ProductMediaDto> getTopImageForProduct(Product product) {
        List<ProductMediaDto> finalMediaList = new ArrayList<>();
        List<ProductImage> productMediaList = productImageRepository.findByProductDbId(product.getId());
        if (productMediaList.size() > 0){
            productMediaList.forEach(productImage -> {
                if (finalMediaList.size() == 0 && productImage.getMediaType().equals(IMAGE.name())){
                    finalMediaList.add(new ProductMediaDto(productImage,0,awsServices));
                }
            });
            if (finalMediaList.size() == 0){
                ProductImage productImage = new ProductImage();
                productImage.setUrl("img/mobilePlaceHolder.png");
                productImage.setMediaType(IMAGE.name());
                finalMediaList.add(new ProductMediaDto(productImage,0,awsServices));
            }
        }else{
            ProductImage productImage = new ProductImage();
            productImage.setUrl("img/mobilePlaceHolder.png");
            productImage.setMediaType(IMAGE.name());
            finalMediaList.add(new ProductMediaDto(productImage,0,awsServices));
        }
        return finalMediaList;
    }

    public List<ProductDto> getAllProductsWithMedia() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> productDtos.add(new ProductDto(product,getTopImageForProduct(product))));
        return productDtos;
    }

    public Product findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    public void deleteProduct(String productId) {
        Product product = findByProductId(productId);
        List<ProductImage> productImageList = productImageRepository.findByProductDbId(product.getId());
        productImageList.forEach(this::deleteProductImage);
        productRepository.delete(product);
    }

    private void deleteProductImage(ProductImage productImage){
        if (productImage.getMediaType().equals(ProductImage.mediaTypes.IMAGE.name())){
            if (productImage.getMediaKey() != null)
                awsServices.deleteByKey(productImage.getMediaKey());
        }
        if (productImage.getMediaType().equals(ProductImage.mediaTypes.VIDEO.name())){
            if (productImage.getVideoType().equals(ProductImage.videoType.UPLOAD.name())){
                if (productImage.getMediaKey() != null)
                    awsServices.deleteByKey(productImage.getMediaKey());
                if (productImage.getThumbnailKey() != null)
                    awsServices.deleteByKey(productImage.getThumbnailKey());
            }
        }
        productImageRepository.delete(productImage);
    }

    public void deleteProductMediaById(Long mediaId) {
        deleteProductImage(productImageRepository.getOne(mediaId));
    }
}
