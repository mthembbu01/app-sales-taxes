package com.quarphix.salestaxes.repositories;

import com.quarphix.salestaxes.entities.Product;
import com.quarphix.salestaxes.enums.Status;
import com.quarphix.salestaxes.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class ProductRepository {
    private Map<String, Product> database = new HashMap<>();
    /**
     *
     * @return
     */
    public List<Product> findAll(){
        if(this.database.isEmpty())
            return new ArrayList<>();
        else return this.database.values()
                .stream()
                .filter(product -> product.getStatus() == Status.ACTIVE)
                .toList();
    }
    /**
     *
     * @param name
     * @return
     */
    public Optional<Product> findByName(String name) {
        if (this.database.containsKey(name)) {
            Product product = this.database.get(name);
            return Optional.of(product);
        } else return null;
    }
    /**
     *
     * @param product
     */
    public void addProduct(Product product) {
        Product p = findByName(product.getName())
                .orElseThrow(()-> new RuntimeException("Product name already exists!"));
        database.put(product.getName(),product);
    }
    /**
     *
     * @param name of the product
     * @param updateProduct to update the existing product
     * @return Product that is updated
     */
    public Product updateProduct(String name, Product updateProduct) {
        Product product = findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("Product","Name",name));
        //-- TODO: add comments
        Product p = update(product,updateProduct);
        this.database.put(name,p);
        //-- TODO
         return p;
    }
    /**
     *
     * @param product
     * @param update
     * @return
     */
    private Product update(Product product, Product update) {
        return product.builder()
                .name(update.getName())
                .status(update.getStatus())
                .build();
    }

    public Status deleteProduct(String name) {
        Optional<Product> product = findByName(name);
        delete(product.get());
        return Status.DISCONTINUED;
    }
    /**
     *
     * @param product
     */
    private void delete(Product product) {
        product.setStatus(Status.DISCONTINUED);
        this.database.put(product.getName(), product);
    }
}
