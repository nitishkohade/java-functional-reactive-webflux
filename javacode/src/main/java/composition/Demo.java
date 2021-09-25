package composition;

import util.Square;

public class Demo {
	public static void main(String[] args) {
		
		Function<Square, Integer> fun1 = s -> s.getArea();
		Function<Integer, Double> fun2 = area -> Math.sqrt(area);
		
		//Function<Square, Double> fun3 = fun2.compose(fun1);
		Function<Square, Double> fun3 = fun2.compose(Square::getArea);
		
		Square s = new Square();
		s.setArea(4);
		
		System.out.println(fun3.apply(s));
		
	}
}
