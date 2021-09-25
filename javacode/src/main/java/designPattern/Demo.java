package designPattern;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import HigherOrderFunction.HigherOrderFunctions;

public class Demo {

	public static void main(String[] args) {
		
		// Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG",
                                 "GeeksforGeeks", "gfg");
  
        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);
	}
	

}
