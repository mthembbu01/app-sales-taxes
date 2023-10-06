package com.quarphix.salestaxes.services.impl;

import com.quarphix.salestaxes.entities.Product;
import com.quarphix.salestaxes.exceptions.ResourceNotFoundException;
import com.quarphix.salestaxes.repositories.ProductRepository;
import com.quarphix.salestaxes.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public String addProduct(Product product) {
        this.repository.addProduct(product);
        return "product: "+product+" is saved.";
    }

    @Override
    public Product findByName(String name) {
        return this.repository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Product","Name",name));
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product updateByName(String name,Product update) {
        return this.repository.updateProduct(name,update);
    }

    @Override
    public void deleteByName(String name) {
        this.repository.deleteProduct(name);
    }
}
