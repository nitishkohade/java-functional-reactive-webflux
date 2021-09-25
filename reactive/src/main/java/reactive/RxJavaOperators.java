package reactive;

import io.reactivex.rxjava3.core.Observable;

public class RxJavaOperators {

	public static void main(String[] args) {

		Observable.just(1,2,3,4,5)
			.filter(e -> e > 75)
			.sorted()
			.subscribe(System.out::println);
		
		
		// take and skip
		// captures a specified number of emissions from upstreams and emits
		// distinct
		// elementAt
		// map Observable<T> -> Observable<R>
		// cast Observable<T> -> Observable<R>
		// delay
		// delaysubscription
		// scan
		// repeat
		// reduce, count, contains, all, any Observable<T> -> Single<T>
		// toList, toSortedList(), toMap(), collect  Observable<T> -> Single<List<Observable<T>>>
		// onErrorReturnItem, onErrorReturn
		// retry, OnErrorResumeNext
		
		//doOnNext
		//doOnError
		//doOnSubscribe
		//doOnComplete
	}

}
