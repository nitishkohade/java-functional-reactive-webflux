package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import util.Worker;

public class CascadeInAction {

	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\development\\java project\\functional and reactive programming\\javacode\\src\\main\\java\\collectors\\employee");

		try(Stream<String> lines = Files.lines(path);){
			
			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> spliterator = words.spliterator();
			Spliterator<Worker> workerSpliterator = new WorkerSpliterator(spliterator);
			
			Stream<Worker> workersStream = StreamSupport.stream(workerSpliterator, false);
			
			List<Worker> workers = workersStream.collect(Collectors.toList());
			
			Map<String, Long> countByDesignation = workers
			.stream()
			.collect(
					Collectors
					.groupingBy(e -> e.getDesignation(), 
							Collectors.counting())
			);
			
			
			Map<String, Double> fundDistribution = workers
			.stream()
			.collect(
					Collectors
					.groupingBy(e -> e.getDesignation(),
							Collectors.summingDouble(e -> e.getSalary())
					)
			);
			
			Map<String, Optional<Worker>> maxSalaryWorkers = workers
					.stream()
					.collect(
							Collectors
							.groupingBy(e -> e.getDesignation(),
									Collectors
									.maxBy(Comparator.comparing(e -> e.getSalary()))
							)
					);
			
			Map<String, Optional<Double>> maxSalary =  workers
			.stream()
			.collect(
					Collectors
					.groupingBy(e -> e.getDesignation(),
							Collectors
							.mapping(e -> e.getSalary(), 
									Collectors.maxBy(Comparator
									.comparing(Function.identity())))
					)
			);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
