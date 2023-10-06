package com.quarphix.salestaxes;

import com.quarphix.salestaxes.entities.Product;
import com.quarphix.salestaxes.enums.Status;
import com.quarphix.salestaxes.enums.Type;
import com.quarphix.salestaxes.system.Item;
import com.quarphix.salestaxes.system.PurchaseReceipt;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		//-- creating the product data
		Product book = buildProduct("Book",false,Type.BOOK,12.49);
		Product cd = buildProduct("Music CD",false,Type.ELECTRONIC,14.99);
		Product chocolate = buildProduct("Chocolate",false,Type.FOOD,0.85);
		//-- creating items for each product
		Item bookItem = new Item(book,1);
		Item cdItem = new Item(cd,1);
		Item chocolateItem = new Item(chocolate,1);
		//-- displaying items input
		System.out.println("INPUT: ");
		System.out.println(bookItem);
		System.out.println(cdItem);
		System.out.println();
		//-- adding each item to the purchase receipt
		PurchaseReceipt receipt = new PurchaseReceipt();
		receipt.addItem(bookItem);
		receipt.addItem(cdItem);
		receipt.addItem(chocolateItem);
		//-- 1. Calculate total price excluding TAX
		receipt.calculateTotalExcludingTax();
		//-- 2. Calculate the total Sales tax and Import Tax
		receipt.calculateTotalTAX();
//
		//-- getting the receipt output
		System.out.println("OUTPUT");
		System.out.println(receipt);
	}

	public static Product buildProduct(String name,boolean isImport, Type productType, double price){
		return Product.builder()
				.name(name)
				.isImport(isImport)
				.productType(productType)
				.price(price)
				.status(Status.ACTIVE)
				.build();
	}
}
