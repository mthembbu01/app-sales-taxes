package com.quarphix.salestaxes.enums;

public enum Type {
	ELECTRONIC("electronic"),
	KITCHEN_APPLIANCE("kitchen appliance"),
	FURNITURE("furniture"),
	BOOK("book"),
	MEDICATION("medication"),
	FOOD("food"),
	HARDWARE("hardware")
	;
	
	private String type;
	Type(String type){
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
