package com.coforge.beans;

public class Item {
	private int itemId;
	private String itemName;
	private double itemCost;
	
	public Item() {
		super();
	}
	
	public Item(int itemId, String itemName, double itemCost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + "]";
	}
}
