package com.quarphix.salestaxes.services;

public interface ReceiptService {
    void addReceipt();
    void findByName(String name);
    void findAll();
    void updateByName(String name);
    void deleteByName(String name);
}
