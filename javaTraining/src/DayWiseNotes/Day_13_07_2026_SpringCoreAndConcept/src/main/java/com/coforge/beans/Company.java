package com.coforge.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Company {
	
	@Value("${Company.uid}")
	private int uid;
	@Value("${Company.cName}")
	private String cName;
	@Value("${Company.address}")
	private String address;
	
	@Autowired
	private Programmer programmer;
	
	public Company() {
		super();
	}
	public Company(int uid, String cName, String address, Programmer programmer) {
		super();
		this.uid = uid;
		this.cName = cName;
		this.address = address;
		this.programmer = programmer;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Programmer getProgrammer() {
		return programmer;
	}
	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}
	@Override
	public String toString() {
		return "Company [uid=" + uid + ", cName=" + cName + ", address=" + address + ", programmer=" + programmer + "]";
	}
	
	
}