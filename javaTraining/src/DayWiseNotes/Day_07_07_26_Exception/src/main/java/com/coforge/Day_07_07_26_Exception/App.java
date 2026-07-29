package com.coforge.Day_07_07_26_Exception;

/**
 * Hello world!
 *
 */
public class App {
	public static void div(int a, int b) {
//		if(b == 0) {
//			throw new ArithmeticException();
//		}else {
//			System.out.println(a/b);
//		}
		
		try {
			System.out.println(a/b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        //write a code to null exception 
//        int a = 78;
//        Integer b[] = {null,0,10,11};
//        int c = 0;
//        try {
//        	for(int idx = 0; idx <= b.length; ++idx) {
//        		c=a/b[idx];
//        	}
//        }catch (ArithmeticException e) {
//        	e.printStackTrace();
//        	System.out.println(e.getMessage());
//        }catch(NullPointerException e) {
//	    	e.printStackTrace();
//	    }catch (ArrayIndexOutOfBoundsException e) {
//        	e.printStackTrace();
//        }catch (RuntimeException e) {
//	    	e.printStackTrace();
//	    }finally {
//	    	System.out.println("After try catch");
//	    }
//        System.out.println(c);
        
        div(4,0);
        System.out.println("Program completed");
        
        
        
    }
}
