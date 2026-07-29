package com.coforge.beans;

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

@Component("man")
public class Manufacture {
	
//	@Value("7654")
	@Value("${Manufacture.mid}")
	private int mid;
//	@Value("ABC")
	@Value("${Manufacture.company}")
	private String company;
//	@Value("Chennai")
	@Value("${Manufacture.address}")
	private String address;

}