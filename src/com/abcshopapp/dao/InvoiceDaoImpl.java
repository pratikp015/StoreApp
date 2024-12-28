package com.abcshopapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.abcshopapp.dao.InvoiceDao;
import com.abcshopapp.dto.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {

    private List<Invoice> invoices = new ArrayList<>();

    @Override
    public void save(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Invoice saved successfully: " + invoice);
    }

    @Override
    public Invoice findById(int invoiceNo) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceNo() == invoiceNo) {
                return invoice;
            }
        }
        System.out.println("Invoice not found for ID: " + invoiceNo);
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }
}
