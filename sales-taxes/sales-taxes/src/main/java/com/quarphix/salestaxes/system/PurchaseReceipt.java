package com.quarphix.salestaxes.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReceipt {
    //--list of items on our shopping basket
    private Set<Item> items = new HashSet<>();
    private double itemsTotalPrice;
    private double itemsSalesTax;

    public void init() {
        calculateTotalPrice();
        calculateTotalTax();
    }
    /**
     * A method that adds a product item into our purchase receipt
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
    /**
     * @return
     */
    public void calculateTotalPrice() {
        double totalPrice = 0.0;
        for(Item item: items) {
            totalPrice +=item.getPriceIncludingTax();
        }
        setItemsTotalPrice(totalPrice);
    }
    /**
     * @return
     */
    public void calculateTotalTax() {
        double total_tax = 0.0;
        for(Item item: items) {
            total_tax += item.getImportTax() + item.getSalesTax();
        }
        setItemsSalesTax(total_tax);
    }

    @Override
    public String toString() {
        //-- printing out each item
        System.out.println("OUTPUT");
        this.items.forEach(item -> {
            System.out.println(String.format("%s %s: %s"
                    , item.getQuantity()
                    , item.getProduct().getName()
                    ,item.getPriceIncludingTax()));
        });
        return "\nSales Taxes: " + getItemsSalesTax()
                +"\nItems Total: " + getItemsTotalPrice();
    }
}
