package util;

public class Book {
	
	private String name;
	private String author;
	private String genre;
	private double rating;
	
	public Book(String name, String author, String genre, double rating) {
		this.author = author;
		this.name = name;
		this.genre = genre;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return "".concat(String.format("name:%s", this.name))
		.concat(String.format(" author:%s", this.author))
		.concat(String.format(" genre:%s", this.genre))
		.concat(String.format(" rating:%f", this.rating));
	}
	

}
