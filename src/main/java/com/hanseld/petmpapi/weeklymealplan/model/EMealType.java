package com.hanseld.petmpapi.weeklymealplan.model;

public enum EMealType {
	NORMAL("Normal"),
	SPECIAL("Especial");
	
	private String description;
	
	EMealType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
