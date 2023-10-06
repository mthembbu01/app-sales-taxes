
package com.quarphix.salestaxes.services;

public interface ItemService {
    void addItem();
    void findByName(String name);
    void findAll();
    void updateByName(String name);
    void deleteByName(String name);
}
