package com.coforge.Day_07_07_26_Exception;

import java.io.Closeable;
import java.io.IOException;

public class Printer implements Closeable{
	
	public void userPrinter() {
		System.out.println("Printer is ready to use, start Printing");
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Printer closed by Try with resources automatically");
	}
	
}
