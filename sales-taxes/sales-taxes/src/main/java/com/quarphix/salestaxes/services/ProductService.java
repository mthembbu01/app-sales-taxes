package com.quarphix.salestaxes.services;

import com.quarphix.salestaxes.entities.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);
    Product findByName(String name);
    List<Product> findAll();
    Product updateByName(String name, Product update);
    void deleteByName(String name);
}
