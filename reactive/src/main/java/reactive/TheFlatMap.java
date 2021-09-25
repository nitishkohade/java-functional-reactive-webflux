package reactive;

import java.time.LocalTime;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheFlatMap {

	public static void main(String[] args) throws InterruptedException {

		// we can get observables out of the emissions and can run parallely
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chowmein")
		.flatMap(
				e -> Observable.just(e)
				.subscribeOn(Schedulers.computation())
				.map(e1 -> compute(e1)))
		.subscribe(System.out::println);
	
	    Thread.sleep(50000);
	
	}
	
	public static String compute(String element) {
		return element + " : Printed By : " + Thread.currentThread().getName() + " at : " + LocalTime.now();
	}

}
