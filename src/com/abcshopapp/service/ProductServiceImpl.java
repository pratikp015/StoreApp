package com.abcshopapp.service;

import java.util.List;
import com.abcshopapp.dao.ProductDao;
import com.abcshopapp.dao.ProductDaoImpl;
import com.abcshopapp.dto.Product;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}
