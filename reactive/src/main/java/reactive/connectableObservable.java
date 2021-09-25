package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class connectableObservable {

	public static void main(String[] args) throws InterruptedException {
		
		//connectable observable
		// cold to hot
		
		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

		source.connect();
		
		source.subscribe(System.out::println);
		
//		Thread.sleep(10000);
		
		source.subscribe(System.out::println);
		
//		Thread.sleep(10000);
		
		
	}

}
