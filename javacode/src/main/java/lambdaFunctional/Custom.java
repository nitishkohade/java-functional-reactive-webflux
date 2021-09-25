package lambdaFunctional;

public class Custom {

	public static void main(String[] args) {
		CustomInterface icustom = () -> System.out.println("custom function");
		
		icustom.demo();
		
		callCustom(() -> System.out.println("custom function1"));
	}
	
	public static void callCustom(CustomInterface icustom) {
		icustom.demo();
	}

}
