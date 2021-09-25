package Chaining;

import java.util.Objects;

public interface Consumer<T> {
	void accept(T t);
	default Consumer<T> thenAcceppt(Consumer<T> next){
		Objects.requireNonNull(next);
		return t -> {
			this.accept(t);
			next.accept(t);
		};
	};
}
