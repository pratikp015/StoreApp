package com.abcshopapp.service;

import java.util.List;
import com.abcshopapp.dto.Product;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
}
