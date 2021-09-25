package reactive;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Buffering {

	public static void main(String[] args) throws InterruptedException {
		
//		Observable.range(1, 30)
////		.buffer(4)
////		.buffer(4, 5)
//		.buffer(4, HashSet<Integer>::new)
//		.subscribe(System.out::println);
		
//		Observable.interval(500, TimeUnit.MILLISECONDS)
//		.buffer(2, TimeUnit.SECONDS, 2)
//		.subscribe(System.out::println);
		
		Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);
		
		Observable.interval(1000, TimeUnit.MILLISECONDS)
		.buffer(interval)
//		.window(interval)
		.subscribe(System.out::println);
		
		Thread.sleep(8000);

	}

}
