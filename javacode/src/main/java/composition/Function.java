package composition;

public interface Function<T, R> {
	R apply(T t);
	
	default <V> Function<V, R> compose(Function<V, T> before) {
		return (V v) -> {
			T t = before.apply(v);
			return this.apply(t);
		};
	}
}
