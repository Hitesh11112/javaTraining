package SwitchCase;

public class Main {
	public static void main(String[] arg) {
		
		for(int i = 0; i < 11; ++i) {
			switch(i) {			
				case 0:
					System.out.print("start of the for loop\n");
					break;
				case 5:
					System.out.print("Middle of the for loop\n");
					break;
				case 10:
					System.out.print("End of the for loop\n");
					break;
				default:
					System.out.print("current value: "+ i +"\n");
			}
				
		}
	}
}
