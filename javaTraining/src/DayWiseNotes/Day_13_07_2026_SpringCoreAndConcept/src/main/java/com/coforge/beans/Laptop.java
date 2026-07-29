package com.coforge.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Component("lap")
public class Laptop {
//	@Value("Dell")
	@Value("${Laptop.brand}")
	private String brand;
//	@Value("80000")
	@Value("${Laptop.price}")
	private double price;
//	@Value("512GB")
	@Value("${Laptop.ramCapacity}")
	private String ramCapacity;
//	@Value("2TB")
	@Value("${Laptop.hardDiskCapacity}")
	private String hardDiskCapacity;
//	@Value("512GB")
	@Value("${Laptop.ssdCapacity}")
	private String ssdCapacity;
//	@Value("Metalic Gray")
	@Value("${Laptop.colour}")
	private String colour;
	
	@Autowired
	private Manufacture manufacture;

}