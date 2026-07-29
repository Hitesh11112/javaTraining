package com.coforge.day_06July;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product implements Comparable<Product>{
    private int prodId;
    private String prodName;
    private double prodCost;
    private int nou;
	@Override
	public int compareTo(Product o) {
		return this.getProdName().compareTo(o.getProdName());
	}
}