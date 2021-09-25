package reactive;

public class Employee {
	
	private int id;
	private String name;
	private long salary;
	private double rating;
	
	public Employee(int id, String name, long salary, double rating) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		salary = salary;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, Salary=%s, rating=%s]", id, name, salary, rating);
	}
	
	

}
