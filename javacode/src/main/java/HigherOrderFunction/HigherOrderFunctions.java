package HigherOrderFunction;

public class HigherOrderFunctions {
	
	protected native void m1();

	public static void main(String[] args) {
		
		IFactory<Integer> factory = createFactory(() -> Math.random()*100, r -> r.intValue());
		factory.create();

	}

	public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator){
		return () -> {
			T product = producer.produce();
			return configurator.configure(product);
		};
	}
}
