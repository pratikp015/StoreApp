package com.abcshopapp.main;

import java.util.List;
import java.util.Scanner;
import com.abcshopapp.dto.Product;
import com.abcshopapp.service.ProductService;
import com.abcshopapp.service.ProductServiceImpl;

public class ProductMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Product Name");
        String productName = sc.next();

        System.out.println("Enter Product Price");
        double productPrice = sc.nextDouble();

        System.out.println("Enter MFD (YYYY-MM-DD)");
        String mfd = sc.next();

        System.out.println("Enter Category");
        String category = sc.next();

        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setMfd(java.time.LocalDate.parse(mfd));
        product.setCategory(category);

        ProductService productService = new ProductServiceImpl();
        productService.addProduct(product);

        System.out.println("Product Added Successfully!");
        sc.close();
    }
}
