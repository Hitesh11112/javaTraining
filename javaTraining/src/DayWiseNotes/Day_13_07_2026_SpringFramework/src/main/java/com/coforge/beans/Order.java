package com.coforge.beans;

public class Order {
	
	private int orderId;
	private double orderCost;
	private Item item;
	public Order() {
		super();
	}
	
	public Order(int orderId, double orderCost, Item item) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCost;
		this.item = item;
	}
	
	@Override
    public String toString() {
        return "orderId=" + orderId +
                ", orderCost=" + orderCost +
                ", item=" + item +
                '}';
    }
	
}
