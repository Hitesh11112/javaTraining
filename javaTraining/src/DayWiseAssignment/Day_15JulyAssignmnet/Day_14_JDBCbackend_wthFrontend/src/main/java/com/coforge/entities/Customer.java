package com.coforge.entities;

public class Customer {
	
	private String cName;
	private int cId;
	private String city;
	
	public Customer() {
		super();
	}
	
	public Customer(String cName, int cId, String city) {
		super();
		this.cName = cName;
		this.cId = cId;
		this.city = city;
	}
	
	public String getcName() {
		return cName;
	}
	
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public int getcId() {
		return cId;
	}
	
	public void setcId(int cId) {
		this.cId = cId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Customer [cName=" + cName + ", cId=" + cId + ", city=" + city + "]";
	}
}
