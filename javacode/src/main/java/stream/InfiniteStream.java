package stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		
//		Stream<Integer> stream = Stream.iterate(0, i -> i+1);
		
		Stream<Integer> stream = Stream.iterate(0, i -> i+1).limit(19);
		
		stream.forEach(System.out::println);
		
		IntStream.iterate(0, i -> i+1);
		
//		Stream.generate(() -> "hello")
//		.forEach(System.out::println);

		Stream.generate(new Random()::nextInt)
		.forEach(System.out::println);
	}

}
