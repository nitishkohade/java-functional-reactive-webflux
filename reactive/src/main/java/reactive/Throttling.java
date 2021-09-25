package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Throttling {

	public static void main(String[] args) {
		
		Observable<String> obs = Observable.create(emitter -> {
			
			emitter.onNext("A");
			
			Thread.sleep(200);
			emitter.onNext("B");
			
			Thread.sleep(100);
			emitter.onNext("c");
			
			Thread.sleep(400);
			emitter.onNext("d");
			
			Thread.sleep(300);
			emitter.onNext("e");
			
			Thread.sleep(800);
			emitter.onNext("f");
			
		});


		obs
//		.throttleFirst(1000, TimeUnit.MILLISECONDS)
//		.throttleLast(1000, TimeUnit.MILLISECONDS)
		.debounce(1000, TimeUnit.MILLISECONDS)
		.subscribe(
				
				item -> System.out.println("onNext: " + item),
				Throwable::printStackTrace,
				() -> System.out.println("onComplete")
				
		);
		
	
	}

}
