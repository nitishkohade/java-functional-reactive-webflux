package reactive;

public class ObserverDesignPattern {

	public static void main(String[] args) {

		Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");
		
		EndUser user1 = new EndUser("Nitish", book);
		
		System.out.println(book.getInStock());
		
		book.setInStock("In Stock");
		
	}

}
