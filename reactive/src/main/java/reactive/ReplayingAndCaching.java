package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ReplayingAndCaching {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
//		.replay()
//				.replay(2)
				.replay(1,1,TimeUnit.SECONDS)
		.autoConnect();
		
		src.subscribe(e -> System.out.println("Observable 1: " + e));
		
		Thread.sleep(5000);
		
		src.subscribe(e -> System.out.println("Observable 2: " + e));
		
		Thread.sleep(10000);

	}

}
