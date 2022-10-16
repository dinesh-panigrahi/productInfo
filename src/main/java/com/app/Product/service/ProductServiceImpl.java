package com.app.Product.service;

import com.app.Product.controller.ProductController;
import com.app.Product.dao.ProductRepository;
import com.app.Product.dto.ProductDto;
import com.app.Product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto)
    {
        log.info("Saving a new product: {}", productDto.toString());
        Product product = new Product(productDto.getId(), productDto.getProductName(), productDto.getProductTitle());

        Product productResponse = productRepository.save(product);
        log.info("Successfully Saved a product: {}", productResponse.toString());

        return new ProductDto(productResponse.getId(), productResponse.getProductName(), productResponse.getProductTitle());
    }

    @Override
    public ProductDto fetchProduct(Long id) {

        log.info("started to fetch a product for productId: {}", id);
        Product product = productRepository.findById(id).get();
        ProductDto productDto = new ProductDto(product.getId(), product.getProductName(), product.getProductTitle());
        log.info("Successfully fetch product for productId: {}", productDto.getId());
        return productDto;
    }

    @Override
    public List<ProductDto> fetchAllProducts() {

        log.info("Started to fetch all products");
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for(Product product: productList) {
            ProductDto productDto = new ProductDto(product.getId(), product.getProductName(), product.getProductTitle());
            productDtoList.add(productDto);
        }
        log.info("Successfully fetched all products");
        return productDtoList;
    }
}
