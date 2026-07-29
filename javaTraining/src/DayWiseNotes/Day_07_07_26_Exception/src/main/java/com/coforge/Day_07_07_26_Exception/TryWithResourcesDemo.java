package com.coforge.Day_07_07_26_Exception;

import java.io.IOException;

public class TryWithResourcesDemo {
	public static void main(String[] args) throws IOException {
		
		try(Printer printer = new Printer()) {
			
			printer.userPrinter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 