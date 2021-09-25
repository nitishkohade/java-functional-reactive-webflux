package TailRecursion;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println(reFact(5));
		System.out.println(tailReFact(5, 1));

	}
	
	public static long reFact(int n) {
		if(n<=1) {
			return 1;
		} else {
			return n*reFact(n-1);
		}
	}
	
	public static long tailReFact(int n, int a) {
		if(n<=1) {
			return a;
		} else {
			return tailReFact(n-1, n*a);
		}
	}


}
