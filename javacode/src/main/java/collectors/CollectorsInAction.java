package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import util.Worker;

public class CollectorsInAction {

	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\development\\java project\\functional and reactive programming\\javacode\\src\\main\\java\\collectors\\employee");

		try(Stream<String> lines = Files.lines(path);){
			
			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> spliterator = words.spliterator();
			Spliterator<Worker> workerSpliterator = new WorkerSpliterator(spliterator);
			
			Stream<Worker> workersStream = StreamSupport.stream(workerSpliterator, false);
			
			List<Worker> workers = workersStream.collect(Collectors.toList());
			
			List<String> list = workers.stream()
			.map(employee -> employee.getName())
			.collect(Collectors.toList());
			
			Set<String> set = workers.stream()
					.map(employee -> employee.getName())
					.collect(Collectors.toSet());
			
			SortedSet<Worker> treeset = workers
			.stream()
			.collect(Collectors.toCollection(TreeSet :: new));
			
			Map<Integer, Worker> map = workers.stream()
			.collect(Collectors.toMap(e -> e.getId(), e -> e));
			
			Map<Boolean, List<Worker>> partitionedByGender = workers.stream()
			.collect(
					Collectors.partitioningBy(e -> e.getGender() == 'M')
			);
			
			Map<String, List<Worker>> groupByDesignation = workers.stream()
			.collect(Collectors.groupingBy(e -> e.getDesignation()));
			
			String joinedName = workers.stream()
			.map(e -> e.getName())
			.collect(Collectors.joining(","));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
