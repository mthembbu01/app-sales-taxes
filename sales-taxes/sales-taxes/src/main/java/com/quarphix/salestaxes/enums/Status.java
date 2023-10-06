package com.quarphix.salestaxes.enums;

public enum Status {

	ACTIVE("active"),
	ACTIVATED("activated"),
	ACTIVATE("activate"),
	DE_ACTIVATED("deactivated"),
	DE_ACTIVATE("deactivate"),
	RE_ACTIVATED("reactivated"),
	RE_ACTIVATE("reactivate"),
	SUSPEND("suspend"),
	SUSPENDED("suspended"),
	PENDING("pending"),
	REJECTED("rejected"),
	APPROVED("approved"),
	IN_REVIEW("in review"),
	IN_ACTIVE("in active"),
	IN_ACTIVATE("in activate"),
	IN_ACTIVATED("in activated"),
	IN_PROGRESS("in progress"),
	RE_INSTATE("reinstate"),
	RE_INSTATED("reinstated"),
	CANCEL("cancel"),
	CANCELLED("cancelled"),
	DELETE("delete"),
	DELETED("deleted"),
	COMPLETE("complete"),
	DECEASED("deceased"),
	EXPIRED("expired"),
	DISCONTINUED("discontinued")
	;
	
	private String status;
	Status(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
