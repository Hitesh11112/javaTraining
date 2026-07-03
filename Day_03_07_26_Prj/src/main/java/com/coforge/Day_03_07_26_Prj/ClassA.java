package com.coforge.Day_03_07_26_Prj;

public class ClassA implements Interface1,Interface2{

	public static void main(String[] args) {
	
		ClassA a=new ClassA();
		Interface1 i1=new ClassA();
		Interface2 i2=new ClassA();
		i1.sayHello();
		i2.sayHello();
	}

	@Override
	public void sayHello() {
		System.out.println("Hello......");
		
	}

}
