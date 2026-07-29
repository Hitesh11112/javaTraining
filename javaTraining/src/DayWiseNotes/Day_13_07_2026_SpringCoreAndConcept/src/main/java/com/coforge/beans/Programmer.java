package com.coforge.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class Programmer {
	
	@Value("${Programmer.name}")
	private String name;
	@Value("${Programmer.id}")
	private int id;
	@Value("#{ '${Programmer.skillSet}'.split(',') }")
	private List<String> skillSet;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}
	@Override
	public String toString() {
		return "Programmer [name=" + name + ", id=" + id + ", skillSet=" + skillSet + "]";
	}
	
}