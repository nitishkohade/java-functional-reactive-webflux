package reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class HelloRxJava {

	public static void main(String[] args) {
		
		Observable<String> source = Observable.create(
				e -> {
					e.onNext("Hello");
					e.onNext("RxJAva");
				}
		);
		
//		source.subscribe(System.out::println);
		
		Observable<Integer> source1 = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {

				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onNext(12);
					emitter.onNext(13);
					emitter.onComplete();
				} catch(Throwable t) {
					emitter.onError(t);
				}
			}
		});
		
		
		Observer<Integer> observer = new Observer<Integer>() {
			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("subscribed");
			}
			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println(t);
			}
			@Override
			public void onError(@NonNull Throwable e) {
				System.out.println(e);
			}
			@Override
			public void onComplete() {
				System.out.println("completed");
			}
		};
		
		source1.subscribe(observer);
		
		
		Observable<Integer> just = Observable.just(1,2,3);
//		just.subscribe(System.out::println);
		
		// from Iterable
		
		List<String> list = new ArrayList();
		list.add("Nitish");
		Observable<String> fromIterable = Observable.fromIterable(list);
		
		
		// range
//		Observable.range(2, 10).subscribe(System.out::println);
		
		// interval
//		Observable.interval(1, TimeUnit.SECONDS);
		
		// fromFuture
//		Observable.fromFuture(future)

	
		//empty, never
		//defer
		// error
		//fromCallable
		
		//defer
		
		Observable<String> source2 = Observable.defer(
					() -> Observable.fromIterable(list)
				);
		
		source2.subscribe(System.out::println);
		list.add("Paul");
		source2.subscribe(
		
				i -> System.out.println(i),
				Throwable::printStackTrace,
				() -> System.out.println("")
				
		);
		
		
		// cold observable
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		Observable<String> s1 = Observable.fromIterable(l);
		s1.subscribe(System.out::println);
		l.add("d");
		s1.subscribe(System.out::println);
		
	
		//hot observable
		// it doesnt start from the beginning
		
		//connectable observable
		// cold to hot
	
	
	
	}

}
