package MethodAndConstructorReference;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
	
	public static void main(String... str) {
		System.out.println("ddddd");
		
		Consumer<Integer> c = (t) -> System.out.println(t);
		
		c.accept(56);
		
		Consumer<Integer> c1 = System.out::println;
		
		c1.accept(561);
		
		Supplier<Double> c2 = Math :: random;
		
		System.out.println(c2.get());
		
		Function<String, Integer> function1 = e -> e.length();
		Function<String, Integer> function2 = String :: length;
		
		System.out.println(function2);
		
		callToConstructorReference();
		
	}
	
	public static void callToConstructorReference() {
		
		Function<Runnable, Thread> f1 = r -> new Thread(r);
		
		Function<Thread, Runnable> f2 = Thread :: new;
		
	}

}
