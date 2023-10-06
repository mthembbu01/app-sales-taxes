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
    private double totalExcludingTax = 0;
    private double totalTAX = 0;

    /**
     * A method that adds a product item into our purchase receipt
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
    /**
     *
     * @return
     */
    public void calculateTotalExcludingTax(){
        items.forEach(item -> {
            item.calculateTotalPrice();
            this.totalExcludingTax += item.getTotalPrice();
        });
        setTotalExcludingTax(this.totalExcludingTax);
//        return this.totalExcludingTax.setScale(2, RoundingMode.UP);
    }

    /**
     *
     * @return
     */
    public void calculateTotalTAX() {
        this.items.forEach(item -> {
            item.calculateSalesTax();
            item.calculateImportTax();
            this.totalTAX += item.getSalesTax() + item.getImportTax();
        });
        setTotalTAX(this.totalTAX);
    }

    @Override
    public String toString() {
        //-- printing out each item
        this.items.forEach(item -> {
            System.out.println(String.format("%s %s: %s"
                    , item.getQuantity()
                    , item.getProduct().getName()
                    ,item.getPriceIncludingTax()));
        });
        return "\nSales Taxes: " + getTotalTAX()
                +"\nTotal: " + getTotalExcludingTax();
    }
}
