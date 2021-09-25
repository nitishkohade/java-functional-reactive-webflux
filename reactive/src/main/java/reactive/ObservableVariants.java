package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableVariants {
	
	private static final CompositeDisposable disp = new CompositeDisposable();

	public static void main(String[] args) throws InterruptedException {
		
		// single
		Observable<String> source = Observable.just("Alex", "Justin");
		Observable<String> source1 = Observable.empty();
		
		source
		.first("name")
		.subscribe(System.out::println);
		
		Single<String> singleSource = Single.just("hi");
		
		singleSource.subscribe(System.out::println);
		
		// maybe
		// 0 or 1
		
		source
		.firstElement()
		.subscribe(System.out::println);
		
		source1.firstElement()
		.subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("completed"));
		
		//completable
		// no emissions
		
		Completable completable = Completable.complete();
		completable.subscribe(() -> System.out.println("completed"));
		
		Completable.fromRunnable(() -> System.out.println("some process executing"))
		.subscribe(() -> System.out.println("executed"));
		
		
		// dispose
		// unsubscribe
		Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);
		
		Disposable d1 = src.subscribe(e -> System.out.println("Observer 1:" + e));
		
		Thread.sleep(5000);
		
		d1.dispose();
		
		Disposable d2 = src.subscribe(e -> System.out.println("Observer 2:" + e));
		
		disp.addAll(d1, d2);
		
		disp.dispose();
		
		Thread.sleep(10000);
		
		
		
		
		// disposable inside observer
		
		Observable<Long> src1 = Observable.interval(1, TimeUnit.SECONDS);
		
		src1.subscribe(new Observer<Long>() {
			
			private Disposable d;

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				this.d = d;			
			}

			@Override
			public void onNext(@NonNull Long t) {
			}

			@Override
			public void onError(@NonNull Throwable e) {
			}

			@Override
			public void onComplete() {
			}
			
		});
		
		
	}

}
