package stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import util.Book;

public class SplitIteratorOperation {

	public static void main(String[] args) {
			
		List<Integer> list = new ArrayList();
		
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(0);
		list.add(1);
		
		Stream<Integer> stream = list.stream();
	
		Spliterator<Integer> spliterator = stream.spliterator();
		
//		System.out.println(Integer.bitCount(spliterator.characteristics()));
		
		// these characteristics help us perform better
		
		SortedSet<Integer> sortedSet = new TreeSet<Integer>();
		
		sortedSet.stream().sorted().forEach(System.out::println);
		// here sorting won't be performed because sortedSet already has this functionality/charcteristic
	
		customSpliterator();
	
	}
	
	public static void customSpliterator() {
		
		Path path = Paths.get("D:\\development\\java project\\functional and reactive programming\\javacode\\src\\main\\java\\stream\\books");
		
		try(Stream<String> lines = Files.lines(path)){
			
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);
			
			Stream<Book> stream = StreamSupport.stream(bookSpliterator, false);
			stream.forEach(book -> System.out.println(book));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
