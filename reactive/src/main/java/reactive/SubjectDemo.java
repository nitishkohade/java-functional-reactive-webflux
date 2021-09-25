package reactive;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectDemo {

	public static void main(String[] args) {
		
		PublishSubject<String> subject = PublishSubject.create();
		
		Subject<String>  subject1 = subject.toSerialized();
		
		subject1.subscribe(e -> System.out.println(e));
		
		subject1.onNext("Hello");
		subject1.onNext("Basic Strong");
		subject1.onNext("Hello1");
		
		subject1.onComplete();

	}

}
