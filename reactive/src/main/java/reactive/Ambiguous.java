package reactive;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ambiguous {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> ob1 = Observable.interval(1, TimeUnit.SECONDS).take(10);
		Observable<Long> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS).take(10);
		

		Observable.amb(Arrays.asList(ob1, ob2))
		.subscribe(System.out::println);
		
		Thread.sleep(11000);
		
	}

}
