package com.abcshopapp.service;

import com.abcshopapp.dto.Invoice;

public interface InvoiceService {
    Invoice calculateInvoice(int productId, int qty, String customerName, String email);
}
