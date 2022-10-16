package com.app.Product.controller;

import com.app.Product.dto.ProductDto;
import com.app.Product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        log.info("Inside SaveProduct method in ProductController...");
        ProductDto productRes = new ProductDto();
        productRes = productService.saveProduct(productDto);
        return ResponseEntity.ok(productRes);
    }

    @GetMapping("/allProducts")
    @CachePut(value="products")
    public ResponseEntity<List<ProductDto>> fetchAllProducts() {
        log.info("Inside fetchAllProducts method in ProductController...");
        List<ProductDto> allProductDetails = new ArrayList<>();
        allProductDetails = productService.fetchAllProducts();
        return ResponseEntity.ok(allProductDetails);
    }

    @GetMapping("/{productId}")
    @Cacheable(value = "productInfo" + "{productId}")
    public ResponseEntity<ProductDto> fetchProduct(@PathVariable("productId") long productId) {
        log.info("Inside fetchProduct method in ProductController...");
        ProductDto productDto = new ProductDto();
        productDto = productService.fetchProduct(productId);
        return ResponseEntity.ok(productDto);
    }}
