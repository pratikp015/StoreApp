package com.abcshopapp.dao;

import java.util.List;
import com.abcshopapp.dto.Invoice;

public interface InvoiceDao {

    void save(Invoice invoice);

    Invoice findById(int invoiceNo);

    List<Invoice> findAll();
}
