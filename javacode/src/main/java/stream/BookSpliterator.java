package stream;

import java.util.Spliterator;
import java.util.function.Consumer;

import util.Book;

public class BookSpliterator implements Spliterator<Book> {
	
	private String name;
	private String author;
	private String genre;
	private double rating;
	
	Spliterator<String> baseSpliterator;
	
	public BookSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator = baseSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Book> action) {
		if(
			this.baseSpliterator.tryAdvance(name -> this.name = name) &&
			this.baseSpliterator.tryAdvance(name -> this.author = name) &&
			this.baseSpliterator.tryAdvance(name -> this.genre = name) &&
			this.baseSpliterator.tryAdvance(name -> this.rating = Double.valueOf(name))
		) {
			action.accept(new Book(this.name, this.author, this.genre, this.rating));
			return true;
		}
		
		return false;
	}

	@Override
	public Spliterator<Book> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return this.baseSpliterator.estimateSize() / 4;
	}

	@Override
	public int characteristics() {
		return this.baseSpliterator.characteristics();
	}

}
