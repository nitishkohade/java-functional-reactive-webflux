package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaSubscribeOn {

	public static void main(String[] args) throws InterruptedException {
		
			Observable
				.just("Pasta", "Pizza", "Fries", "curry", "Chowmein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.subscribeOn(Schedulers.newThread())
				.filter(e -> e.startsWith("P"))
				.subscribe(e -> print(e));
		
		
		Thread.sleep(6000);

	}
	
	public static void print(String element) {
		System.out.println(element + " : Printed By : " + Thread.currentThread().getName());
	}

}
