package com.socurites.neo4j.northwind.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Product extends Entity {
	private String productID;
	
	private String productName;
	
	private float unitPrice;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
