package com.coforge.Day_07_07_26_Exception;

import java.io.Closeable;
import java.io.IOException;

public class LoginSession implements Closeable{

	public void login() {
		System.out.println("User logged-in");
	}
	
	public void accessPages() {
		System.out.println("User accessing pages");
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Session completed automatically");
	}
	
}
