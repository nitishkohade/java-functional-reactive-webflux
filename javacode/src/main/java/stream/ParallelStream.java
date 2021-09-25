package stream;

import java.util.ArrayList;
import java.util.List;

import util.Employee;

public class ParallelStream {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();

		for(int i = 0; i < 1000; i++) {
			list.add(new Employee("John", 20000));
			list.add(new Employee("Rohn", 3000));
			list.add(new Employee("Tom", 15000));
			list.add(new Employee("Bheem", 8000));
			list.add(new Employee("Shiva", 200));
			list.add(new Employee("Krishna", 50000));
			
			
		}
		long startTime = System.currentTimeMillis();
		
		long a = list.stream()
					.filter(e -> e.getSalary() > 1000)
					.count();
			System.out.println(a);
			
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		long startTime1 = System.currentTimeMillis();
		
		long a1 = list.parallelStream()
					.filter(e -> e.getSalary() > 1000)
					.count();
			System.out.println(a1);
			
		long endTime1 = System.currentTimeMillis();
		
		System.out.println(endTime1 - startTime1);
	}

}
