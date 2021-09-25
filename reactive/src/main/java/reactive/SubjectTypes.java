package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class SubjectTypes {

	public static void main(String[] args) throws InterruptedException {

		Subject<String> subject = PublishSubject.create();
//		Subject<String> subject = ReplaySubject.create();
//		Subject<String> subject = BehaviorSubject.create();
 // it will fetch the last data on onComplete call
//		Subject<String> subject = AsyncSubject.create();
		
//		Subject<String> subject = UnicastSubject.create();
		
		Observable<String> ob = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> e+"");
				
		ob.subscribe(subject);
		
		Thread.sleep(3000);
		
		subject.subscribe(e -> System.out.println("Subscriber 1" + e));
//		subject.subscribe(e -> System.out.println("Subscriber 1" + e));
//		
//		subject.onNext("a");
//		subject.onNext("b");
//		subject.onNext("c");
//		
		subject.subscribe(e -> System.out.println("Subscriber 2" + e));
		
		subject.onNext("d");
		subject.onNext("e");
//		subject.onComplete();
		
		Thread.sleep(5000);
		
	}

}
