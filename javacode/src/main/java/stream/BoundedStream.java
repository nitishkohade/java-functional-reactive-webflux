package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BoundedStream {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(1,4,7,9,4);
		Stream<Integer> streamIntegers = list.stream();
		
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");
		Stream<String> valueStream = map.values().stream();
		Stream<Integer> keyStream = map.keySet().stream();
		map.entrySet().stream().forEach(e -> System.out.println(e));
		
		
		Integer[] integerArr = {1,2,3,4,5};
		Stream<Integer> integerStream = Arrays.stream(integerArr);
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArr);
		
		Stream<String> streamStrings = Stream.of("hey!", "happy");
		
		Builder<Integer> builder = Stream.builder();
		builder.add(1).add(2).add(3).build();
		
		System.out.println(builder);
	 
 
	}

}
