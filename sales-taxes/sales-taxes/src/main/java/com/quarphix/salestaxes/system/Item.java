package com.quarphix.salestaxes.system;

import com.quarphix.salestaxes.constants.Constant;
import com.quarphix.salestaxes.entities.Product;
import com.quarphix.salestaxes.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Item {
    private Product product;
    private int quantity;
    private double totalPrice ;//get the total price of the product items without TAX
    private double priceIncludingTax;
    private double salesTax; //basic tax imposed on all goods but Food, Medication and Books
    private double importTax; // imposed on imported products without exception
    /**
     *
     * @param product
     * @param quantity
     */
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        init();
    }
    public void init(){
        calculateTotalPrice();
        calculateSalesTax();
        calculateImportTax();
        calculatePriceIncludingTax();
    }
    /**
     *
     * @return
     */
    public void calculateTotalPrice() {
        double total = product.getPrice() * (double) quantity;
        setTotalPrice(total);
    }
    /**
     *
     * @return
     */
    public void calculateImportTax() {
        double import_tax = product.isImport() ? product.getPrice() * (double) quantity * Constant.IMPORT_DUTY_TAX : 0.0;
        import_tax = new BigDecimal(import_tax).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        setImportTax(import_tax);
    }
    /**
     *
     * @return
     */
    public void calculateSalesTax() {
        //-- 1. Assign sales tax to a store product
        double sales_tax = 0.0;
        if(this.product.getProductType().equals(Type.BOOK)
            || this.product.getProductType().equals(Type.FOOD)
                || this.product.getProductType().equals(Type.MEDICATION)) {
            sales_tax = 0.0;
        } else {
            sales_tax = product.getPrice() * (double) quantity * Constant.SALES_TAX;
            sales_tax = new BigDecimal(sales_tax).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        //-- 2. Rounding up to nearest 10
        setSalesTax(sales_tax);
    }
    /**
     *
     * @return
     */
    public void calculatePriceIncludingTax() {
        double price_including_tax = getTotalPrice() + getImportTax() + getSalesTax();
        price_including_tax = new BigDecimal(price_including_tax)
                .setScale(2,BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        setPriceIncludingTax(price_including_tax);
    }

    @Override
    public String toString() {
        return quantity +
                " " + product.getName() +
                " at " + this.totalPrice ;
    }
}
