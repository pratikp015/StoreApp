package com.abcshopapp.service;

import com.abcshopapp.dao.ProductDao;
import com.abcshopapp.dao.ProductDaoImpl;
import com.abcshopapp.dto.Invoice;
import com.abcshopapp.dto.Product;

public class InvoiceServiceImpl implements InvoiceService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Invoice calculateInvoice(int productId, int qty, String customerName, String email) {
        Product product = productDao.findById(productId);
        if (product == null) {
            return null;  // Handle no product found
        }

        double totalCost = product.getProductPrice() * qty;
        double gst = totalCost * 0.05;
        double orderAmount = totalCost + gst;

        Invoice invoice = new Invoice();
        invoice.setProductName(product.getProductName());
        invoice.setUnitPrice(product.getProductPrice());
        invoice.setQty(qty);
        invoice.setCustomerName(customerName);
        invoice.setEmail(email);
        invoice.setTotalCost(totalCost);
        invoice.setGst(gst);
        invoice.setOrderAmount(orderAmount);

        return invoice;
    }
}
