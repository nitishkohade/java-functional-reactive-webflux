package designPattern;

import java.util.function.Consumer;

public class IteratorPattern {

	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList(new Object[] {1,2,3,4,5});
		
		list.forEach(System.out::println);

	}

}

class MyArrayList {
	Object[] elements = new Object[5];
	
	public MyArrayList(Object[] elements) {
		this.elements = elements;
	}
	
	public void forEach(Consumer<Object> action) {
		for(int i = 0; i < this.elements.length;i++) {
			action.accept(elements[i]);
		}
	}
}








