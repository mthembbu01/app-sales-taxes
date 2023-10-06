package com.quarphix.salestaxes.system;

import com.quarphix.salestaxes.constants.Constant;
import com.quarphix.salestaxes.entities.Product;
import com.quarphix.salestaxes.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Product product;
    private int quantity;
    private double totalPrice = 0;//get the total price of the product items without TAX
    private double priceIncludingTax = 0;
    private double salesTax = 0; //basic tax imposed on all goods but Food, Medication and Books
    private double importTax = 0; // imposed on imported products without exception
    /**
     *
     * @param product
     * @param quantity
     */
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    /**
     *
     * @return
     */
    public void calculateTotalPrice() {
        this.totalPrice = this.product.getPrice() * quantity;
        setTotalPrice(this.totalPrice);
    }
    /**
     *
     * @return
     */
    public void calculateImportTax() {
        if(product.isImport()) {
            this.importTax = product.getPrice() * Constant.IMPORT_DUTY_TAX * quantity;
        }
        setImportTax(this.importTax);
    }
    /**
     *
     * @return
     */
    public void calculateSalesTax() {
        //-- 1. Assign sales tax to a store product
        if(!this.product.getProductType().equals(Type.BOOK) ||
                !this.product.getProductType().equals(Type.FOOD) ||
                !this.product.getProductType().equals(Type.MEDICATION)) {
            this.salesTax = this.product.getPrice() * Constant.SALES_TAX * quantity;
        }
        setSalesTax(this.salesTax);
    }
    /**
     *
     * @return
     */
    public void calculatePriceIncludingTax() {
        this.priceIncludingTax = this.totalPrice + this.importTax + this.salesTax;
        setPriceIncludingTax(this.priceIncludingTax);
        //-- Rounding off applying to this specific item!
//        return this.priceIncludingTax.setScale(2, RoundingMode.UP);
    }

    @Override
    public String toString() {
        return quantity +
                " " + product.getName() +
                " at " + this.totalPrice ;
    }
}
