package reactive;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure {

	public static void main(String[] args) throws InterruptedException {
		
//		 Observable.range(1, 10)
//		 .flatMap((e) -> {
//			 System.out.println("produced item is: " + e + ":" + Thread.currentThread().getName());
//			 return Observable.just(e).delay(4, TimeUnit.SECONDS);
//		 })
//		 .observeOn(Schedulers.io())
//		 .subscribe(e -> {
//			 sleep(100);
//			 System.out.println("consumed item is: " + e + ":" + Thread.currentThread().getName());
//		 });
//		 
		 
		Flowable.range(1, 1000000)
		 .map((e) -> {
			 System.out.println("produced item is: " + e + ":" + Thread.currentThread().getName());
			 return e;
		 })
		 .observeOn(Schedulers.io())
		 .subscribe(new Subscriber<Integer>() {
			 org.reactivestreams.Subscription s;
			 AtomicInteger count = new AtomicInteger(0);
			 
			 @Override
				public void onSubscribe(org.reactivestreams.Subscription s) {
					this.s = s;		
					System.out.println("Asking for 20 items");
					s.request(20);
					
				}

			@Override
			public void onNext(Integer item) {
				System.out.println("the subscriber comsumed" + item);
				
				if(count.getAndIncrement() % 20 == 0) {
					System.out.println("Asking for next 20 items");
					s.request(20);
				}
			
				sleep(100);
			}
	
			@Override
			public void onError(Throwable throwable) {
				throwable.printStackTrace();					
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");					
			}

			
		 });
		
		
		 Thread.sleep(1000000);

	}

	private static void sleep(int i)  {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
