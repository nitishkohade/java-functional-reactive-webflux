package reactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class SwitchMapOperator {

	public static void main(String[] args) throws InterruptedException {

		Observable<String> source = Observable.just("Johny", "Lily", "Emma", "Ryan", "Darshin")
				.concatMap(
						
						s -> Observable.just(s)
						.delay(
								ThreadLocalRandom.current().nextInt(1500), TimeUnit.MILLISECONDS
								)
						
						
						);
		
		Observable.interval(2, TimeUnit.SECONDS)
		.switchMap(s -> source.doOnDispose(() -> System.out.println("disposed")))
		.subscribe(System.out::println);
		

		Thread.sleep(10000);
		
	}

}
