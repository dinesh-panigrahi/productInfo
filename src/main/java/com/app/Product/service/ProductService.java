package com.app.Product.service;

import com.app.Product.dto.ProductDto;

import java.util.List;

public interface ProductService {

     ProductDto saveProduct(ProductDto productDto);

     ProductDto fetchProduct(Long id);

     List<ProductDto> fetchAllProducts();
}
