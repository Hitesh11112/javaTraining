package com.coforge.Day_07_07_26_Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionDemo {
	
	public static void readFile() {
		try( Scanner sc = new Scanner(new File("Data.txt")) ) {
			System.out.println(sc.nextLine());
			sc.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		readFile();
	}
}
