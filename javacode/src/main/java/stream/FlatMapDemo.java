package stream;

import java.util.stream.Stream;

public class FlatMapDemo {

	public static void main(String[] args) {
	
		Stream<String> a = Stream.of("hello", "there! ");
		Stream<String> b = Stream.of("Learning", "Java? ");
		
		Stream<Stream<String>> of = Stream.of(a, b);
		
//		Stream.of(a, b)
//		.forEach(s -> s.forEach(System.out::println));
		
		Stream.of(a, b)
		.flatMap(e -> {System.out.println("fff"); return e;})
		.forEach(System.out::println);

	}

}
