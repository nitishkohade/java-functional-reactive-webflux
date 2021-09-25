package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamContainers {

	public static void main(String[] args) {
		
		
		// streams are not data containers
		// once the stream is processed, it cannot be used again
		// stream becomes empty once you run your operations
		// stream is immutable and can only be used once
		
		// we can reuse the stream when it is not operated
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		
		Stream<Integer> intStream = list.stream();
		
		intStream.forEach(System.out::println);
//		intStream.forEach(System.out::println);
		
		Function<List<Integer>, List<String>> listOperation = l -> l.stream()
		        .filter(i -> i % 2 == 1)
		        .map(i -> i * i)
		        .limit(10)
		        .map(i -> "i :" + i)
		        .collect(Collectors.toList());
		
		
		List<String> result2 = listOperation.apply(list);
		List<String> result1 = listOperation.apply(list);
	    List<String> result3 = listOperation.apply(Arrays.asList(1, 2, 3));
	    
	    
	    

	}

}
