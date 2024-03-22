package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    //Product updateProduct(Long id);
}
