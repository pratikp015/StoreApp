package com.abcshopapp.main;

import java.util.Scanner;
import com.abcshopapp.service.InvoiceService;
import com.abcshopapp.service.InvoiceServiceImpl;
import com.abcshopapp.dto.Invoice;

public class InvoiceMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Product ID");
        int productId = sc.nextInt();

        System.out.println("Enter Quantity");
        int qty = sc.nextInt();

        System.out.println("Enter Customer Name");
        String customerName = sc.next();

        System.out.println("Enter Customer Email");
        String email = sc.next();

        InvoiceService invoiceService = new InvoiceServiceImpl();
        Invoice invoice = invoiceService.calculateInvoice(productId, qty, customerName, email);

        if (invoice != null) {
            System.out.println("Invoice Details:");
            System.out.println("Product Name: " + invoice.getProductName());
            System.out.println("Unit Price: " + invoice.getUnitPrice());
            System.out.println("Quantity: " + invoice.getQty());
            System.out.println("Total Cost: " + invoice.getTotalCost());
            System.out.println("GST: " + invoice.getGst());
            System.out.println("Order Amount: " + invoice.getOrderAmount());
        } else {
            System.out.println("Product not found!");
        }

        sc.close();
    }
}
