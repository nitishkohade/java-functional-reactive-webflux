package designPattern;

public class Burger{

	private String burgerType;
	
	public Burger() {
		this.burgerType = "";
	}
	
	public Burger(String burgerType) {
		this.burgerType = burgerType;
	}
	
	public Burger addVegies() {
		return new Burger(this.burgerType += " Vegie");
	}
	
	public Burger addCheese() {
		return new Burger(this.burgerType += " Cheese");
	}
	
	public String toString() {
		return String.format("%s", burgerType + " burger");
	}
}
