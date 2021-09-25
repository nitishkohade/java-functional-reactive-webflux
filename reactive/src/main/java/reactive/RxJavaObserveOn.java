package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaObserveOn {

	public static void main(String[] args) throws InterruptedException {
		
		// it is used to change the scheduler in the middle of this
		
		Observable
		.just("Pasta", "Pizza", "Fries", "curry", "Chowmein")
		.subscribeOn(Schedulers.computation())
		.map(e -> e.toUpperCase())
		.doOnNext(e -> System.out.println(Thread.currentThread().getName()))
		.observeOn(Schedulers.newThread())
		.filter(e -> e.startsWith("P"))
		.subscribe(e -> print(e));


		Thread.sleep(6000);

	}
	
	public static void print(String element) {
		System.out.println(element + " : Printed By : " + Thread.currentThread().getName());
	}

}
