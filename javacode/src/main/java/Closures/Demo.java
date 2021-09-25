package Closures;

public class Demo {

	public static void main(String[] args) {
		
		int val = 111;
		
		Task lambda = () -> {
			// val = 23
			System.out.println(val);
		};

	}

}
