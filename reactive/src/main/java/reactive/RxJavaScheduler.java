package reactive;

import java.util.Date;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<String> src = Observable
				.just("Pasta", "Pizza", "Fries", "curry", "Chowmein")
//				.subscribeOn(Schedulers.computation());
//				.subscribeOn(Schedulers.io());
//				.subscribeOn(Schedulers.newThread());
				.subscribeOn(Schedulers.single());
		
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
