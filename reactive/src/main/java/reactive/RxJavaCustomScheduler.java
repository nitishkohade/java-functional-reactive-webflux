package reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaCustomScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		Scheduler scheduler = Schedulers.from(executor);
		
		Observable<String> src = Observable
				.just("Pasta", "Pizza", "Fries", "curry", "Chowmein")
				.subscribeOn(scheduler)
				.doFinally(executor::shutdown);
		
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		
		Thread.sleep(50000);
		
	}
	
	public static void compute(String e) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by: " + Thread.currentThread().getName() + e);
	}

	
}
