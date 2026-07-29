package com.coforge.entities;

import lombok.ToString;

@ToString
public class Account {

    private long accNo;
    private String accHolderName;
    private String bankName;
    private String address;
    private double balance;

    public Account() {
    	super();
    }

    
    public Account(long accNo, String accHolderName, String bankName, String address, double balance) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.bankName = bankName;
		this.address = address;
		this.balance = balance;
	}


	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accHolderName=" + accHolderName + ", bankName=" + bankName + ", address="
				+ address + ", balance=" + balance + "]";
	}
    
}