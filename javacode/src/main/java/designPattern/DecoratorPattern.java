package designPattern;

import java.util.function.Function;

//decorator pattern where we can modify the behaviour of an object at 
// run time

// inheritance and composition can be used but they are meant for 
// compile time not run time

public class DecoratorPattern {

	public static void main(String[] args) {
		
		Burger burger = new Shop<Burger>(t -> t.addCheese())
				.use(new Shop<Burger>(t -> t.addCheese())
				.use(new Burger()));

	}

}

class Shop<T> {
	Function<T, T> decoration;
	
	public T use(T baseBurger) {
		return decoration.apply(baseBurger);
	}
	
	public Shop(Function<T, T> decoration) {
		this.decoration = decoration;
	}
}