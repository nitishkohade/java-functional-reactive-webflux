package currying;

import java.util.function.Function;

public class Demo {

	public static void main(String[] args) {
		
//		Function<Integer, Function<Integer, Integer>> fun1 = u -> {
//			return v -> u + v;
//		};
		
		Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;
		
		Function<Integer, Integer> fun2 = fun1.apply(1);
		
		System.out.println(fun2.apply(2));
		System.out.println(fun2.apply(4));

	}

}
